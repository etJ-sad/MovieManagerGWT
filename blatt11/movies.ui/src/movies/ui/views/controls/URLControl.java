package movies.ui.views.controls;

import movies.Movie;
import movies.ui.Activator;
import movies.ui.util.MovieUtil;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.utilities.ExtProgramFactoryFacade;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelElementChangeObserver;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;

/**
 * The Class URLControl provides support for editing and opening URLs.
 * 
 * @author Alexander Delater
 */
public class URLControl extends AbstractMEControl {

	private Composite linkComposite;
	private Hyperlink hyperlink;
	private ModelElementChangeObserver observer;
	private Movie movie;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.
	 * IItemPropertyDescriptor, org.eclipse.emf.ecore.EObject)
	 */
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		// only need 1 itemPropertyDescriptor because only 1 is added in ResourceLocationProvider
		if (modelElement instanceof Movie
				&& ((EAttribute) itemPropertyDescriptor.getFeature(modelElement)).getName().equals("imdbUrl")) {
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
	protected Control createControl(final Composite parent, int style) {
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(3, false));
		this.movie = (Movie) getModelElement();
		observer = new ModelElementChangeObserver() {
			protected void onNotify(Notification notification, EObject element) {
			}
			protected void onElementDeleted(EObject element) {
			}
			public void notify(Notification notification, IdEObjectCollection collection, EObject modelElement) {
				if (modelElement == movie) {
					Display.getDefault().asyncExec(new Runnable() {
						@Override
						public void run() {
							if (!hyperlink.isDisposed()) {
								String url = movie.getImdbUrl();
								if (url == null) {
									url = "";
								}
								hyperlink.setText(MovieUtil.getLimitedName(url, 30));
								hyperlink.setToolTipText(url);
								linkComposite.layout(true);
								parent.getParent().layout(true);
							}
						}
					});
				}
			}
			public void modelElementAdded(IdEObjectCollection collection, EObject modelElement) {
			}
			public void modelElementRemoved(IdEObjectCollection collection, EObject modelElement) {
			}
		};

		ModelUtil.getProject(getModelElement()).addIdEObjectCollectionChangeObserver(observer);
		observer.observeElement(getModelElement());

		String url = movie.getImdbUrl();
		if (url == null) {
			url = "";
		}
		hyperlink = getToolkit().createHyperlink(linkComposite, url, style);
		hyperlink.setText(MovieUtil.getLimitedName(url, 30));
		hyperlink.setToolTipText(url);
		hyperlink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				String url = movie.getImdbUrl();
				if (url == null) {
					return;
				}
				boolean isLaunched = ExtProgramFactoryFacade.launchURL(url);
				if (!isLaunched) {
					MessageBox box = new MessageBox(parent.getShell(), SWT.OK | SWT.ICON_ERROR);
					box.setText("Invalid URL");
					box.setMessage(url + " is not a valid URL, browser couldn't be started!");
					box.open();
				}
				super.linkActivated(event);
			}
		});

		final Action editURL = new Action("Edit URL", SWT.PUSH) {
			@Override
			public void run() {
				InputDialog input = new InputDialog(parent.getShell(), "Edit URL", "Please enter the URL",
						movie.getImdbUrl(), new URLValidator());
				input.setBlockOnOpen(true);
				int result = input.open();
				if (result == InputDialog.OK) {
					new SetURLCommand(input.getValue(), movie).run(true);
				}
			}
		};
		
		Button linkButton = getToolkit().createButton(linkComposite, null, SWT.PUSH);
		linkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editURL.run();
			}
		});
		linkButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		linkButton.setImage(Activator.getImageDescriptor("icons/link.png").createImage());
		linkButton.setToolTipText("Add Url");
		
		Button unlinkButton = getToolkit().createButton(linkComposite, null, SWT.PUSH);
		unlinkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new SetURLCommand(null, movie).run(true);
			}
		});
		unlinkButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		unlinkButton.setImage(Activator.getImageDescriptor("icons/unlink.png").createImage());
		unlinkButton.setToolTipText("Remove Url");

		return linkComposite;
	}

	/**
	 * Disposes the Composite of this {@link MEURLControl}.
	 */
	@Override
	public void dispose() {
		if (getModelElement() != null) {
			Project project = ModelUtil.getProject(getModelElement());
			if (project != null) {
				project.removeIdEObjectCollectionChangeObserver(observer);
			}
		}
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}

	/**
	 * Recording command to edit a URL.
	 * 
	 * @author Alexander Delater
	 */
	private final class SetURLCommand extends EMFStoreCommand {
		private final String newURL;
		private final Movie movie;

		/**
		 * Instantiates a new sets the url command.
		 * 
		 * @param newURL the new url
		 * @param movie the movie
		 */
		public SetURLCommand(String newURL, Movie movie) {
			super();
			this.newURL = newURL;
			this.movie = movie;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand#doRun()
		 */
		protected void doRun() {
			movie.setImdbUrl(newURL);
		}
	}

	/**
	 * Validator class for validating the input of URL Input-Dialog.
	 * 
	 * @author Alexander Delater
	 */
	private class URLValidator implements IInputValidator {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
		 */
		public String isValid(String newText) {
			// this regular expression does not allow special characters like - in urls, e.g. www.uni-heidelberg.de
			// if (newText.matches("(((https?|ftp)://)?(www\\.)?(\\w+\\.){1,}+\\w+){1}(/.*)*")) {
			if (newText.matches("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
				return null;
			} else {
				return "Invalid URL!";
			}
		}
	}
}
