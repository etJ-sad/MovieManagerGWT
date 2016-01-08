package movies.ui.wizards.queryWizard.pages;

import movies.Movie;
import movies.MoviesFactory;
import movies.Performer;
import movies.Rating;
import movies.ui.queryService.MovieQueryService;
import movies.ui.queryService.QueryServiceProperties;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

public class MovieMergePage extends QueryWizardPage{
	
	/** The Constant PAGE_NAME. */
	public static final String PAGE_NAME = "Konfliktbew�ltigung";
	
	/** The Constant PAGE_DESCRIPTION. */
	public static final String PAGE_DESCRIPTION = "Merge Page";
	
	private InputValues input;
	
	private MovieQueryService queryService = new MovieQueryService(input);
	

	
	/** The container. */
	private Composite container;
	
	private Movie newMovie;
	
	private Movie existingMovie;
	
	private Label existingLabel;
	
	private Label newLabel;
	
	private Movie newMergedMovie = MoviesFactory.eINSTANCE.createMovie();
	
	
	//Existing Movie
	
	private Label existingMovieTitle;
	
	private Label existingMovieTitle_orig;
	
	private Label exsistingTime;
	
	private Label existingCategory;
	
	private Label existingRating;
	
	//Imported Movie
	

	private Label newMovieTitle;

	private Label newMovieTitle_orig;
	
	private Label newTime;
	
	private Label newCategory;

	private Label newRating;
	
	// Merged Movie
	
	private Label mergedMovieTitle;
	
	private Label mergedMovieTitle_orig;
	
	private Label mergedTime;
	
	private Label mergedCategory;

	private Label mergedRating;
	
	//Buttons
	
	private Button leftTitle;
	
	private Button rightTitle;
	
	private Button leftTitle_orig;
	
	private Button rightTitle_orig;
	
	private Button leftTime;
	
	private Button rightTime;
	
	private Button leftCategory;
	
	private Button rightCategory;
	
	private Button leftRating;
	
