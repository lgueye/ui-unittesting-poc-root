/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealServiceFindByCriteriaMatchesIsinTest {

	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		String searchValue = "FR0000000000";
		criteria.setIsin(searchValue);

		Deal deal = null;
		String dealProperty = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		dealProperty = null;
		deal.setProduct(new Product());
		deal.getProduct().setIsin(dealProperty);

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinMatchesIfSearchValueEqualsDealProperty() {

		boolean matches = false;

		// Given
		Calendar searchValueCalendar = Calendar.getInstance();
		searchValueCalendar.add(Calendar.DAY_OF_MONTH, -1);
		String searchValue = "FR0000000012";
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setIsin(searchValue);

		String dealProperty = "FR0000000012";
		Deal deal = new Deal();
		deal.setProduct(new Product());
		deal.getProduct().setIsin(dealProperty);

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		String isin = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		isin = "FR0000000012";
		criteria.setIsin(isin);

		// When
		matches = underTest.matchesIsin(criteria, deal);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		String searchValue = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		String dealProperty = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		searchValue = null;
		criteria.setIsin(searchValue);
		dealProperty = null;
		deal.setProduct(new Product());
		deal.getProduct().setIsin(dealProperty);

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesIsin(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesIsinMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		String dealProperty = "FR000000000012";
		deal.setProduct(new Product());
		deal.getProduct().setIsin(dealProperty);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesIsin(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesIsin(criteria, deal);

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
