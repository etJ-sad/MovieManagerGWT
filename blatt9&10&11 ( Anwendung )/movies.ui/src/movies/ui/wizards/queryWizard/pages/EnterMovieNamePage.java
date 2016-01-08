package movies.ui.wizards.queryWizard.pages;

import movies.ui.queryService.QueryServiceProperties;
import movies.ui.wizards.queryWizard.InputValues;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryWizardPageName.
 */
public class EnterMovieNamePage extends QueryWizardPage {
	
	/** The Constant PAGE_NAME. */
	public static final String PAGE_NAME = "Suche nach einem Movie";
	
	/** The Constant PAGE_DESCRIPTION. */
	public static final String PAGE_DESCRIPTION = "Bitte Movie - Name eingeben.";
	
	/** The container. */
	private Composite container;
	
	/** The movie name. */
	private String movieName = "";
	
	/** The input. */
	private InputValues input;
	
	private final boolean checkPerformer = QueryServiceProperties.CHECK_PDERFORMER;
	
	/**
	 * Instantiates a new query wizard page name.
	 *
	 * @param values the values
	 */
	public EnterMovieNamePage(InputValues values) {
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
	    setPageComplete(false);
	   
	    Label label1 = new Label(container, SWT.NULL);
	    label1.setText("Movie Name: ");
	    
	    final Text movieIn = new Text(container, SWT.BORDER);
	    // complete movie data case 
	    // text has already been set by user selection of the movie
	    if(input.getMovieName().length() > 0) {
	    	movieIn.setText(input.getMovieName());	
	    	setPageComplete(true);
	    }
	    
	    final Button checkPerformers = new Button(container, SWT.CHECK);
	    checkPerformers.setText("Füge Performer hinzu");
	    checkPerformers.setSelection(checkPerformer);
	    input.setCheckPerformers(checkPerformer);
	    
	    movieIn.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    
	    movieIn.addModifyListener(new ModifyListener() {
			  public void modifyText(ModifyEvent event) {
				  movieName = movieIn.getText();
				  if(movieName.length() > 0){
					  setPageComplete(true);
					  input.setMovieName(movieName);					  
				  }
			  }
		  });	
	    
	    checkPerformers.addSelectionListener(new SelectionListener(){

			@Override
			public void widgetSelected(SelectionEvent e) {
				if(e.widget.equals(checkPerformers)){
					input.setCheckPerformers(checkPerformers.getSelection());
				}
				
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    setControl(container);
	}

	/**
	 * Sets the container.
	 *
	 * @param comp the new container
	 */
	public void setContainer(Composite comp) {
		if(comp != null) {
			this.container = comp;
		}
	}
	

	/* (non-Javadoc)
	 * @see movies.ui.wizards.pages.QueryWizardPage#getPageType()
	 */
	@Override
	public QueryWizardPage getPageType() {
		return new EnterMovieNamePage(input);
	}
	
	
}
