/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 */
public class PersistenceManagerImplTest {

	private PersistenceManager persistenceManager;

	/**
	 * Test method for {@link
	 * org.diveintojee.poc.rest.persistence.PersistenceManagerImpl##findAll(java
	 * .lang.Class)} .
	 */
	@Test
	public final void findAllWillReturnNullWithEmptyEntityMap() {
		Assert.assertNull(persistenceManager.findAll(Product.class));
	}

	/**
	 * Test method for {@link
	 * org.diveintojee.poc.rest.persistence.PersistenceManagerImpl##findAll(java
	 * .lang.Class)} .
	 */
	@Test
	public final void findAllWillReturnNullWithNullEntityClass() {
		Assert.assertNull(persistenceManager.findAll(null));
	}

	@Test
	public void generateDealsWillGenerateDatesInExpectedInterval() {
		// Given
		int countDeals = 2;
		int dateIntervalInDays = 3;
		int maxAmount = 100;

		// When
		Set<Deal> results = persistenceManager.generateDeals(countDeals,
				dateIntervalInDays, maxAmount);

		// Then
		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.add(Calendar.DAY_OF_MONTH, dateIntervalInDays);
		Date endDate = endDateCalendar.getTime();
		long max = endDate.getTime();

		Calendar beginDateCalendar = Calendar.getInstance();
		beginDateCalendar.add(Calendar.DAY_OF_MONTH, -dateIntervalInDays);
		Date beginDate = beginDateCalendar.getTime();
		long min = beginDate.getTime();

		assertNotNull(results);

		for (Deal deal : results) {
			assertNotNull(deal);
			Date asOfDate = deal.getAsOfDate();
			assertNotNull(asOfDate);
			assertTrue(asOfDate.getTime() <= max);
			assertTrue(asOfDate.getTime() >= min);
		}

	}

	@Test
	public void generateDealsWillGenerateExpectedAmount() {
		// Given
		int countDeals = 2;
		int dateIntervalInDays = 3;
		int maxAmount = 100;

		// When
		Set<Deal> results = persistenceManager.generateDeals(countDeals,
				dateIntervalInDays, maxAmount);

		// Then

		assertNotNull(results);

		for (Deal deal : results) {
			assertNotNull(deal);
			BigDecimal amount = deal.getAmount();
			assertNotNull(amount);
			assertTrue(amount.longValue() <= maxAmount);
		}

	}

	@Test
	public void generateDealsWillGenerateExpectedCountDeals() {
		int countDeals = 2;
		int dateIntervalInDays = 2;
		int maxAmount = 100;
		Set<Deal> results = persistenceManager.generateDeals(countDeals,
				dateIntervalInDays, maxAmount);
		assertNotNull(results);
		assertEquals(results.size(), countDeals);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.rest.persistence.PersistenceManagerImpl#get(java.lang.Class, java.lang.Long)}
	 * .
	 */
	@Test
	public final void getWillReturnNullWithNotFoundEntityMap() {
		Assert.assertNull(persistenceManager.get(Product.class, Long.valueOf(5)));
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.rest.persistence.PersistenceManagerImpl#get(java.lang.Class, java.lang.Long)}
	 * .
	 */
	@Test
	public final void getWillReturnNullWithNullEntityClass() {
		Assert.assertNull(persistenceManager.get(null, Long.valueOf(0)));
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.rest.persistence.PersistenceManagerImpl#get(java.lang.Class, java.lang.Long)}
	 * .
	 */
	@Test
	public final void getWillReturnNullWithNullId() {
		Assert.assertNull(persistenceManager.get(Product.class, null));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		persistenceManager = new PersistenceManagerImpl();
	}

}
