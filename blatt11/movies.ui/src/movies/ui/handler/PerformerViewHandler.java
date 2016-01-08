package movies.ui.handler;

import movies.MoviesPackage;
import movies.Performer;
import movies.ui.util.MovieUtil;
import movies.ui.views.PerformersView;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * Handler for showing all Performers with related elements in a project. The handler is called from a context menu.
 * 
 * @author Alexander Delater
 * 
 */
public class PerformerViewHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Performer> performers = p.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getPerformer(),
					new BasicEList<Performer>());

			// Open Performer View and set input
			try {
				IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.showView(PerformersView.ID);
				if (view instanceof PerformersView) {
					PerformersView performerView = (PerformersView) view;
					performerView.setInput(performers);
				}
			} catch (PartInitException e) {
				// showView() can throw an exception if view cannot be shown
				e.printStackTrace();
			}
		}
		return null;
	}
}
