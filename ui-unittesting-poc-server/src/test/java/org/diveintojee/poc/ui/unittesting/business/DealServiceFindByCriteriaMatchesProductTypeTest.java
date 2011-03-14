/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.junit.Before;
import org.junit.Test;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealServiceFindByCriteriaMatchesProductTypeTest {

	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		ProductType searchValue = new ProductType();
		searchValue.setLabel("Swap");
		criteria.setProductType(searchValue);

		Deal deal = null;
		ProductType dealProperty = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		dealProperty = null;
		deal.setProduct(new Product());
		deal.getProduct().setType(dealProperty);

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeMatchesIfSearchValueEqualsDealProperty() {

		boolean matches = false;

		// Given
		Calendar searchValueCalendar = Calendar.getInstance();
		searchValueCalendar.add(Calendar.DAY_OF_MONTH, -1);
		ProductType searchValue = new ProductType();
		searchValue.setLabel("Swap");
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setProductType(searchValue);

		ProductType dealProperty = new ProductType();
		searchValue.setLabel("Swap");
		Deal deal = new Deal();
		deal.setProduct(new Product());
		deal.getProduct().setType(dealProperty);

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		ProductType productType = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		productType = new ProductType();
		productType.setLabel("Futures");
		criteria.setProductType(productType);

		// When
		matches = underTest.matchesProductType(criteria, deal);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		ProductType searchValue = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		ProductType dealProperty = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		searchValue = null;
		criteria.setProductType(searchValue);
		dealProperty = null;
		deal.setProduct(new Product());
		deal.getProduct().setType(dealProperty);

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesProductType(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesProductTypeMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		ProductType dealProperty = new ProductType();
		dealProperty.setLabel("Options");
		deal.setProduct(new Product());
		deal.getProduct().setType(dealProperty);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesProductType(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesProductType(criteria, deal);

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
