package movies.ui.dialogs;

import movies.Episode;
import movies.Movie;
import movies.Season;
import movies.Series;
import movies.ui.util.AssociateMovieToSeasonUtil;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Dialog to associate a movie to a season.
 * 
 */
public class AssociateMovieToSeasonDialog extends TitleAreaDialog {
	private final static int LIST_HEIGHT = 300; // Default list height
	private final static int LIST_FLAGS = SWT.SINGLE | SWT.BORDER
			| SWT.V_SCROLL | SWT.H_SCROLL; // Default list flags

	private Movie movie; // The movie that is being associated to a season

	private ListViewer seriesListV; // List widget for series
	private ListViewer seasonListV; // List widget for seasons

	private boolean disableOK; // Flag to indicate whether the OK button has to
								// be disabled

	public AssociateMovieToSeasonDialog(Shell parentShell, EObject object) {
		super(parentShell);
		this.movie = (Movie) object;
	}

	@SuppressWarnings("unchecked")
	protected Control createDialogArea(Composite parent) {
		setTitle("Associate '" + movie.getTitle() + "' to a Season");
		setMessage("Select the series and season you want to associate the movie to.");

		// Contains the separator and the actual content
		Composite areaComp = (Composite) super.createDialogArea(parent);

		// Contains the actual content
		Composite mainComp = new Composite(areaComp, SWT.NONE);
		mainComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout mainCompGL = new GridLayout(2, true);
		mainComp.setLayout(mainCompGL);

		// Series
		Composite seriesComp = new Composite(mainComp, SWT.NONE);
		seriesComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout seriesCompGL = new GridLayout(2, true);
		seriesComp.setLayout(seriesCompGL);

		Label seriesLabel = new Label(seriesComp, SWT.NONE);
		seriesLabel.setText("Series");
		seriesLabel.pack();
		GridData seriesLabelGD = new GridData();
		seriesLabelGD.horizontalSpan = 2;
		seriesLabel.setLayoutData(seriesLabelGD);

		seriesListV = new ListViewer(seriesComp, LIST_FLAGS);
		GridData seriesListGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		seriesListGD.horizontalSpan = 2;
		seriesListGD.heightHint = LIST_HEIGHT;
		seriesListV.getList().setLayoutData(seriesListGD);

		seriesListV.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object o) {
				return ((Series) o).getTitle();
			}
		});

		seriesListV.setContentProvider(new ArrayContentProvider());
		seriesListV.setInput(AssociateMovieToSeasonUtil.getAllSeries());

		// Season
		Composite seasonComp = new Composite(mainComp, SWT.NONE);
		seasonComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout seasonCompGL = new GridLayout(2, true);
		seasonComp.setLayout(seasonCompGL);

		Label seasonLabel = new Label(seasonComp, SWT.NONE);
		seasonLabel.setText("Season");
		seasonLabel.pack();
		GridData seasonLabelGD = new GridData();
		seasonLabelGD.horizontalSpan = 2;
		seasonLabel.setLayoutData(seasonLabelGD);

		seasonListV = new ListViewer(seasonComp, LIST_FLAGS);
		GridData seasonListGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		seasonListGD.horizontalSpan = 2;
		seasonListGD.heightHint = LIST_HEIGHT;
		seasonListV.getList().setLayoutData(seasonListGD);

		seasonListV.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object o) {
				return ((Season) o).getTitle();
			}
		});

		seasonListV.setContentProvider(new ArrayContentProvider());

		seriesListV
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						Series s = (Series) ((StructuredSelection) event
								.getSelection()).getFirstElement();
						seasonListV.setInput(s.getSeasons());
						if (!s.getSeasons().isEmpty()) {
							seasonListV.setSelection(new StructuredSelection(s
									.getSeasons().get(0)));
							enableOK();
						} else {
							disableOK();
						}
					}
				});

		// Unchecked cast from object to EList. Not problematic though because
		// the input cannot be anything else
		if (!((EList<Series>) seriesListV.getInput()).isEmpty()) {
			seriesListV.setSelection(new StructuredSelection(
					((EList<Series>) seriesListV.getInput()).get(0)));
		} else {
			disableOK();
		}

		return areaComp;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		Button okButton = createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.OK_LABEL, true);
		// Disable the OK button if the flag is set
		okButton.setEnabled(disableOK);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	private void enableOK() {
		if (getButton(IDialogConstants.OK_ID) != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(true);
		} else {
			disableOK = true;
		}
	}

	private void disableOK() {
		if (getButton(IDialogConstants.OK_ID) != null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
			disableOK = false;
		}
	}

	@Override
	protected void okPressed() {
		Episode ep = AssociateMovieToSeasonUtil.makeMovieToEpisode(movie,
				(Season) ((StructuredSelection) seasonListV.getSelection())
						.getFirstElement());
		// Remove the movie if the conversion was successful
		if (ep != null) {
			new EMFStoreCommand() {
				@Override
				protected void doRun() {
					MovieUtil.getActiveProject().deleteModelElement(movie);
				}
			}.run();
		}
		super.okPressed();
	}

}
