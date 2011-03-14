package org.diveintojee.poc.ui.unittesting;

import org.diveintojee.poc.ui.unittesting.root.window.RootWindowController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class ApplicationLauncher {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext(
				Constants.UI_CONFIG_LOCATION);

		RootWindowController rootWindowController = (RootWindowController) factory
				.getBean(RootWindowController.BEAN_ID);
		rootWindowController.initialize();
		rootWindowController.showView(false);
	}

}
