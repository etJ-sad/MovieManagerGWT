package movies.ui.dialogs;


import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class SimpleDialog extends TitleAreaDialog
{
	public SimpleDialog(Shell parentShell)
	{
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent)
	{
		// create Composite for holding all content
		Composite contents = new Composite(parent, SWT.NONE);
		// set layout for content: fill and grab all available space
		contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		contents.setLayout(new GridLayout());
		// set title and message
		setTitle("Simple Dialog");
		setMessage("Shows a simple dialog");

		// TextViewer is used to show a text box
		TextViewer viewer = new TextViewer(contents, SWT.BORDER);
		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		// to display text in the TextViewer, a new Document needs to be created
		IDocument document = new Document();
		// set an example text as content of the Document
		document.set("This is a simple dialog");
		// provide the Document to the TextViewer
		viewer.setDocument(document);
		return contents;
	}

	@Override
	protected void okPressed()
	{
		this.setReturnCode(Window.OK);
		super.okPressed();
	}

	@Override
	protected void cancelPressed()
	{
		super.cancelPressed();
	}
}

