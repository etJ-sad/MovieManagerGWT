package movies.ui.views; 
import movies.MoviesPackage; 
import movies.Studio; 
import movies.ui.util.MovieUtil; 
import movies.ui.views.contentprovider.StudioContentProvider; 
import movies.ui.views.labelprovider.CustomColumnLabelProvider; 
import movies.ui.views.sort.TreeViewerColumnSorter; 
import org.eclipse.emf.common.notify.Notification; 
import org.eclipse.emf.common.notify.impl.AdapterImpl; 
import org.eclipse.emf.common.util.BasicEList; 
import org.eclipse.emf.common.util.EList; 
import org.eclipse.emf.ecore.EObject; 
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager; 
import org.eclipse.emf.ecp.common.model.NoWorkspaceException; 
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPProject; 
import org.eclipse.emf.ecp.common.model.workSpaceModel.ECPWorkspace; 
import org.eclipse.emf.ecp.common.utilities.ActionHelper; 
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection; 
import org.eclipse.emf.emfstore.common.model.Project; 
import org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver; 
import org.eclipse.emf.emfstore.common.model.util.ModelUtil; 
import org.eclipse.jface.viewers.ColumnLabelProvider; 
import org.eclipse.jface.viewers.DoubleClickEvent; 
import org.eclipse.jface.viewers.IDoubleClickListener; 
import org.eclipse.jface.viewers.IStructuredSelection; 
import org.eclipse.jface.viewers.TreeViewer; 
import org.eclipse.jface.viewers.TreeViewerColumn; 
import org.eclipse.jface.viewers.ViewerComparator; 
import org.eclipse.swt.SWT; 
import org.eclipse.swt.layout.GridData; 
import org.eclipse.swt.widgets.Composite; 
import org.eclipse.swt.widgets.Tree; 
import org.eclipse.ui.dialogs.FilteredTree; 
import org.eclipse.ui.dialogs.PatternFilter; 
import org.eclipse.ui.part.ViewPart; 

public class StudioView extends ViewPart implements IdEObjectCollectionChangeObserver { 
	private TreeViewer treeViewer; 
	private ECPWorkspace workspace; 
	private Project activeProject; 
	private AdapterImpl adapterImpl; 

