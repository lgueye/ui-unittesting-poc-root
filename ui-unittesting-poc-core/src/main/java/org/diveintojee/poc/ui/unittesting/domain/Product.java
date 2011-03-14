/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

/**
 * @author louis.gueye@gmail.com
 */
public class Product extends AbstractPersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5221792938997858541L;

	private String description;

	private String isin;

	private ProductType type;

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the isin
	 */
	public String getIsin() {
		return isin;
	}

	/**
	 * @return the type
	 */
	public ProductType getType() {
		return type;
	}

	/**
	 * @param description
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @param isin
	 *            the isin to set
	 */
	public void setIsin(final String isin) {
		this.isin = isin;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(final ProductType type) {
		this.type = type;
	}

}
