package movies.ui.handler;

import movies.ui.dialogs.AssociateMovieToSeasonDialog;
import movies.ui.util.MovieUtil;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Display;


public class AssociateMovieToSeasonDialogHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		AssociateMovieToSeasonDialog dialog = new AssociateMovieToSeasonDialog(Display.getDefault().getActiveShell(), MovieUtil.getSelection(event));
		dialog.open();
		return null;
	}

}
