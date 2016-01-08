package movies.ui.handler;

import movies.Movie;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for Watching Movies.
 * 
 * @author Alexander Delater
 * 
 */
public class WatchMovieHandler extends AbstractHandler {

	/**
	 * The ID of the editor.
	 */
	public static final String EDITOR_ID = "org.eclipse.emf.ecp.editor";

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject me = getModelElement(event);
		if (me instanceof Movie) {
			new WatchMovieAction(((Movie) me)).execute();
		}
		return null;
	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider.
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static EObject getModelElement(ExecutionEvent event) {
		EObject me = null;
		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(EDITOR_ID)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);
			me = (EObject) obj;
		} else {
			// extract model element from current selection in navigator

			EObject eObject = getSelection(event);
			if (eObject == null) {
				return null;
			}

			me = eObject;
		}

		return me;
	}

	/**
	 * Extract the selected ModelElement from a viewer which is selection provider. This will be called from Handler
	 * classes, which pass the ExecutionEvent.
	 * 
	 * @param event ExecutionEvent to extract the selection from.
	 * @return the selected EObject or null.
	 */
	public static EObject getSelection(ExecutionEvent event) {
		EObject result = null;
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (!(sel instanceof IStructuredSelection)) {
			return null;
		}
		IStructuredSelection ssel = (IStructuredSelection) sel;
		if (ssel.isEmpty()) {
			return null;
		}

		Object obj = ssel.getFirstElement();
		if (obj instanceof EObject) {
			result = (EObject) obj;
		}

		return result;
	}
}
