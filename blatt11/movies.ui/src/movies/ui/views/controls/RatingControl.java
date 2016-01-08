package movies.ui.views.controls;

import java.util.ArrayList;

import movies.Movie;
import movies.Performer;
import movies.impl.MovieImpl;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;

/**
 * Custom Control for showing the Overall Rating of a Movie in the upper right corner.
 * 
 * @author Alexander Delater
 * 
 */
public class RatingControl extends AbstractMEControl {

	private static final String NAME = "Overall Rating";
	private static final String TOOLTIP = "Overall Rating = Rating of Movie + MAX(List of Ratings of all Performers)";
	private Composite mainComposite;
	private Section section;

	private AdapterImpl eAdapter;
	
	private ArrayList<Label> stars;
	private int NUMBER_STARS = 10;

	/**
	 * Instantiates a new rating control.
	 */
	public RatingControl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.
	 * IItemPropertyDescriptor, org.eclipse.emf.ecore.EObject)
	 */
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		// only need 1 itemPropertyDescriptor because only 1 is added in ResourceLocationProvider
		if (modelElement instanceof Movie
				&& ((EAttribute) itemPropertyDescriptor.getFeature(modelElement)).getName().equals("overallRating")) {
			return 2;
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#createControl(org.eclipse.swt.widgets.Composite,
	 * int)
	 */
	protected Control createControl(Composite parent, int style) {
		stars = new ArrayList<Label>(); 
		section = getToolkit().createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(NAME);
		mainComposite = getToolkit().createComposite(section, style);
		mainComposite.setLayout(new GridLayout(NUMBER_STARS, false));

		section.setClient(mainComposite);

		// create the stars
		for (int i = 0; i < NUMBER_STARS; i++) {
			stars.add(createStar());
		}
		
		// eAdapter updates the control on changes
		eAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				updateControl();
			}
		};
		((Movie) getModelElement()).eAdapters().add(eAdapter);

		// add eAdapters to performers: in case a performer is changed, the overall rating for the movie is updated
		EList<Performer> performers = ((Movie) getModelElement()).getPerformers();
		for (Performer performer : performers) {
			performer.eAdapters().add(eAdapter);
		}
		
		// initial update of control
		updateControl();

		return section;
	}
	
	/**
	 * Sets the number of stars.
	 *
	 * @param count the new stars
	 */
	private void setStars(int count) {
		// first, set the number of stars that should be shown
		for (int j = 0; j < count; j++) {
			if (!stars.get(j).isDisposed()) {
				stars.get(j).setImage(Activator.getImageDescriptor("/icons/star.png").createImage());
			} 
		}
		// second, fill up the rest with grey stars
		for (int i = count; i < NUMBER_STARS; i++) {
			if (!stars.get(i).isDisposed()) {
				stars.get(i).setImage(Activator.getImageDescriptor("/icons/star_off.png").createImage());
			}
		}
	}
	
	/**
	 * Creates a star.
	 *
	 * @return the label
	 */
	private Label createStar() {
		Label star = getToolkit().createLabel(mainComposite, null);
		star.setImage(Activator.getImageDescriptor("/icons/star_off.png").createImage());
		star.setToolTipText(TOOLTIP);
		return star;
	}

	/**
	 * Updates the control if anything has changed.
	 */
	public void updateControl() {
		setStars(MovieUtil.overallRating((Movie) getModelElement()));
		MovieImpl.checkSeriesRatingHandling((Movie) getModelElement());
		MovieImpl.checkSeriesPerformerHandling((Movie)getModelElement());
		if (!mainComposite.isDisposed()) {
			mainComposite.layout();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#dispose()
	 */
	@Override
	public void dispose() {
		// remove all adapters
		try {
			ECPWorkspaceManager.getInstance().getWorkSpace().eAdapters().remove(eAdapter);
		} catch (NoWorkspaceException e) {
			// should not happen
			WorkspaceUtil.logException("no workspace", e);
		}
		
		//dispose all controls
		for (Label star : stars) {
			star.dispose();
		}
		if (!mainComposite.isDisposed()) {
			mainComposite.dispose();
		}
	}
}
