package movies.ui.handler;
import movies.ui.dialogs.CreateSeriesDialog;


import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

public class CreateSeriesDialogHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		CreateSeriesDialog bWDialog = null;
		bWDialog = new CreateSeriesDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
		
		bWDialog.open();
		return null;
	}

}
