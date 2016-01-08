package movies.ui.listener;

import movies.MoviesPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

/**
 * The listener interface for receiving link events. The class that is
 * interested in processing a link event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addLinkListener<code> method. When
 * the link event occurs, that object's appropriate
 * method is invoked.
 * 
 * @see LinkEvent
 * 
 * @author Alexander Delater
 */
public class LinkListener extends
		org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl {

	/** The Constant RENDER. */
	private static final int RENDER = 2;

	/** The Constant DONOTRENDER. */
	private static final int DO_NOT_RENDER = -1;

	/**
	 * Instantiates a new link listener.
	 */
	public LinkListener() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecp.editor.mecontrols.melinkcontrol.MELinkControl#canRender
	 * (org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 * org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			EObject link, EObject contextModelElement) {
		if (contextModelElement.eClass().equals(getFilterClass())) {
			hookListener(link, contextModelElement);
			return RENDER;
		} else {
			return DO_NOT_RENDER;
		}
	}

	/**
	 * Gets the filter class.
	 * 
	 * @return the filter class
	 */
	public EClass getFilterClass() {
		// TODO can be changed to listen to changes of other elements
		return MoviesPackage.eINSTANCE.getMovie();
	}

	/**
	 * Hook listener.
	 * 
	 * @param link
	 *            the link
	 * @param contextModelElement
	 *            the context model element
	 */
	public void hookListener(EObject link, EObject contextModelElement) {
		// TODO implement appropriate method here
	}

}
