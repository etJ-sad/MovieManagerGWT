package movies.ui.handler;

import movies.ui.dialogs.SimpleDialog;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

public class SimpleDialogHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException
	{
		SimpleDialog dialog = new SimpleDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.open();
		return null;
	}
}
