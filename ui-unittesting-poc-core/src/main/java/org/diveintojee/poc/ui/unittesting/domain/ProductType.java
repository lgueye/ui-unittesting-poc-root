/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

import org.apache.commons.lang.StringUtils;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class ProductType extends AbstractPersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6335634054792409718L;

	public static final ProductType EMPTY = new ProductType(StringUtils.EMPTY);

	private String label;

	public ProductType() {
		super();
	}

	public ProductType(final String label) {
		this();
		setLabel(label);
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
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
