package movies.ui.views.contentprovider;

import movies.Episode;
import movies.MoviesPackage;
import movies.Season;
import movies.Series;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * The Class SeriesContentProvider.
 */
public class SeriesContentProvider extends AdapterFactoryContentProvider{

	/**
	 * Instantiates a new series content provider.
	 */
	public SeriesContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object object) {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Series> series = p.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getSeries(),
					new BasicEList<Series>());
			return series.toArray();
		} else {
			return new Object[] {};
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object object) {
		if(object instanceof Series){
			if(((Series)object).getSeasons().size() > 0){
				return true;
			}
		}
		if(object instanceof Season){
			if(((Season)object).getEpisodes().size() > 0){
				return true;
			}
		}
		if(object instanceof Episode){
			if(((Episode)object).getPerformers().size() > 0){
				return true;
			}
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object object) {
		if(object instanceof Series){
			Series series = (Series)object;
			return series.getSeasons().toArray();
		}
		if(object instanceof Season){
			Season season = (Season)object;
			return season.getEpisodes().toArray();
		}
		if(object instanceof Episode){
			Episode episode = (Episode)object;
			return episode.getPerformers().toArray();
		}
		
		return null;
	}


}
