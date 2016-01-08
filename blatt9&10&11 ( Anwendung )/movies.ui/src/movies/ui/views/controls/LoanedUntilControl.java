package movies.ui.views.controls;

import java.text.SimpleDateFormat;
import java.util.Date;

import movies.Episode;
import movies.Movie;
import movies.Season;
import movies.Series;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.edit.EMFEditObservables;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.editor.mecontrols.AbstractMEControl;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * Custom checkbox control that combines the 'loaned' and 'loanedUntil'
 * attributes but behaves like the default checkbox for all other boolean
 * attributes.
 * 
 */
public class LoanedUntilControl extends AbstractMEControl {

	private Label loanedUntilLabel;
	private Button check;
	private static final String LOANED_ATTR = "loaned";
	
	private AdapterImpl adapter;

	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			EObject modelElement) {
		if (modelElement instanceof Movie || modelElement instanceof Series
				|| modelElement instanceof Season
				|| modelElement instanceof Episode) {
			EStructuralFeature structuralFeature = (EStructuralFeature) itemPropertyDescriptor
					.getFeature(modelElement);
			if (structuralFeature.getName().equalsIgnoreCase(LOANED_ATTR)) {
				return 2;
			}
			return DO_NOT_RENDER;
		}
		return DO_NOT_RENDER;
	}

	@Override
	protected Control createControl(final Composite parent, int style) {
		EObject modelElement = getModelElement();
		EStructuralFeature managedFeature = (EStructuralFeature) getItemPropertyDescriptor()
				.getFeature(modelElement);

		int numColumns = 2;
		if (managedFeature.getName().equals(LOANED_ATTR)) {
			numColumns = 3;
		}

		Composite main = getToolkit().createComposite(parent, style);
		main.setBackground(new Color(Display.getDefault(), 255, 255, 255));
		GridLayoutFactory.fillDefaults().numColumns(numColumns).spacing(2, 0)
				.applyTo(main);

		Label labelWidgetImage = getToolkit().createLabel(main, "     ");
		labelWidgetImage.setBackground(parent.getBackground());
		labelWidgetImage.setSize(SWT.DEFAULT, 16);

		check = getToolkit().createButton(main, "", SWT.CHECK);
		check.setEnabled(false);
		IObservableValue model = EMFEditObservables.observeValue(
				getEditingDomain(), getModelElement(),
				(EAttribute) managedFeature);
		EMFDataBindingContext dbc = new EMFDataBindingContext();
		dbc.bindValue(SWTObservables.observeSelection(check), model, null, null);

		if (managedFeature.getName().equals(LOANED_ATTR)) {			
			check.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					updateLoanedUntilLabel();
				}
			});

			loanedUntilLabel = getToolkit().createLabel(main,
					getLoanedUntilString());
			//Register a listener that updates the loaned until label because the selection listener will not be triggered by external changes to the checkbox
			adapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if(!parent.isDisposed()) {
						updateLoanedUntilLabel();
					}
				}
			};
			getModelElement().eAdapters().add(adapter);
		}

		return main;
	}

	@Override
	public boolean getShowLabel() {
		return true;
	}

	private String getLoanedUntilString() {
		EObject modelElement = getModelElement();
		Date loanedUntil = null;
		if (modelElement instanceof Movie) {
			loanedUntil = ((Movie) modelElement).getLoanedUntil();
		}
		if (modelElement instanceof Series) {
			loanedUntil = ((Series) modelElement).getLoanedUntil();
		}
		if (modelElement instanceof Season) {
			loanedUntil = ((Season) modelElement).getLoanedUntil();
		}		
		String loanedUntilString = "";
		if (check.getSelection() && loanedUntil != null) {
			loanedUntilString = " Until: " + getDateString(loanedUntil);
		}
		return loanedUntilString;
	}

	public static String getDateString(Date d) {
		return new SimpleDateFormat("dd.MM.yyyy").format(d);
	}
	
	@Override
	public void dispose() {
		getModelElement().eAdapters().remove(adapter);
		super.dispose();
	}

	private void updateLoanedUntilLabel() {
		loanedUntilLabel.setText(getLoanedUntilString());
		loanedUntilLabel.pack();
	}

}
