package movies.ui.handler; 
import movies.ui.dialogs.MovieExceptionDialog; 
import org.eclipse.core.commands.AbstractHandler; 
import org.eclipse.core.commands.ExecutionEvent; 
import org.eclipse.core.commands.ExecutionException; 
import org.eclipse.ui.PlatformUI; 

public class MovieExceptionHandler extends AbstractHandler { 
	
	public Object execute(ExecutionEvent event) throws ExecutionException { 
		MovieExceptionDialog dialog = new MovieExceptionDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell()); dialog.open(); 
		return null; 
	}


}