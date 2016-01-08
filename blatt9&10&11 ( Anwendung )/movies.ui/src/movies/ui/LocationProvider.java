package movies.ui;

import org.eclipse.emf.emfstore.client.model.util.DefaultWorkspaceLocationProvider;
import org.eclipse.emf.emfstore.server.ServerConfiguration;

/**
 * The Class LocationProvider determines where under the local user the workspace is saved.
 * 
 * @author Alexander Delater
 */
public class LocationProvider extends DefaultWorkspaceLocationProvider {
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.DefaultServerWorkspaceLocationProvider#getRootDirectory()
	 */
	@Override
	protected String getRootDirectory() {
		String parameter = getStartParameter(".moviemanager");
		if (parameter == null) {
			return addFolders(getUserHome(), ".moviemanager", "client");
		} else {
			return parameter;
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.emfstore.server.DefaultServerWorkspaceLocationProvider#getSelectedProfile()
	 */
	@Override
	protected String getSelectedProfile() {
		String parameter = getStartParameter("-profile");
		if (parameter == null) {
			parameter = "default";
			if (!ServerConfiguration.isReleaseVersion()) {
				if (ServerConfiguration.isInternalReleaseVersion()) {
					parameter += "_internal";
				} else {
					parameter += "_dev";
				}
			}
		}
		return parameter;
	}
}
