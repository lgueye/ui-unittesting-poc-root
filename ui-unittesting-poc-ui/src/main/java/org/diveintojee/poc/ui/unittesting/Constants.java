/**
 * 
 */
package org.diveintojee.poc.ui.unittesting;

import java.text.SimpleDateFormat;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class Constants {

	public static final String UI_CONFIG_LOCATION = "classpath:ui-unittesting-poc-ui.xml";

	public static final String ROOT_WINDOW_INITIAL_WIDTH_KEY = "root.window.initial.width";

	public static final String ROOT_WINDOW_INITIAL_HEIGHT_KEY = "root.window.initial.height";

	public static final String MESSAGE_SOURCE_BEAN_ID = "ui-message-source";

	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static final int AMOUNTS_SCALE = 2;

}
