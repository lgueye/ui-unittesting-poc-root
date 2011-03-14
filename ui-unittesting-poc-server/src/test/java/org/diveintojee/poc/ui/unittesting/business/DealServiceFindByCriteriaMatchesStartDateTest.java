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
public class DealServiceFindByCriteriaMatchesStartDateTest {

	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Date searchValue = Calendar.getInstance().getTime();
		criteria.setStartDate(searchValue);

		Deal deal = null;
		Date dealProperty = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		dealProperty = null;
		deal.setAsOfDate(dealProperty);

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateMatchesIfSearchValueIsBeforeDealProperty() {

		boolean matches = false;

		// Given
		Calendar searchValueCalendar = Calendar.getInstance();
		searchValueCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date searchValue = searchValueCalendar.getTime();
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setStartDate(searchValue);

		Date dealProperty = Calendar.getInstance().getTime();
		Deal deal = new Deal();
		deal.setAsOfDate(dealProperty);

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		Date startDate = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		startDate = Calendar.getInstance().getTime();
		criteria.setStartDate(startDate);

		// When
		matches = underTest.matchesStartDate(criteria, deal);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		Date searchValue = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Date asOfDate = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		searchValue = null;
		criteria.setStartDate(searchValue);
		asOfDate = null;
		deal.setAsOfDate(asOfDate);

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesStartDate(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesStartDateMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		Date dealProperty = Calendar.getInstance().getTime();
		deal.setAsOfDate(dealProperty);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesStartDate(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesStartDate(criteria, deal);

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
