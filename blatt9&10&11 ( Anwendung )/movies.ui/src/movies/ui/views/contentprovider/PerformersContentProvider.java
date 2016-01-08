package movies.ui.views.contentprovider;

import movies.MoviesPackage;
import movies.Performer;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.emfstore.common.model.Project;

/**
 * Content provider for Performers.
 * 
 * @author Alexander Delater
 */
public class PerformersContentProvider extends AdapterFactoryContentProvider {

	/**
	 * Constructor.
	 */
	public PerformersContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		Project p = MovieUtil.getActiveProject();
		if (p != null) {
			EList<Performer> performers = p.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getPerformer(),
					new BasicEList<Performer>());
			return performers.toArray();
		} else {
			return new Object[] {};
		}
	}

	/**
	 * {@inheritDoc} Returns true if input has any child elements.
	 */
	@Override
	public boolean hasChildren(Object object) {
		return false;
	}

	/**
	 * {@inheritDoc} Returns super.getChildren plus any direct child elements of the model element.
	 */
	@Override
	public Object[] getChildren(Object object) {
		return null;
	}
}