package movies.ui.handler;

import movies.MoviesPackage;
import movies.Series;
import movies.ui.util.MovieUtil;
import movies.ui.views.SeriesView;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;


public class SeriesViewHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Series> series = p.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getSeries(),
					new BasicEList<Series>());

			// Open Movies View and set input
			try {
				IViewPart view = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.showView(SeriesView.ID);
				if (view instanceof SeriesView) {
					SeriesView seriesView = (SeriesView) view;
					seriesView.setInput(series);
				}
			} catch (PartInitException e) {
				// showView() can throw an exception if view cannot be shown
				e.printStackTrace();
			}
		}
		return null;
	}
}