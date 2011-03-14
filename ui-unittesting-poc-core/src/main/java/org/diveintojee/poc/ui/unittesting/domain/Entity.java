/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class Entity extends AbstractPersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2839203986131106658L;

	public static final Entity EMPTY = new Entity(StringUtils.EMPTY,
			new ArrayList<String>());

	private String label;

	private List<String> currencyCodes;

	public Entity() {
		super();
	}

	public Entity(final String label, final List<String> currencyCodes) {
		this();
		setLabel(label);
		setCurrencyCodes(currencyCodes);
	}

	/**
	 * @return the currencyCodes
	 */
	public List<String> getCurrencyCodes() {
		return currencyCodes;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @param currencyCodes
	 *            the currencyCodes to set
	 */
	public void setCurrencyCodes(final List<String> currencyCodes) {
		this.currencyCodes = currencyCodes;
	}

	/**
	 * @param label
	 *            the label to set
	 */
	public void setLabel(final String label) {
		this.label = label;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getLabel();
	}

}
