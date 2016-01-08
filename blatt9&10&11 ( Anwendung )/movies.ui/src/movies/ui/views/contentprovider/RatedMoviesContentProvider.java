package movies.ui.views.contentprovider;
import movies.Movie;
import movies.MoviesPackage;
import movies.Rating;
import movies.ui.util.MovieUtil;


import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.common.model.Project;


/**
 * Content provider for RatedMovies.
 * 
 * @author Alexander Soloninov
 */

public class RatedMoviesContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Constructor.
	 */
	public RatedMoviesContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
	@Override
	public Object[] getElements(Object object) {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Movie> movies = p
					.getAllModelElementsbyClass(
							MoviesPackage.eINSTANCE.getMovie(),
							new BasicEList<Movie>());

			// Do not show episodes
			EList<Movie> ratedMovies = new BasicEList<Movie>();
			for (Movie movie : movies) {
				if((movie instanceof Movie)){
					if(movie.getRating() == Rating.THREE){
						ratedMovies.add(movie);
					}
				}
				if((movie instanceof Movie)){
					if(movie.getRating() == Rating.FOUR){
						ratedMovies.add(movie);
					}
				}
				if((movie instanceof Movie)){
					if(movie.getRating() == Rating.FIVE){
						ratedMovies.add(movie);
					}
				}
			}
			
			return ratedMovies.toArray();
		} else {
			return new Object[] {};
		}
	}
}
