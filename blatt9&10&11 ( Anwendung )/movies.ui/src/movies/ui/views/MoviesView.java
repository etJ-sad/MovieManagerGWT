package movies.ui.views;

import movies.Episode;
import movies.Movie;
import movies.MoviesPackage;
import movies.Performer;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;
import movies.ui.views.contentprovider.MoviesContentProvider;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * This view shows all Movies and their referenced Performers in a project.
 * 
 * @author Alexander Delater
 * 
 */
public class MoviesView extends ViewPart implements IdEObjectCollectionChangeObserver {

	private TreeViewer treeViewer;
	private ECPWorkspace workspace;
	private Project activeProject;
	private AdapterImpl adapterImpl;
	
	private static final Image checked = Activator.getImageDescriptor("icons/tick.png").createImage();
	private static final Image checked_inactive = Activator.getImageDescriptor("icons/tick_inactive.png").createImage();
	private static final Image checked_inactive_placeholder = Activator.getImageDescriptor("icons/tick_placeholder.png").createImage();

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "movies.ui.MoviesView";

	/**
	 * Instantiates a new movies view.
	 */
	public MoviesView() {
	}

	/*
	 * (non-Javadoc)
	 * 
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
								.removeIdEObjectCollectionChangeObserver(MoviesView.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
								.addIdEObjectCollectionChangeObserver(MoviesView.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

		if (activeProject != null) {
			EList<Movie> movies = activeProject.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),
					new BasicEList<Movie>());
			movies.removeAll(activeProject.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getEpisode(),
					new BasicEList<Episode>()));
			
			treeViewer.setInput(movies);
		} else {
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
		final FilteredTree filter = new FilteredTree(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL
				| SWT.V_SCROLL, patternFilter, true);
		treeViewer = filter.getViewer();

		// speed up
		treeViewer.setUseHashlookup(true);

		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeViewer.setContentProvider(new MoviesContentProvider());
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

		final Action showPerformers = new Action("Show linked Performers", SWT.TOGGLE) {
			@Override
			public void run() {
				// storing the value of the toggle button
				Activator.setShowingPerformers(isChecked());
				// by refreshing the view, the content provider is called and the new content is shown, either with
				// packages or not
				treeViewer.refresh();
				treeViewer.expandAll();
			}
		};
		showPerformers.setImageDescriptor(Activator.getImageDescriptor("/icons/Performers.png"));
		showPerformers.setChecked(Activator.isShowingPerformers());
		menuManager.add(showPerformers);

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

		TreeViewerColumn tclmMovie = new TreeViewerColumn(viewer, SWT.NONE);
		tclmMovie.getColumn().setText("Movie");
		tclmMovie.getColumn().setWidth(200);
		CustomColumnLabelProvider movieLabelProvider = new CustomColumnLabelProvider();
		tclmMovie.setLabelProvider(movieLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmMovie, movieLabelProvider);

		TreeViewerColumn tclmPerformer = new TreeViewerColumn(viewer, SWT.NONE);
		tclmPerformer.getColumn().setText("Performer");
		tclmPerformer.getColumn().setWidth(80);
		ColumnLabelProvider performerLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Performer, show its name
				if (element instanceof Movie) {
					return "" + ((Movie) element).getPerformers().size(); // ((Performer) element).getName();
				}
				// else: show number of performers
				return "";
			}
		};
		tclmPerformer.setLabelProvider(performerLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmPerformer, performerLabelProvider);

		TreeViewerColumn tclmTime = new TreeViewerColumn(viewer, SWT.NONE);
		tclmTime.getColumn().setText("Time");
		tclmTime.getColumn().setWidth(50);
		ColumnLabelProvider timeLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Movie) {
					return "" + ((Movie) element).getTime();
				}
				// else: show empty field
				return "";
			}
		};
		tclmTime.setLabelProvider(timeLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmTime, timeLabelProvider);

		TreeViewerColumn tclmCategory = new TreeViewerColumn(viewer, SWT.NONE);
		tclmCategory.getColumn().setText("Category");
		tclmCategory.getColumn().setWidth(80);
		ColumnLabelProvider categoryLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Movie) {
					return "" + ((Movie) element).getCategory().getName();
				}
				// else: show empty field
				return "";
			}
		};
		tclmCategory.setLabelProvider(categoryLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmCategory, categoryLabelProvider);

		TreeViewerColumn tclmRating = new TreeViewerColumn(viewer, SWT.NONE);
		tclmRating.getColumn().setText("Rating");
		tclmRating.getColumn().setWidth(50);
		ColumnLabelProvider ratingLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Movie) {
					return "" + ((Movie) element).getRating().getLiteral();
				}
				if (element instanceof Performer) {
					return "" + ((Performer) element).getRating().getLiteral();
				}
				// else: show empty field
				return "";
			}
		};
		tclmRating.setLabelProvider(ratingLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmRating, ratingLabelProvider);

		TreeViewerColumn tclmOverallRating = new TreeViewerColumn(viewer, SWT.NONE);
		tclmOverallRating.getColumn().setText("Overall Rating");
		tclmOverallRating.getColumn().setWidth(100);
		ColumnLabelProvider overallRatingLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Movie) {
					return "" + MovieUtil.overallRating(((Movie) element));
				}
				// else: show empty field
				return "";
			}
		};
		tclmOverallRating.setLabelProvider(overallRatingLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmOverallRating, overallRatingLabelProvider);

		TreeViewerColumn tclmWatchDate = new TreeViewerColumn(viewer, SWT.NONE);
		tclmWatchDate.getColumn().setText("Watch Date");
		tclmWatchDate.getColumn().setWidth(180);
		ColumnLabelProvider watchDateLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				// if Movie, show its time
				if (element instanceof Movie) {
					if (((Movie) element).getLastWatchDate() != null) {
						return "" + ((Movie) element).getLastWatchDate().toString();
					}
				}
				// else: show empty field
				return "";
			}
		};
		tclmWatchDate.setLabelProvider(watchDateLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmWatchDate, watchDateLabelProvider);
		
		
		TreeViewerColumn tclmLoanableFlag = new TreeViewerColumn(viewer, SWT.NONE);
		tclmLoanableFlag.getColumn().setText("Loanable");
		tclmLoanableFlag.getColumn().setWidth(180);
		ColumnLabelProvider loanableFlagDataProvider = new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				if (element instanceof Movie){
					if (((Movie) element).isLoanable() == false){
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
				if (element instanceof Movie){
					if (((Movie) element).isLoaned() == true){
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
	public void setInput(EList<Movie> me) {
		treeViewer.setInput(me);
		treeViewer.expandAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	@Override
	public void dispose() {
		workspace.eAdapters().remove(adapterImpl);
		if (workspace.getActiveProject() != null) {
			((Project) workspace.getActiveProject().getRootContainer())
					.removeIdEObjectCollectionChangeObserver(MoviesView.this);
		}
		super.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	public void setFocus() {
		treeViewer.getTree().setFocus();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#notify(org.eclipse.emf.common.notify
	 * .Notification, org.eclipse.emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void notify(Notification notification, IdEObjectCollection project, EObject modelElement) {
		treeViewer.update(modelElement, null);
		treeViewer.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementAdded(org.eclipse.emf
	 * .emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementAdded(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#modelElementRemoved(org.eclipse.
	 * emf.emfstore.common.model.IdEObjectCollection, org.eclipse.emf.ecore.EObject)
	 */
	public void modelElementRemoved(IdEObjectCollection project, EObject modelElement) {
		treeViewer.refresh();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.emfstore.common.model.util.IdEObjectCollectionChangeObserver#collectionDeleted(org.eclipse.emf
	 * .emfstore.common.model.IdEObjectCollection)
	 */
	public void collectionDeleted(IdEObjectCollection collection) {

	}
}
