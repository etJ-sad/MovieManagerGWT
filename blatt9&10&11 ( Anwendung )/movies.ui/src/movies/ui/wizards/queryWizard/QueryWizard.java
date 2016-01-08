package movies.ui.wizards.queryWizard;

import java.util.ArrayList;

import movies.Movie;
import movies.ui.dialogs.QueryWizardDialog;
import movies.ui.queryService.AddMoviesLocal;
import movies.ui.wizards.queryWizard.pages.DuplicateDetectionPage;
import movies.ui.wizards.queryWizard.pages.EnterMovieNamePage;
import movies.ui.wizards.queryWizard.pages.MovieMergePage;
import movies.ui.wizards.queryWizard.pages.QueryWizardPage;
import movies.ui.wizards.queryWizard.pages.SelectMoviePage;

import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.TableItem;

// TODO: Auto-generated Javadoc
/**
* The Class QueryWizard.
*/
public class QueryWizard extends Wizard {

	
	/** The is finish. */
	protected  boolean isFinish = true;
	
	/** The pages. */
	protected ArrayList<QueryWizardPage> pages;
	
	/** The obj name. */
	protected String objName;
	
	/** The values. */
	private InputValues input = new InputValues();
	
	private EnterMovieNamePage namePage = new EnterMovieNamePage(input);
	
	private SelectMoviePage moviePage = new SelectMoviePage(input);
	
	private DuplicateDetectionPage duplicatePage = new DuplicateDetectionPage(input);

	private MovieMergePage mergePage = new MovieMergePage(input);
	
	
	
	/**
	* Instantiates a new query wizard.
	*
	* @param pages the pages
	* @param objectName the object name
	*/
	public QueryWizard(ArrayList<QueryWizardPage> pages, String objectName) {
		super();
		setPages(pages);
		setObjectName(objectName);
	}
	
	// default constructor
	/**
	* Instantiates a new query wizard.
	 * @param bWDialog 
	* @param queryWizardHandler
	*/
	public QueryWizard(QueryWizardDialog bWDialog) {
		super();
		ArrayList<QueryWizardPage> pages = new ArrayList<QueryWizardPage>();
		
		pages.add(namePage);
		pages.add(moviePage);
		pages.add(duplicatePage);
		pages.add(mergePage);
	
		setPages(pages);	

		

	}
	
	/**
	* Sets the finish.
	*
	* @param finish the new finish
	*/
	public void setFinish(boolean finish) {
		isFinish = finish;
	}
	
	/* (non-Javadoc)
	* @see org.eclipse.jface.wizard.Wizard#addPages()
	*/
	@Override
	public void addPages() {
		
		for(int i = 0; i < pages.size(); i++) {
			addPage(pages.get(i));
		}
	}
	
	// if the wizard is finish this method will be called
	/* (non-Javadoc)
	* @see org.eclipse.jface.wizard.Wizard#performFinish()
	*/
	@Override
	public boolean performFinish() {
		
		TableItem[] selectedMovies = null;
		
		for(int j = 0; j < pages.size(); j++) {
			if(pages.get(j) instanceof SelectMoviePage) {
				SelectMoviePage pMovies = (SelectMoviePage) pages.get(j);
				selectedMovies = pMovies.getSelectedTableItems(pMovies.getTable());
			}
		}
		if(selectedMovies.length > 0) {
		
			
			
			final Movie movieSelection = (Movie) selectedMovies[0].getData();
			new EMFStoreCommand() {
				protected void doRun() {
					
					AddMoviesLocal aml = new AddMoviesLocal(input);

					if(input.getDuplicateEvent().equals("default")){
						aml.addMovieSimple(movieSelection);
						canFinish();
					}
					if(input.getDuplicateEvent().equals("beide")){
						aml.addMovieSecondTime(movieSelection);
						canFinish();
					}
					if(input.getDuplicateEvent().equals("merge")){
						aml.addMergedMovie();
						canFinish();
					}
				}
			}.doRun();
		}
		return isFinish; // return the status
	}
	
	/**
	* Sets the pages.
	*
	* @param pages the new pages
	*/
	public void setPages(ArrayList<QueryWizardPage> pages) {
	
		boolean nameSet = false;
		boolean movieSet = false;
		boolean duplicateSet = false;
		boolean mergeSet = false;
		
		int indexNameSet = 0, indexMovieSet = 0, indexDuplicateSet = 0, indexMergeSet = 0;
		
		for(int i = 0; i < pages.size(); i++) {
			if(pages.get(i) instanceof EnterMovieNamePage && !(nameSet) ) {
				nameSet = true;
				indexNameSet = i;
			} else if(pages.get(i) instanceof SelectMoviePage && !(movieSet)) {
				movieSet = true;
				indexMovieSet = i;
			} else if (pages.get(i) instanceof DuplicateDetectionPage && !(duplicateSet)){
				duplicateSet = true;
				indexDuplicateSet = i;
			} else if (pages.get(i) instanceof MovieMergePage && !(mergeSet)){
				mergeSet = true;
				indexMergeSet = i;
			}
		
		}
		
		ArrayList<QueryWizardPage> buffer = new ArrayList<QueryWizardPage>();
		if(nameSet) {
			buffer.add(pages.get(indexNameSet));
		}
		
		if(movieSet) {
			buffer.add(pages.get(indexMovieSet));
		}
		if(duplicateSet){
			buffer.add(pages.get(indexDuplicateSet));
		}
		if(mergeSet){
			buffer.add(pages.get(indexMergeSet));
		}
		
		if(buffer != null) {
			this.pages = buffer;
		}
	}
	
	/**
	* Gets the object name.
	*
	* @return the object name
	*/
	public String getObjectName() {
		return this.objName;
	}
	
	
	
	public IWizardPage getNextPage(IWizardPage currentPage){
		if(currentPage instanceof EnterMovieNamePage){
			return moviePage;
		}
		if(currentPage instanceof SelectMoviePage && input.isDuplicateDetected()){
			return duplicatePage;
		}
		
		if(currentPage instanceof DuplicateDetectionPage && input.getDuplicateEvent().equals("merge")){
			return mergePage;
		}
		
		
		return null;
	}
	
	/**
	* Sets the object name.
	*
	* @param name the new object name
	*/
	public void setObjectName(String name) {
		if(name != null && name.trim().length() > 0) {
		// this.objName = name;
		}
	}
	
	
	public boolean performCancel(){
	this.dispose();
	
	return isFinish;
	
	}




}
