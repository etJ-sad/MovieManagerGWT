package movies.ui.handler; 
import movies.ui.views.StudioView;

import org.eclipse.core.commands.AbstractHandler; 
import org.eclipse.core.commands.ExecutionEvent; 
import org.eclipse.core.commands.ExecutionException; 
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI; 

public class StudioViewHandler extends AbstractHandler { 
	public Object execute(ExecutionEvent event) throws ExecutionException { 
		try { 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(StudioView.ID); } 
		catch (PartInitException e) { 
			// showView() can throw an exception if view cannot be shown 
			e.printStackTrace(); 
		} 
		return null; 
	} 	
} 
