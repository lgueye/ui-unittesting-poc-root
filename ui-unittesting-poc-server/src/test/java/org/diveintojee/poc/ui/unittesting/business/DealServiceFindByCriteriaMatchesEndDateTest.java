/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealServiceFindByCriteriaMatchesEndDateTest {

	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Date searchValue = Calendar.getInstance().getTime();
		criteria.setEndDate(searchValue);

		Deal deal = null;
		Date dealProperty = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		dealProperty = null;
		deal.setAsOfDate(dealProperty);

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateMatchesIfSearchValueIsAfterDealProperty() {

		boolean matches = false;

		// Given
		Calendar searchValueCalendar = Calendar.getInstance();
		searchValueCalendar.add(Calendar.DAY_OF_MONTH, 1);
		Date searchValue = searchValueCalendar.getTime();
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setEndDate(searchValue);

		Date dealProperty = Calendar.getInstance().getTime();
		Deal deal = new Deal();
		deal.setAsOfDate(dealProperty);

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		Date endDate = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		endDate = Calendar.getInstance().getTime();
		criteria.setEndDate(endDate);

		// When
		matches = underTest.matchesEndDate(criteria, deal);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		Date searchValue = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Date asOfDate = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		searchValue = null;
		criteria.setEndDate(searchValue);
		asOfDate = null;
		deal.setAsOfDate(asOfDate);

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEndDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEndDateMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		Date dealProperty = Calendar.getInstance().getTime();
		deal.setAsOfDate(dealProperty);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesEndDate(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		underTest = new DealServiceImpl();
	}

}
