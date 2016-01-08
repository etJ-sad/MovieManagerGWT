package movies.ui.util;

import java.util.ArrayList;

import movies.Movie;
import movies.Performer;
import movies.Rating;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Helper class.
 * 
 * @author Alexander Delater
 */
public class MovieUtil {

		 // new attribute and method required for testing
		 /** EMF Project for unit testing */
		 static final Project test = org.eclipse.emf.emfstore.common.model.
				 	ModelFactory.eINSTANCE.createProject();
		 static {
			 org.eclipse.emf.emfstore.client.model.ModelFactory.eINSTANCE
			 .createProjectSpace().setProject(test);
		 }
		
	/**
	 * Get Selection.
	 * 
	 * @param event
	 *            the event
	 * @return selection
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

	/**
	 * Calculate the overall Rating of a Movie based on its references
	 * Performers.
	 * 
	 * @param movie
	 *            the movie
	 * @return overall rating
	 */
	public static int overallRating(Movie movie) {
		int result = 0;
		int maxRatingPerformers = Rating.ZERO.getValue();
		EList<Performer> performer = movie.getPerformers();
		for (Performer p : performer) {
			if (p.getRating().getValue() > maxRatingPerformers) {
				maxRatingPerformers = p.getRating().getValue();
			}
		}
		result = movie.getRating().getValue() + maxRatingPerformers;
		return result;
	}

	/**
	 * Returns the overall rating. The overall rating is calculated as:
	 * ratingMovie + max of ratingPerformers. The input parameter 'ratingMovie'
	 * needs to be between 0 and 5. All elements in the list 'ratingPerformers'
	 * needs to be between 0 and 5. The overall rating is between 0 and 10.
	 * 
	 * @param ratingMovie
	 *            - A single rating of a movie
	 * @param ratingPerformers
	 *            - A list of ratings of performers
	 * @return overallRating between 0 and 10. -1 if any input parameter is out
	 *         of range
	 */
	public static Integer overallRating(Integer ratingMovie,
			ArrayList<Integer> ratingPerformers) {
		// the maximum that is found by the Algorithm
		Integer maxRatingPerformer = 0;
		// check if parameters are not null
		if (ratingMovie == null || ratingPerformers == null) {
			return -1;
		}
		// check range of ratingMovie
		if (ratingMovie < 0 || ratingMovie > 5) {
			return -1;
		}
		int i;
		for (i = 0; i < ratingPerformers.size(); i++) {
			// check range of each element of the list of ratingPerformers
			if (ratingPerformers.get(i) < 0 || ratingPerformers.get(i) > 5) {
				return -1;
			}
			// assign maximum if found
			if (ratingPerformers.get(i) > maxRatingPerformer) {
				maxRatingPerformer = ratingPerformers.get(i);
			}
		}
		if (i > ratingPerformers.size()) {
			return -2;
		}
		return ratingMovie + maxRatingPerformer;
	}

	/**
	 * Returns the active unicase project or null if none is active.
	 * 
	 * @return the active unicase project
	 */
	public static Project getActiveProject() {
		ProjectSpace activeProjectSpace; 
		try {
			activeProjectSpace = (ProjectSpace) ECPWorkspaceManager
					.getInstance().getWorkSpace().getActiveProject()
					.getRootObject();
			if (activeProjectSpace == null) {
				return null;
			}
			if (activeProjectSpace.getProject() != null) {
				return activeProjectSpace.getProject();
			} else {
				return null;
			}
		} catch (NoWorkspaceException e) {
			WorkspaceUtil.logException("no workspace", e);
			return null;
		} catch (NullPointerException e) {
			WorkspaceUtil.logException("error in active project", e);
			return null;
		}
	}

	/**
	 * Gets the limited name.
	 * 
	 * @param name
	 *            the name
	 * @param limit
	 *            the limit
	 * @return the limited name
	 */
	public static String getLimitedName(String name, int limit) {
		try {
			if (name != null && name.length() > limit) {
				// remove end of line characters
				name = name.replaceAll("(\\r|\\n)", "");
				name = name.substring(0, limit).concat("...");
			}
			return name;
		} catch (NullPointerException e) {
			WorkspaceUtil.logException("Error", e);
			return name;
		}
	}
	
	public static Project getTestProject(){
		return test;
	}

}
