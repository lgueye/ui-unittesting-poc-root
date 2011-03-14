/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain.services;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealsSearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date startDate;
	private Date endDate;
	private Entity entity;
	private List<String> currencyCodes;
	private ProductType productType;
	private String isin;

	/**
	 * @return the currencies
	 */
	public List<String> getCurrencyCodes() {
		return currencyCodes;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}

	public String getIsin() {
		return isin;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param currencies
	 *            the currencies to set
	 */
	public void setCurrencyCodes(final List<String> currencyCodes) {
		this.currencyCodes = currencyCodes;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(final Entity entity) {
		this.entity = entity;
	}

	public void setIsin(final String isin) {
		this.isin = isin;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(final ProductType productType) {
		this.productType = productType;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

}
