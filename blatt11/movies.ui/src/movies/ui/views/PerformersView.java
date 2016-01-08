package movies.ui.views;

import movies.MoviesPackage;
import movies.Performer;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;
import movies.ui.views.contentprovider.PerformersContentProvider;
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
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
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
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * This view shows all Performers in a project.
 * 
 * @author Alexander Delater
 *
 */
public class PerformersView extends ViewPart implements IdEObjectCollectionChangeObserver {

	private TreeViewer treeViewer;
	private ECPWorkspace workspace;
	private Project activeProject;
	private AdapterImpl adapterImpl;
	
	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "movies.ui.PerformersView";
	
	/**
	 * Instantiates a new performers view.
	 */
	public PerformersView() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		createTree(parent);

		// the adapter is helping to update the view if elements are changed in the workspace
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
						((Project) ((ECPProject) oldValue).getRootContainer())
							.removeIdEObjectCollectionChangeObserver(PerformersView.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
							.addIdEObjectCollectionChangeObserver(PerformersView.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);
		
		if (activeProject!=null) {
			EList<Performer> performers = activeProject.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getPerformer(),new BasicEList<Performer>());
			treeViewer.setInput(performers);
		}
		else {
			treeViewer.setInput(null);
		}
		treeViewer.expandAll();
		
		createToolBar();
	}
	
	/**
	 * Create TreeViewer and all its components.
	 * 
	 * @param parent Composite
	 */
	private void createTree(Composite parent) {
		// filter for TreeViewer
		PatternFilter patternFilter = new PatternFilter();
		final FilteredTree filter = new FilteredTree(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL, patternFilter, true);
	    treeViewer = filter.getViewer();
	    
	    // speed up 
		treeViewer.setUseHashlookup(true);
		
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new PerformersContentProvider());
		treeViewer.setComparator(new ViewerComparator());

		addColumns(treeViewer);
		hookDoubleClick();
	}
	
	/**
	 * This method creates the tool bar.
	 */
	private void createToolBar() {
		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();
		
		Action expand = new Action() {
			@Override
			public void run() {
				treeViewer.expandAll();
			}
		};
		expand.setImageDescriptor(Activator.getImageDescriptor("/icons/expand_all.gif"));
		expand.setToolTipText("Expand");
		menuManager.add(expand);
		
		Action collapse = new Action() {
			@Override
			public void run() {
				treeViewer.collapseAll();
			}
		};
		collapse.setImageDescriptor(Activator.getImageDescriptor("/icons/collapse_all.gif"));
		collapse.setToolTipText("Collapse");
		menuManager.add(collapse);
	}
	
	/**
	 * This method adds special columns to the tree viewer.
	 * 
	 * @param viewer TreeViewer
	 */
	private void addColumns(TreeViewer viewer) {
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		
		TreeViewerColumn tclmPerformerName = new TreeViewerColumn(viewer, SWT.NONE);
		tclmPerformerName.getColumn().setText("Name");
		tclmPerformerName.getColumn().setWidth(200);
		CustomColumnLabelProvider performerNameLabelProvider = new CustomColumnLabelProvider();
		tclmPerformerName.setLabelProvider(performerNameLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmPerformerName, performerNameLabelProvider);
		
		TreeViewerColumn tclmPerformerGender = new TreeViewerColumn(viewer, SWT.NONE);
		tclmPerformerGender.getColumn().setText("Gender");
		tclmPerformerGender.getColumn().setWidth(50);
		ColumnLabelProvider performerGenderLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Performer) {
					return "" + ((Performer) element).getGender(); 
				}
				return "";
			}
		};
		tclmPerformerGender.setLabelProvider(performerGenderLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmPerformerGender, performerGenderLabelProvider);
		
		TreeViewerColumn tclmPerformerRating = new TreeViewerColumn(viewer, SWT.NONE);
		tclmPerformerRating.getColumn().setText("Rating");
		tclmPerformerRating.getColumn().setWidth(50);
		ColumnLabelProvider performerRatingLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Performer) {
					return "" + ((Performer) element).getRating().getLiteral(); 
				}
				return "";
			}
		};
		tclmPerformerRating.setLabelProvider(performerRatingLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmPerformerRating, performerRatingLabelProvider);
	}
	
	/**
	 * On a DoubleClick event, the selected element is opened.
	 */
	private void hookDoubleClick() {
		treeViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event.getSelection();
				EObject selectedElement = (EObject) sel.getFirstElement();
				ActionHelper.openModelElement(selectedElement, treeViewer.getClass().getName());	
			}
		});
	}
	
	/**
	 * Sets the input.
	 *
	 * @param me the new input
	 */
	public void setInput(EList<Performer> me) {
		treeViewer.setInput(me);
		treeViewer.expandAll();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProject() != null) {
			((Project) workspace.getActiveProject().getRootContainer()).removeIdEObjectCollectionChangeObserver(PerformersView.this);
		}
		super.dispose();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#notify(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		treeViewer.update(modelElement, null);
		treeViewer.refresh();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementAdded(org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementRemoved(org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {
		
	}
}
