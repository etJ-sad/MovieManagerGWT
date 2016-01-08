package movies.ui.wizards.queryWizard.pages;

import java.util.ArrayList;

import movies.Movie;
import movies.MoviesPackage;
import movies.ui.queryService.MovieQueryService;
import movies.ui.util.MovieUtil;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;


// TODO: Auto-generated Javadoc
/**
 * The Class QueryWizardPageMovie.
 */
public class SelectMoviePage extends QueryWizardPage {

	// Constant values of the page
	/** The Constant PAGE_NAME. */
	public static final String PAGE_NAME = "Den gesuchten Movie auswählen";
	
	/** The Constant PAGE_DESCRIPTION. */
	public static final String PAGE_DESCRIPTION = " ";
	
	// Composite which contains the parent (whyever....)
	/** The container. */
	private Composite container;
	
	/** The table. */
	private Table table;
	
	/** The input. */
	private InputValues input;
	
	/** The table item array. */
	private ArrayList<TableItem> tableItemArray;
	
	private EList<Movie> existingMovies = MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),  new BasicEList<Movie>());
	

	
	

	/** The parser. */
	private MovieQueryService movieQueryService = new MovieQueryService(input);
	
	/** The movies. */
	private EList<Movie> movies;


	

	
	/**
	 * Instantiates a new query wizard page movie.
	 *
	 * @param values the values
	 * @param qwDialog 
	 * @param queryWizardHandler 
	 */
	public SelectMoviePage(InputValues values) {
		super(PAGE_NAME);
		setTitle(PAGE_NAME);
		setDescription(PAGE_DESCRIPTION);
		input = values;
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		
		setContainer(parent);
		container = new Composite(parent, SWT.NULL);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 1;
	    	    
	    Label label1 = new Label(container, SWT.NULL);
	    label1.setText("Select the movie: ");
	    
	    
	    table = new Table(container, SWT.NULL);
	    
	    table.addListener(SWT.Selection, new Listener() {
	        public void handleEvent(Event e) {
	          Movie movie = ((Movie)table.getSelection()[0].getData());
	          duplicateDetection(movie);
	          setPageComplete(true);
	          input.setTable(table);
	        }
	      });

	    table.setLayoutData(new GridData(GridData.FILL_HORIZONTAL,GridData.FILL_VERTICAL));
	    
	    tableItemArray = new ArrayList<TableItem>();

	    // Required to avoid an error in the system
	    setControl(container);
	    setPageComplete(true);
	}
	
	// Setter
	/**
	 * Sets the container.
	 *
	 * @param comp the new container
	 */
	public void setContainer(Composite comp) {
		if(comp != null) {
			this.container = comp;
		} else {
			// Insert some useful Exception-Handling here!
		}
	}	
	// Get the selected tableitems
	/**
	 * Gets the selected table items.
	 *
	 * @param table the table
	 * @return the selected table items
	 */
	public TableItem[] getSelectedTableItems(Table table) {
		return table.getSelection();
	}
	
	// get the used table
	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/* (non-Javadoc)
	 * @see movies.ui.wizards.pages.QueryWizardPage#getPageType()
	 */
	@Override
	public QueryWizardPage getPageType() {
		return new SelectMoviePage(input);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
	 */
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			setTitle(PAGE_NAME);
			setDescription(PAGE_DESCRIPTION);
			movies = movieQueryService.searchForMoviesByString(input.getMovieName());
			
			if(movies !=  null && movies.size() > 0){
			    for(int i = 0; i < movies.size(); i++) {
			    	tableItemArray.add(new TableItem(table, SWT.NULL));
			    
			    	TableItem currentTItem = tableItemArray.get(i);
			    	currentTItem.setData(movies.get(i));
			    	currentTItem.setText(movies.get(i).getTitle() + " - "+ movies.get(i).getTitle_orig());
			    	
			
			    }
			} 
		}
		
	}
	public void duplicateDetection(Movie movie2){
		Movie movie = movie2;
		
			for(Movie exMovie: existingMovies){
	    		if(exMovie.getTitle().equals(movie.getTitle()) 
	    				|| exMovie.getTitle_orig().equals(movie.getTitle_orig())){
	    			input.setDuplicateDetected(true);
	    			break;
	    		}else{
	    			input.setDuplicateDetected(false);
	    		}
	    	}
		
	}


}



