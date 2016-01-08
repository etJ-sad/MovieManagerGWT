package movies.ui.views.contentprovider;

import movies.MoviesPackage; 
import movies.Studio; 
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory; 
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.common.model.Project; 
import org.eclipse.jface.viewers.Viewer;

public class StudioContentProvider extends AdapterFactoryContentProvider { 
	public StudioContentProvider() { 
		super(new ComposedAdapterFactory( 
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)); 
	}

	@Override public Object[] getElements(Object object) { 
	// get active project 
	Project p = MovieUtil.getActiveProject(); 
	// get all elements of type Studio
	EList<Studio> studios = p.getAllModelElementsbyClass(
			MoviesPackage.eINSTANCE.getStudio(),new BasicEList<Studio>());
	return studios.toArray(); 
	}

	@Override public boolean hasChildren(Object object) { 
		if (object instanceof Studio) {
			Studio studio = (Studio) object; 
			return studio.getProducedMovies().size() > 0 ? true : false; 
			} 
		return false; 
	}
	

	@Override public Object[] getChildren(Object object) { 
		if (object instanceof Studio) { 
			Studio studio = (Studio) object; 
			return studio.getProducedMovies().toArray(); 
			} 
		return null; 
	} 
	
	@Override 
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { 
		super.inputChanged(viewer, oldInput, newInput); 
	} 
	
}