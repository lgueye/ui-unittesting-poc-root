/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class BalanceNode extends AbstractPersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5007339923906263998L;
	private String label;

	/**
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

}
