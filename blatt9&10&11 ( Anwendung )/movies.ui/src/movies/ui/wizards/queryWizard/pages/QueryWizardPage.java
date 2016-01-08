package movies.ui.wizards.queryWizard.pages;

import org.eclipse.jface.wizard.WizardPage;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryWizardPage.
 */
public  abstract class QueryWizardPage extends WizardPage {

	/**
	 * Instantiates a new query wizard page.
	 *
	 * @param pageName the page name
	 */
	protected QueryWizardPage(String pageName) {
		super(pageName);
	}
	
	/**
	 * Gets the page type.
	 *
	 * @return the page type
	 */
	public abstract QueryWizardPage getPageType();

}
