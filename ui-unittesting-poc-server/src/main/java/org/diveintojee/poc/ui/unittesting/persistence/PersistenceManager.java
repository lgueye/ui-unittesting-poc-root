/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.persistence;

import java.util.List;
import java.util.Set;

import org.diveintojee.poc.ui.unittesting.domain.Deal;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public interface PersistenceManager {

	String BEAN_ID = "persistenceManager";

	/**
	 * @param entityClass
	 */
	<T> void clear(Class<T> entityClass);

	/**
	 * @param entity
	 */
	<T> void delete(Class<T> entityClass, Long id);

	/**
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	<T> List<T> findAll(Class<T> entityClass);

	/**
	 * @param countDeals TODO
	 * @param dateIntervalInDays TODO
	 * @param maxAmount TODO
	 * @return
	 */
	Set<Deal> generateDeals(int countDeals, int dateIntervalInDays, int maxAmount);

	/**
	 * @param <T>
	 * @param entityClass
	 * @param id
	 * @return
	 */
	<T> T get(Class<T> entityClass, Long id);

	/**
	 * @param entity
	 */
	Long persist(Object entity);

}
