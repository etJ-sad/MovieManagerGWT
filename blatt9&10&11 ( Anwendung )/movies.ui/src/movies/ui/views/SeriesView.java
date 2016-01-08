package movies.ui.views;

import movies.Episode;
import movies.Performer;
import movies.Season;
import movies.Series;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;
import movies.ui.views.contentprovider.SeriesContentProvider;
import movies.ui.views.labelprovider.CustomColumnLabelProvider;
import movies.ui.views.sort.TreeViewerColumnSorter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * The Class SeriesView.
 */
public class SeriesView extends ViewPart implements IdEObjectCollectionChangeObserver{

	/** The tree viewer. */
	private TreeViewer treeViewer;
	
	/** The workspace. */
	private ECPWorkspace workspace;
	
	/** The active project. */
	private Project activeProject;
	
	/** The adapter impl. */
	private AdapterImpl adapterImpl;
	
	/** The Constant ID. */
	public static final String ID = "movies.ui.SeriesView";
	
	private static final Image checked = Activator.getImageDescriptor("icons/tick.png").createImage();
	private static final Image checked_inactive = Activator.getImageDescriptor("icons/tick_inactive.png").createImage();
	private static final Image checked_inactive_placeholder = Activator.getImageDescriptor("icons/tick_placeholder.png").createImage();
	
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
								.removeIdEObjectCollectionChangeObserver(SeriesView.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
								.addIdEObjectCollectionChangeObserver(SeriesView.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

		if (activeProject != null) {
			SeriesContentProvider scp = new SeriesContentProvider();
			treeViewer.setContentProvider(scp);
			treeViewer.setInput(scp);
		} else {
			treeViewer.setInput(null);
		}
		treeViewer.expandAll();

		createToolBar();
	}
	
	/**
	 * Sets the input.
	 *
	 * @param me the new input
	 */
	public void setInput(EList<Series> me) {
		treeViewer.setInput(me);
		treeViewer.expandAll();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	public void dispose() {
		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProject() != null) {
			((Project) workspace.getActiveProject().getRootContainer())
					.removeIdEObjectCollectionChangeObserver(SeriesView.this);
		}
		super.dispose();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf.emfstore.common.model.IdEObjectCollection)
	 */
	@Override
	public void collectionDeleted(IdEObjectCollection arg0) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementAdded(org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void modelElementAdded(IdEObjectCollection arg0, EObject arg1) {
		treeViewer.refresh();		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementRemoved(org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void modelElementRemoved(IdEObjectCollection arg0, EObject arg1) {
		treeViewer.refresh();
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#notify(org.eclipse.emf.common.notify.Notification, org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		treeViewer.update(modelElement, null);
		treeViewer.refresh();
		
	}


	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}
	
	/**
	 * Creates the tree.
	 *
	 * @param parent the parent
	 */
	private void createTree(Composite parent) {
		// filter for TreeViewer
		PatternFilter patternFilter = new PatternFilter();
		final FilteredTree filter = new FilteredTree(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL
				| SWT.V_SCROLL, patternFilter, true);
		treeViewer = filter.getViewer();

		// speed up
		treeViewer.setUseHashlookup(true);

		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new SeriesContentProvider());
		treeViewer.setComparator(new ViewerComparator());

		addColumns(treeViewer);
		hookDoubleClick();
	}
	
	
	
	/**
	 * Adds the columns.
	 *
	 * @param viewer the viewer
	 */
	private void addColumns(TreeViewer viewer) {
		Tree tree = viewer.getTree();
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);

		TreeViewerColumn tclmSeries = new TreeViewerColumn(viewer, SWT.NONE);
		tclmSeries.getColumn().setText("Series");
		tclmSeries.getColumn().setWidth(200);
		CustomColumnLabelProvider movieLabelProvider = new CustomColumnLabelProvider();
		tclmSeries.setLabelProvider(movieLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmSeries, movieLabelProvider);

		TreeViewerColumn tclmNumberSeasons = new TreeViewerColumn(viewer, SWT.NONE);
		tclmNumberSeasons.getColumn().setText("Seasons");
		tclmNumberSeasons.getColumn().setWidth(50);
		ColumnLabelProvider performerLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Performer, show its name
				if (element instanceof Series) {
					return "" + ((Series) element).getSeasons().size(); // ((Performer) element).getName();
				}
				// else: show number of performers
				return "";
			}
		};
		tclmNumberSeasons.setLabelProvider(performerLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmNumberSeasons, performerLabelProvider);

