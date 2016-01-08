package movies.ui.handler;

import java.util.Date;

import movies.Movie;

import org.eclipse.emf.ecp.common.commands.ECPCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;

/**
 * Action that is executes if a Movie is watched.
 * 
 * @author Alexander Delater
 * 
 */
public class WatchMovieAction extends ECPCommand {

	private Movie movie;

	/**
	 * Instantiates a new watch movie action.
	 * 
	 * @param movie the movie
	 */
	public WatchMovieAction(Movie movie) {
		super(movie);
		this.movie = movie;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecp.common.commands.ECPCommand#doRun()
	 */
	protected void doRun() {
		if (movie.isLoaned()) {
			MessageDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Error",
					"A Movie that is loaned cannot be watched! \nPlease get the movie back to watch it.");
		} else {
			movie.setLastWatchDate(new Date());
			MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Information", "Watching Movie: " + movie.getTitle() + " \nCurrent Time: "
							+ movie.getLastWatchDate().toString());
		}
	}
}