	/** 
	 * The ID of the view as specified by the extension. 
	 */ 
	public static final String ID = "movies.ui.StudioView"; 
	@Override 
	public void createPartControl(Composite parent) { 
		createTree(parent); 
		// adapter is helping to update the view if elements are changed in the workspace 
		try { 
			workspace = ECPWorkspaceManager.getInstance().getWorkSpace(); 
			activeProject = MovieUtil.getActiveProject(); 
		} catch (NoWorkspaceException e) { 
			ModelUtil.logException("Failed to receive Project!", e); 
			return; 
		} 
		
		if (workspace.getActiveProject() != null) { 
			((Project) workspace.getActiveProject().getRootContainer()).addIdEObjectCollectionChangeObserver(this); 
		} 
		
		adapterImpl = new AdapterImpl() { 
			@Override 
			public void notifyChanged(Notification msg) { 
				if ((msg.getFeatureID(ECPWorkspace.class)) == org.eclipse.emf.ecp.common.model.workSpaceModel.WorkSpaceModelPackage.ECP_WORKSPACE__ACTIVE_PROJECT) { 
					// remove old listeners 
					Object oldValue = msg.getOldValue(); 
					if (oldValue instanceof ECPProject) { 
						((Project) ((ECPProject) oldValue).getRootContainer()) .removeIdEObjectCollectionChangeObserver(StudioView.this); 
					} 
					if (workspace.getActiveProject() != null) { 
						((Project) workspace.getActiveProject().getRootContainer()).addIdEObjectCollectionChangeObserver(StudioView.this); 
						} 
					} 
				} 
			};
			
			workspace.eAdapters().add(adapterImpl); 
			if (activeProject != null) { 
				EList<Studio> studios = activeProject.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getStudio(), 
						new BasicEList<Studio>()); 
				treeViewer.setInput(studios); 
			} else { 
				treeViewer.setInput(null); 
			} 
			treeViewer.expandAll(); 
	} 
	private void createTree(Composite parent) { 
		// filter for TreeViewer 
		PatternFilter patternFilter = new PatternFilter(); 
		final FilteredTree filter = new FilteredTree(parent, SWT.BORDER | 
				SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL, patternFilter, true); 
		treeViewer = filter.getViewer(); 
		treeViewer.setUseHashlookup(true); 
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
		treeViewer.setContentProvider(new StudioContentProvider()); 
		treeViewer.setComparator(new ViewerComparator()); 
		addColumns(treeViewer); 
		hookDoubleClick(); 
	}
	
	private void addColumns(TreeViewer viewer) { 
		Tree tree = viewer.getTree(); 
		tree.setHeaderVisible(true); 
		tree.setLinesVisible(true); 
		TreeViewerColumn studioColumn = new TreeViewerColumn(viewer, SWT.NONE); 
		studioColumn.getColumn().setText("Studio"); 
		studioColumn.getColumn().setWidth(200); 
		CustomColumnLabelProvider studioLabelProvider = new CustomColumnLabelProvider(); 
		studioColumn.setLabelProvider(studioLabelProvider); 
		new TreeViewerColumnSorter(viewer, studioColumn, studioLabelProvider); 
		TreeViewerColumn foundedColumn = new TreeViewerColumn(viewer, SWT.NONE); 
		foundedColumn.getColumn().setText("Founded"); 
		foundedColumn.getColumn().setWidth(80); 
		ColumnLabelProvider foundedLabelProvider = new ColumnLabelProvider() { 
			@Override 
			public String getText(Object element) { 
				if (element instanceof Studio) { 
					Studio studio = (Studio) element; 
					if (studio.getFounded() != null) { 
						return ((Studio) element).getFounded().toString(); 
					} 
				} 
				return ""; 
				} 
		}; 

		foundedColumn.setLabelProvider(foundedLabelProvider); 

		new TreeViewerColumnSorter(viewer, foundedColumn, foundedLabelProvider); 

	} 

	/** 
	 * On a DoubleClick event, the selected element is opened. 
	 */ 
	private void hookDoubleClick() { 
		treeViewer.addDoubleClickListener(new IDoubleClickListener() { 
			public void doubleClick(DoubleClickEvent event) { 
				IStructuredSelection sel = (IStructuredSelection) event.getSelection(); 
				EObject selectedElement = (EObject) sel.getFirstElement(); 
				ActionHelper.openModelElement(selectedElement, 
						treeViewer.getClass().getName()); 
			} 
		}); 
	}
	
	public void setInput(EList<Studio> studios) { 
		treeViewer.setInput(studios); 
		treeViewer.expandAll(); 
	} 

	@Override 

	public void dispose() { 
		workspace.eAdapters().remove(adapterImpl); 
		if (workspace.getActiveProject() != null) { 
			((Project) workspace.getActiveProject().getRootContainer()).removeIdEObjectCollectionChangeObserver(StudioView.this); 
		} 
		super.dispose(); 
	} 

	public void setFocus() { 
		treeViewer.getTree().setFocus(); 
	} 

	public void notify(Notification notification, IdEObjectCollection project, EObject e) { 
		treeViewer.update(e, null); 
		treeViewer.refresh(); 
} 
	public void modelElementAdded(IdEObjectCollection arg0, EObject arg1) { 
		treeViewer.refresh(); 
	} 
	public void modelElementRemoved(IdEObjectCollection arg0, EObject arg1) { 
		treeViewer.refresh(); 
	} 
	public void collectionDeleted(IdEObjectCollection arg0) { 
	} 
}	  
