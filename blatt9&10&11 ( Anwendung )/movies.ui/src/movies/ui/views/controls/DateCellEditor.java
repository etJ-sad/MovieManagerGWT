package movies.ui.views.controls;

import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Cell editor for editing dates using a calendar dialog.
 *
 */
public class DateCellEditor extends DialogCellEditor {
	
	//The calendar dialog
	private class DateCellEditorDialog extends Dialog {
		private DateTime dateTime;			//Calendar widget
		private Date date;					//The selected date, is null if no selection was made
		
		protected DateCellEditorDialog(Shell parentShell) {
			super(parentShell);			
		}
		
		@SuppressWarnings("deprecation")
		@Override
		protected Control createContents(Composite parent) {
			dateTime = new DateTime(parent, SWT.CALENDAR | SWT.MEDIUM);
			
			final DateCellEditorDialog thisDialog = this;
			thisDialog.getShell().setLocation(Display.getDefault().getCursorLocation());
			
			if(date_initial != null) {
				dateTime.setDate(date_initial.getYear() + 1900, date_initial.getMonth(), date_initial.getDate());
			}
			dateTime.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					//Do nothing
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					date = new Date(dateTime.getYear() - 1900, dateTime.getMonth(), dateTime.getDay());
					thisDialog.close();
				}
			});
			
			parent.pack();
			return parent;
		}
	}
	
	private Date date_initial;	//The initial date for the calendar	
	
	/**
	 * Creates a new date cell editor parented under the given control and the given initial date.
	 * @param parent the parent control
	 * @param date_initial the initial date for the calendar. If the date is null, the calendar will be initialized with the current date
	 */
	public DateCellEditor(Composite parent, Date date_initial) {
		super(parent);
		this.date_initial = date_initial;
	}
	
	@Override
	public Button createButton(Composite parent) {
		Button editButton = new Button(parent, SWT.PUSH);
		editButton.setText("Edit");
		editButton.pack();
		return editButton;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {		
		DateCellEditorDialog dialog = new DateCellEditorDialog(Display.getDefault().getActiveShell());
		dialog.open();
		return dialog.date;
	}
	
	@Override
	protected void updateContents(Object element) {
		if(getDefaultLabel() == null) {
			return;
		}
        String text = "Unknown";//$NON-NLS-1$
        if(getValue() != null) {
			text = LoanedUntilControl.getDateString((Date) getValue());
		}
        getDefaultLabel().setText(text);
	}
}
