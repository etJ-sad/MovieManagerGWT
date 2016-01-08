package movies.ui.views;

import movies.Movie;
import movies.MoviesPackage;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;

import movies.ui.views.contentprovider.RatedMoviesContentProvider;
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
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ViewPart;

/**
 * This view shows all RatedMovies and their referenced Performers in a project.
 * 
 * @author Alexander Soloninov
 * 
 */
public class RatedMoviesView extends ViewPart implements IdEObjectCollectionChangeObserver {


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
	public static final String ID = "movies.ui.RatedMoviesView";

	/**
	 * Instantiates a new movies view.
	 */
	public RatedMoviesView() {
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
								.removeIdEObjectCollectionChangeObserver(RatedMoviesView.this);
					}
					// add listener to get notified when work items get deleted/added/changed
					if (workspace.getActiveProject() != null) {
						((Project) workspace.getActiveProject().getRootContainer())
								.addIdEObjectCollectionChangeObserver(RatedMoviesView.this);
					}
				}
			}
		};
		workspace.eAdapters().add(adapterImpl);

		if (activeProject != null) {
			EList<Movie> movies = activeProject.getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),
					new BasicEList<Movie>());
			
			treeViewer.setInput(movies);
		} else {
			treeViewer.setInput(null);
		}
		treeViewer.expandAll();

	}

	/**
	 * Create TreeViewer and all its components.
	 * 
	 * @param parent Composite
	 */
	private void createTree(Composite parent) {
		PatternFilter patternFilter = new PatternFilter();
		final FilteredTree filter = new FilteredTree(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.H_SCROLL| SWT.V_SCROLL, patternFilter, true);
		treeViewer = filter.getViewer();
		treeViewer.setUseHashlookup(true);
		treeViewer.getTree().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		//!!!!!!!!!!!!
		treeViewer.setContentProvider(new RatedMoviesContentProvider());
		treeViewer.setComparator(new ViewerComparator());
		addColumns(treeViewer);
		hookDoubleClick();
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
		CustomColumnLabelProvider movieLabelProvider = new CustomColumnLabelProvider(){
			@Override
			public String getText(Object element) {
				if (element instanceof Movie) {	
						return "" + ((Movie) element).getTitle();
				}
				return null;
			}
		};
		tclmMovie.setLabelProvider(movieLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmMovie, movieLabelProvider);

		TreeViewerColumn tclmRating = new TreeViewerColumn(viewer, SWT.NONE);
		tclmRating.getColumn().setText("Rating");
		tclmRating.getColumn().setWidth(50);
		ColumnLabelProvider ratingLabelProvider = new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof Movie) {	
						return "" + ((Movie) element).getRating().getLiteral();
				}
				return null;
			}
		};
		tclmRating.setLabelProvider(ratingLabelProvider);
		new TreeViewerColumnSorter(viewer, tclmRating, ratingLabelProvider);
	
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
					.removeIdEObjectCollectionChangeObserver(RatedMoviesView.this);
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