		TreeViewerColumn tclmNumberEpisodes = new TreeViewerColumn(viewer, SWT.NONE);
		tclmNumberEpisodes.getColumn().setText("Episodes");
		tclmNumberEpisodes.getColumn().setWidth(50);
		ColumnLabelProvider timeLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Season) {
					return "" + ((Season) element).getEpisodes().size();
				}
				// else: show empty field
				return "";
			}
		};
		tclmNumberEpisodes.setLabelProvider(timeLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmNumberEpisodes, timeLabelProvider);
		
		TreeViewerColumn tclmProductionDate = new TreeViewerColumn(viewer, SWT.NONE);
		tclmProductionDate.getColumn().setText("Studio");
		tclmProductionDate.getColumn().setWidth(100);
		ColumnLabelProvider categoryLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Series) {
					return "" + ((Series) element).getStudio();
				}
				// else: show empty field
				return "";
			}
		};
		tclmProductionDate.setLabelProvider(categoryLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmProductionDate, categoryLabelProvider);
		
		TreeViewerColumn tclmBroadcast = new TreeViewerColumn(viewer, SWT.NONE);
		tclmBroadcast.getColumn().setText("Broadcast");
		tclmBroadcast.getColumn().setWidth(100);
		ColumnLabelProvider broadcastLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Series) {
					return "" + ((Series) element).getBroadcastedBy();
				}
				if (element instanceof Season) {
					return "" + ((Season) element).getBroadcastedBy();
				}
				if (element instanceof Episode) {
					return "" + ((Episode) element).getBroadcastedBy();
				}
				// else: show empty field
				return "";
			}
		};
		tclmBroadcast.setLabelProvider(broadcastLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmBroadcast, broadcastLabelProvider);
		
		
		TreeViewerColumn tclmProductionCountry = new TreeViewerColumn(viewer, SWT.NONE);
		tclmProductionCountry.getColumn().setText("Production Country");
		tclmProductionCountry.getColumn().setWidth(100);
		ColumnLabelProvider prodCountLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Series) {
					return "" + ((Series) element).getProductionCountry();
				}
				if (element instanceof Season) {
					return "" + ((Season) element).getProductionCountry();
				}
				if (element instanceof Episode) {
					return "" + ((Episode) element).getProductionCountry();
				}
				// else: show empty field
				return "";
			}
		};
		tclmProductionCountry.setLabelProvider(prodCountLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmProductionCountry, prodCountLabelProvider);
		
		TreeViewerColumn tclmRating = new TreeViewerColumn(viewer, SWT.NONE);
		tclmRating.getColumn().setText("Rating");
		tclmRating.getColumn().setWidth(50);
		ColumnLabelProvider ratingLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Series) {
					return "" + ((Series) element).getRating();
				}
				if (element instanceof Season) {
					return "" + ((Season) element).getRating();
				}
				if (element instanceof Episode) {
					return "" + ((Episode) element).getRating();
				}
				if (element instanceof Performer) {
					return "" + ((Performer) element).getRating();
				}
				// else: show empty field
				return "";
			}
		};
		tclmRating.setLabelProvider(ratingLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmRating, ratingLabelProvider);
		
		TreeViewerColumn tclmLoanableFlag = new TreeViewerColumn(viewer, SWT.NONE);
		tclmLoanableFlag.getColumn().setText("Loanable");
		tclmLoanableFlag.getColumn().setWidth(180);
		ColumnLabelProvider loanableFlagDataProvider = new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				if (element instanceof Series){
					if (((Series) element).isLoanable() == false){
						return "" + true;
					}
				}
				return "" + true;
			}
		};
		tclmLoanableFlag.setLabelProvider(loanableFlagDataProvider);
		new TreeViewerColumnSorter(viewer, tclmLoanableFlag, loanableFlagDataProvider);
		
		
		TreeViewerColumn tclmLoanedFlag = new TreeViewerColumn(viewer, SWT.NONE);
		tclmLoanedFlag.getColumn().setText("Loaned");
		tclmLoanedFlag.getColumn().setWidth(180);
		ColumnLabelProvider loanedFlagDataProvider = new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				if (element instanceof Series){
					if (((Series) element).isLoaned() == true){
						return "" + true;
					}
				}
				return "" + false;
			}
		};
		tclmLoanedFlag.setLabelProvider(loanedFlagDataProvider);
		new TreeViewerColumnSorter(viewer, tclmLoanedFlag, loanedFlagDataProvider);
		
		//Paint the checkbox ticks in the center of the column
		treeViewer.getTree().addListener(SWT.PaintItem, new Listener() {
			@Override
			public void handleEvent(final Event event) {
				if(event.index == 7 || event.index == 8) {
					TreeItem item = (TreeItem) event.item;
					final Image image = item.getImage(event.index);
					if(image != null) {
						if(image == checked_inactive_placeholder) {
							event.gc.drawImage(checked_inactive, event.x - checked.getBounds().width/2 + treeViewer.getTree().getColumn(event.index).getWidth()/2, event.y);
						} else {
							event.gc.drawImage(checked, event.x - checked.getBounds().width/2 + treeViewer.getTree().getColumn(event.index).getWidth()/2, event.y);
						}
					}
				}
			}
		});		
	}
	
	/**
	 * Hook double click.
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
	 * Creates the tool bar.
	 */
	private void createToolBar() {
		IViewSite viewSite = getViewSite();
		if (viewSite != null) {
			IActionBars bars = viewSite.getActionBars();
			IToolBarManager menuManager = bars.getToolBarManager();

			Action expand = new Action() {
				@Override
				public void run() {
					getTreeViewer().expandAll();
				}
			};
			expand.setImageDescriptor(Activator
					.getImageDescriptor("/icons/expand_all.gif"));
			expand.setToolTipText("Expand");
			menuManager.add(expand);

			Action collapse = new Action() {
				@Override
				public void run() {
					getTreeViewer().collapseAll();
				}
			};
			collapse.setImageDescriptor(Activator
					.getImageDescriptor("/icons/collapse_all.gif"));
			collapse.setToolTipText("Collapse");
			menuManager.add(collapse);
		}
	}
	
	
	/**
	 * Gets the tree viewer.
	 *
	 * @return the tree viewer
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

}
