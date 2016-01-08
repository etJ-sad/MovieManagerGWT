package movies.ui.wizards.queryWizard.pages;

import movies.Movie;
import movies.MoviesPackage;
import movies.ui.util.MovieUtil;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

public class DuplicateDetectionPage extends QueryWizardPage{
	
	/** The Constant PAGE_NAME. */
	public static final String PAGE_NAME = "Konfliktbew�ltigung";
	
	/** The Constant PAGE_DESCRIPTION. */
	public static final String PAGE_DESCRIPTION = "Bitte Movie - Name eingeben.";
	
	private EList<Movie> existingMovies;
	
	private Movie selectedMovie;
	
	
	/** The container. */
	private Composite container;
	
	private Label l1;
	
	private Label m1;
	
	private Label m2;
	
	private Label l2;
	
	private Button b1;
	
	private Button b2;
	
	private Button b3;
	
	private InputValues input;
	
	public DuplicateDetectionPage(InputValues values) {
		super(PAGE_NAME);
		setTitle(PAGE_NAME);
		
		this.input = values;
	}

	@Override
	public void createControl(Composite parent) {

		setContainer(parent);
		container = new Composite(parent, SWT.NULL);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    
	    l1 = new Label(container,SWT.NULL);
	    l1.setText("");
	    l1.setVisible(true);
	    l1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    m1 = new Label(container,SWT.NULL);
	    m1.setText("");
	    m1.setVisible(true);
	    m1.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    m2 = new Label(container,SWT.NULL);
	    m2.setText("");
	    m2.setVisible(true);
	    m2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    
	    l2 = new Label (container,SWT.NULL);
	    l2.setText("what to do: ");
	    l2.setVisible(false);
	    
	    
	    b1 = new Button(container, SWT.RADIO);
	    b1.setText("behalte beide");
	    b1.setVisible(false);
	    
	    b2 = new Button(container, SWT.RADIO);
	    b2.setText("F�ge den Movie nicht hinzu");
	    b2.setVisible(false);
	    
	    b3 = new Button(container, SWT.RADIO);
	    b3.setText("Merge Movies");
	    b3.setVisible(false);
	    
	    
	  SelectionListener sL =(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				Button btn =(Button) e.widget;
				
				if(btn.equals(b1) && b1.getSelection()){
					input.setDuplicateEvent("beide");
					setPageComplete(true);
				}
				if(btn.equals(b2) && b2.getSelection()){
					input.setDuplicateEvent("alt");
					setPageComplete(true);
					
				}
				if(btn.equals(b3) && b3.getSelection()){
					input.setDuplicateEvent("merge");
					setPageComplete(true);
				}
				
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    });
	    
	    b1.addSelectionListener(sL);
	    b2.addSelectionListener(sL);
	    b3.addSelectionListener(sL);
	    
	    
	    
	    
	    setPageComplete(true);
	   
	   
	    setControl(container);
		
	}
	
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		Table t1 = input.getTable();
		l1.setText(((Movie)t1.getSelection()[0].getData()).getTitle());
		
		existingMovies = MovieUtil.getActiveProject().getAllModelElementsbyClass(MoviesPackage.eINSTANCE.getMovie(),  new BasicEList<Movie>());
		
		selectedMovie = (Movie)t1.getSelection()[0].getData();
				
		for(Movie aktExsistingMovie: existingMovies){
			if(aktExsistingMovie.getTitle().equals(selectedMovie.getTitle()) 
	    			|| aktExsistingMovie.getTitle_orig().equals(selectedMovie.getTitle_orig())){
				input.setExisitingMovie(aktExsistingMovie);
				input.setNewMovie(selectedMovie);
				
				
				l1.setText("Duplicate Detected between:");
				m1.setText("Existing:\t"+aktExsistingMovie.getTitle() + " - " + aktExsistingMovie.getTitle_orig());
				m2.setText("New:\t" + selectedMovie.getTitle() +" - " + selectedMovie.getTitle_orig());
				l2.setVisible(true);
				b1.setVisible(true);
				
				b2.setVisible(true);
				
				b3.setVisible(true);
			
				
				
			}
		}
		
	}

	@Override
	public QueryWizardPage getPageType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setContainer(Composite comp) {
		if(comp != null) {
			this.container = comp;
		}
	}
	

}
