package movies.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Alexander Delater
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID as specified in plugin.xml.
	 */
	public static final String PLUGIN_ID = "movie.ui";

	private static Activator plugin;

	private static boolean isShowingPerformers = true;

	/**
	 * Instantiates a new activator.
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Checks if is showing performers.
	 * 
	 * @return true, if is showing performers
	 */
	public static boolean isShowingPerformers() {
		return isShowingPerformers;
	}

	/**
	 * Sets the showing performers.
	 * 
	 * @param isShowingPerformers the new showing performers
	 */
	public static void setShowingPerformers(boolean isShowingPerformers) {
		Activator.isShowingPerformers = isShowingPerformers;
	}

}
