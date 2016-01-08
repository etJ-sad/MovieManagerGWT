package movies.ui.handler;

import movies.Movie;
import movies.MoviesPackage;
import movies.ui.util.MovieUtil;
import movies.ui.views.MoviesView;

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
 * Handler for showing all Movies with related elements in a project. The handler is called from a context menu.
 * 
 * @author Alexander Delater
 * 
 */
public class MovieViewHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Movie> movies = p.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),
					new BasicEList<Movie>());

			// Open Movies View and set input
			try {
				IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.showView(MoviesView.ID);
				if (view instanceof MoviesView) {
					MoviesView moviesView = (MoviesView) view;
					moviesView.setInput(movies);
				}
			} catch (PartInitException e) {
				// showView() can throw an exception if view cannot be shown
				e.printStackTrace();
			}
		}
		return null;
	}
}