package movies.ui.handler;

import movies.ui.dialogs.QueryWizardDialog;
import movies.ui.wizards.queryWizard.QueryWizard;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.PlatformUI;

public class QueryWizardHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		QueryWizardDialog bWDialog = null;
		bWDialog = new QueryWizardDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), new QueryWizard(bWDialog));

		bWDialog.setPageSize(300, 300);
		bWDialog.open();

		
		
		return null;
	}

}
