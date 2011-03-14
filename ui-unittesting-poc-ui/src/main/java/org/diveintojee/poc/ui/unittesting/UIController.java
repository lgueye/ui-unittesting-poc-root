/**
 * 
 */
package org.diveintojee.poc.ui.unittesting;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public interface UIController {

	void addListeners();

	Object getView();

	void initializeView();

	void setModel(Object model);

	void setView(Object view);

	void showView(boolean visible);

}