	private Button rightRating;
	

	
	public MovieMergePage(InputValues values) {
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
	    layout.numColumns = 5;
	   
	    //------First Row-------Beschreibung
	    
	    newLabel = new Label(container,SWT.CENTER);
	    newLabel.setText("Neuer Movie");
	    newLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    Label tmp1 = new Label(container,SWT.NULL);
	    tmp1.setText(" ");
	    
	    Label tmp2 = new Label(container,SWT.CENTER);
	    tmp2.setText("Meged Movie");
	    tmp2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	    Label tmp3 = new Label(container,SWT.NULL);
	    tmp3.setText(" ");
	    
	    existingLabel = new Label(container,SWT.CENTER);
	    existingLabel.setText("Existing Movie");
	    existingLabel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    
	  //------Second Row-------Titel
	    
	    
	    newMovieTitle = new Label(container,SWT.HORIZONTAL);
	    newMovieTitle.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    leftTitle = new Button(container, SWT.BUTTON1);
	    leftTitle.setText("->");
	    
	    mergedMovieTitle = new Label(container, SWT.HORIZONTAL);
	    mergedMovieTitle.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    rightTitle = new Button(container, SWT.BUTTON1);
	    rightTitle.setText("<-");
	    
	  
	    existingMovieTitle = new Label(container,SWT.NULL);
	    existingMovieTitle.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

	  //------Third Row-------Titel_Orig
	    
	    newMovieTitle_orig = new Label(container,SWT.HORIZONTAL);
	    newMovieTitle_orig.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    leftTitle_orig = new Button(container, SWT.BUTTON1);
	    leftTitle_orig.setText("->");
	    
	    mergedMovieTitle_orig = new Label(container, SWT.HORIZONTAL);
	    mergedMovieTitle_orig.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    rightTitle_orig = new Button(container, SWT.BUTTON1);
	    rightTitle_orig.setText("<-");	    
	  
	    existingMovieTitle_orig = new Label(container,SWT.NULL);
	    existingMovieTitle_orig.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    
	    //------Fourth Row-------Time
	    
	    newTime = new Label(container,SWT.HORIZONTAL);
	    newTime.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    leftTime = new Button(container, SWT.BUTTON1);
	    leftTime.setText("->");
	    
	    mergedTime = new Label(container, SWT.HORIZONTAL);
	    mergedTime.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    rightTime = new Button(container, SWT.BUTTON1);
	    rightTime.setText("<-");
	    
	    exsistingTime = new Label(container,SWT.NULL);
	    exsistingTime.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    
	    //------Sixt Row-------Category
	    
	    
	    newCategory = new Label(container,SWT.HORIZONTAL);
	    newCategory.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    leftCategory = new Button(container, SWT.BUTTON1);
	    leftCategory.setText("->");
	    
	    mergedCategory = new Label(container, SWT.HORIZONTAL);
	    mergedCategory.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    rightCategory = new Button(container, SWT.BUTTON1);
	    rightCategory.setText("<-");
	    
	    existingCategory = new Label(container,SWT.NULL);
	    existingCategory.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    //------Seventh Row-------Rating
	    
	    
	    newRating = new Label(container,SWT.HORIZONTAL);
	    newRating.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    leftRating = new Button(container, SWT.BUTTON1);
	    leftRating.setText("->");
	    
	    mergedRating = new Label(container, SWT.HORIZONTAL);
	    mergedRating.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    rightRating = new Button(container, SWT.BUTTON1);
	    rightRating.setText("<-");
	    
	    existingRating = new Label(container,SWT.NULL);
	    existingRating.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	     
	    
	    
	    Listener buttonPressed = new Listener() {

			@Override
			public void handleEvent(Event event) {
				Button btn = (Button) event.widget;
				if(btn.equals(leftTitle)){
					mergedMovieTitle.setText(newMovieTitle.getText());
					newMergedMovie.setTitle(newMovieTitle.getText());
					newMovieTitle.setBackground(new Color(null,0,200,0));
					existingMovieTitle.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(rightTitle)){
					mergedMovieTitle.setText(existingMovieTitle.getText());
					newMergedMovie.setTitle(existingMovieTitle.getText());
					existingMovieTitle.setBackground(new Color(null,0,200,0));
					newMovieTitle.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(leftTitle_orig)){
					mergedMovieTitle_orig.setText(newMovieTitle_orig.getText());
					newMergedMovie.setTitle_orig(newMovieTitle_orig.getText());
					newMovieTitle_orig.setBackground(new Color(null,0,200,0));
					existingMovieTitle_orig.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(rightTitle_orig)){
					mergedMovieTitle_orig.setText(existingMovieTitle_orig.getText());
					newMergedMovie.setTitle_orig(existingMovieTitle_orig.getText());
					existingMovieTitle_orig.setBackground(new Color(null,0,200,0));
					newMovieTitle_orig.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(leftTime)){
					mergedTime.setText(newTime.getText());
					newMergedMovie.setTime(Integer.parseInt(newTime.getText()));
					newTime.setBackground(new Color(null,0,200,0));
					exsistingTime.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(rightTime)){
					mergedTime.setText(exsistingTime.getText());
					newMergedMovie.setTime(Integer.parseInt(exsistingTime.getText()));
					exsistingTime.setBackground(new Color(null,0,200,0));
					newTime.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(leftCategory)){
					mergedCategory.setText(newCategory.getText());
//					newMergedMovie.setCategory(newCategory.getText().);TODO: Parser schreiben/suchen der Category in String umwandelt
					newCategory.setBackground(new Color(null,0,200,0));
					existingCategory.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(rightCategory)){
					mergedCategory.setText(existingCategory.getText());
					existingCategory.setBackground(new Color(null,0,200,0));
					newCategory.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(leftRating)){
					mergedRating.setText(newRating.getText());
					newMergedMovie.setRating(Rating.getByName(newRating.getText()));
					newRating.setBackground(new Color(null,0,200,0));
					existingRating.setBackground(new Color(null,240,240,240));
				}
				if(btn.equals(rightRating)){
					mergedRating.setText(existingRating.getText());
					newMergedMovie.setRating(Rating.getByName(existingRating.getText()));
					existingRating.setBackground(new Color(null,0,200,0));
					newRating.setBackground(new Color(null,240,240,240));
				}
				
				input.setMergedMovie(newMergedMovie);
			}
	    	
	    };
	    
	    leftTitle.addListener(SWT.Selection, buttonPressed);

	    rightTitle.addListener(SWT.Selection, buttonPressed);
	    
	    rightTitle_orig.addListener(SWT.Selection, buttonPressed);

	    leftTitle_orig.addListener(SWT.Selection, buttonPressed);
	    
	    leftTime.addListener(SWT.Selection, buttonPressed);
	    
	    rightTime.addListener(SWT.Selection, buttonPressed);
	    
	    leftCategory.addListener(SWT.Selection, buttonPressed);
	    
	    rightCategory.addListener(SWT.Selection, buttonPressed);
	    
	    leftRating.addListener(SWT.Selection, buttonPressed);
	    
	    rightRating.addListener(SWT.Selection, buttonPressed);
	    
	    setPageComplete(true);
	   
	   
	    setControl(container);
		
	}
	
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		this.newMovie = input.getNewMovie();
		this.existingMovie = input.getExisitingMovie();
		newMovie = queryService.completeMovieInformation(newMovie);
		//Performer Selection auf erster Wizard Page
		if(!QueryServiceProperties.CHECK_PDERFORMER){
			newMovie.getPerformers().removeAll(newMovie.getPerformers());
		}
		//Informationen �ber weitere Performer abfragen
		for(Performer nPerformer: newMovie.getPerformers()){
			nPerformer = queryService.completePerformerInformation(nPerformer);
		}
		
		
		
		newMovieTitle.setText(newMovie.getTitle());
		existingMovieTitle.setText(existingMovie.getTitle());
		
		newMovieTitle_orig.setText(newMovie.getTitle_orig());
		existingMovieTitle_orig.setText(existingMovie.getTitle_orig());
		
		newTime.setText(newMovie.getTime() + "");
		exsistingTime.setText(existingMovie.getTime() + "");
		
		newCategory.setText(newMovie.getCategory().getName() + "");
		existingCategory.setText(existingMovie.getCategory().getName() + "");
		
		newRating.setText(newMovie.getRating().getName());
		existingRating.setText(existingMovie.getRating().getName());
		
		
		
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
