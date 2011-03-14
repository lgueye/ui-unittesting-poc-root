/** 
 * 
 */
package org.diveintojee.poc.ui.unittesting.deals.model;

import java.util.List;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class FindDealsByCriteriaModel {

	private DealsSearchCriteria criteria;

	private List<Deal> results;

	private List<Entity> entities;

	private List<ProductType> productTypes;

	public FindDealsByCriteriaModel() {
		setCriteria(new DealsSearchCriteria());
	}

	/**
	 * @return the criteria
	 */
	public DealsSearchCriteria getCriteria() {
		return criteria;
	}

	/**
	 * @return the entities
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * @return the productTypes
	 */
	public List<ProductType> getProductTypes() {
		return productTypes;
	}

	/**
	 * @return the results
	 */
	public List<Deal> getResults() {
		return results;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(final DealsSearchCriteria criteria) {
		this.criteria = criteria;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(final List<Entity> entities) {
		this.entities = entities;
	}

	/**
	 * @param productTypes
	 *            the productTypes to set
	 */
	public void setProductTypes(final List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(final List<Deal> results) {
		this.results = results;
	}

}
