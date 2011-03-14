/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealServiceFindByCriteriaMatchesEntityTest {

	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Entity searchValue = new Entity();
		searchValue.setLabel("Paris");
		criteria.setEntity(searchValue);

		Deal deal = null;
		Entity dealProperty = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		dealProperty = null;
		deal.setProduct(new Product());
		deal.setEntity(dealProperty);

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityMatchesIfSearchValueEqualsDealProperty() {

		boolean matches = false;

		// Given
		Calendar searchValueCalendar = Calendar.getInstance();
		searchValueCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Entity searchValue = new Entity();
		searchValue.setLabel("London");
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setEntity(searchValue);

		Entity dealProperty = new Entity();
		searchValue.setLabel("London");
		Deal deal = new Deal();
		deal.setProduct(new Product());
		deal.setEntity(dealProperty);

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		Entity productType = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		productType = new Entity();
		productType.setLabel("Honk-Kong");
		criteria.setEntity(productType);

		// When
		matches = underTest.matchesEntity(criteria, deal);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		Entity searchValue = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		Entity dealProperty = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		searchValue = null;
		criteria.setEntity(searchValue);
		dealProperty = null;
		deal.setProduct(new Product());
		deal.setEntity(dealProperty);

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesEntity(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesEntityMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		Entity dealProperty = new Entity();
		dealProperty.setLabel("New-York");
		deal.setProduct(new Product());
		deal.setEntity(dealProperty);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesEntity(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesEntity(criteria, deal);

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
