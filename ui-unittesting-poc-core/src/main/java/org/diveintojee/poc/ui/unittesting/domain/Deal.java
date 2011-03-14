package org.diveintojee.poc.ui.unittesting.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Deal extends AbstractPersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6512029795086141897L;

	private Entity entity;

	private Product product;

	private BalanceNode balanceNode;

	private String currencyCode;

	private BigDecimal amount;

	private Date asOfDate;

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return the asOfDate
	 */
	public Date getAsOfDate() {
		return asOfDate;
	}

	/**
	 * @return the balanceNode
	 */
	public BalanceNode getBalanceNode() {
		return balanceNode;
	}

	/**
	 * @return the currency
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return the entity
	 */
	public Entity getEntity() {
		return entity;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(final BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @param asOfDate
	 *            the asOfDate to set
	 */
	public void setAsOfDate(final Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	/**
	 * @param balanceNode
	 *            the balanceNode to set
	 */
	public void setBalanceNode(final BalanceNode balanceNode) {
		this.balanceNode = balanceNode;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrencyCode(final String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(final Entity entity) {
		this.entity = entity;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(final Product product) {
		this.product = product;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return getClass().getSimpleName() + "[" + getId() + "]";

	}
}
