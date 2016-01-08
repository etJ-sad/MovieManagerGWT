package movies.ui.views.labelprovider;

import org.eclipse.emf.ecp.common.EMFColumnLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * Custom label provider.
 * 
 * @author Alexander Delater
 */
public class CustomColumnLabelProvider extends EMFColumnLabelProvider implements ITableLabelProvider {

	/**
	 * Instantiates a new custom column label provider.
	 */
	public CustomColumnLabelProvider() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecp.common.EMFColumnLabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		return super.getImage(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecp.common.EMFColumnLabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		return super.getText(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		return getText(element);
	}

}