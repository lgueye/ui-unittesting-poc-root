/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

/**
 * @author louis.gueye@gmail.com
 * 
 */
public class DealServiceFindByCriteriaMatchesCurrencyTest {

	@InjectMocks
	private DealServiceImpl underTest;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyDoesntMatchIfDealIsNull() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = null;
		Deal deal = null;

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyDoesntMatchIfSearchValueIsNotEmptyAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		String euro = Currency.getInstance(Locale.FRANCE).getCurrencyCode();
		List<String> currencyCodes = new ArrayList<String>();
		currencyCodes.add(euro);
		criteria.setCurrencyCodes(currencyCodes);

		Deal deal = null;
		String currencyCode = null;

		boolean matches = false;

		// Given
		deal = null;

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		currencyCode = null;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertFalse(matches);

		// Given
		deal = new Deal();
		currencyCode = StringUtils.EMPTY;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertFalse(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyMatchesIfSearchValueContainsDealProperty() {

		boolean matches = false;

		// Given
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		String eur = Currency.getInstance(Locale.FRANCE).getCurrencyCode();
		String usd = Currency.getInstance(Locale.FRANCE).getCurrencyCode();
		List<String> currencyCodes = new ArrayList<String>();
		currencyCodes.add(eur);
		currencyCodes.add(usd);
		criteria.setCurrencyCodes(currencyCodes);

		Deal deal = new Deal();
		deal.setCurrencyCode(eur);
		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyMatchesIfSearchValueIsEmptyAndDealIsNotNull() {

		Deal deal = new Deal();

		List<String> currencyCodes = null;
		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		currencyCodes = null;
		criteria.setCurrencyCodes(currencyCodes);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		currencyCodes = new ArrayList<String>();
		criteria.setCurrencyCodes(currencyCodes);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyMatchesIfSearchValueIsEmptyAndDealPropertyIsEmpty() {

		List<String> currencyCodes = null;
		DealsSearchCriteria criteria = new DealsSearchCriteria();

		String currencyCode = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		currencyCodes = null;
		criteria.setCurrencyCodes(currencyCodes);
		currencyCode = null;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		currencyCodes = new ArrayList<String>();
		criteria.setCurrencyCodes(currencyCodes);
		currencyCode = null;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		currencyCodes = null;
		criteria.setCurrencyCodes(currencyCodes);
		currencyCode = StringUtils.EMPTY;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		currencyCodes = new ArrayList<String>();
		criteria.setCurrencyCodes(currencyCodes);
		currencyCode = StringUtils.EMPTY;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);
	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyMatchesIfSearchValueIsEmptyAndDealPropertyIsNotEmpty() {

		Deal deal = new Deal();
		String currencyCode = Currency.getInstance(Locale.FRANCE)
				.getCurrencyCode();
		deal.setCurrencyCode(currencyCode);

		DealsSearchCriteria criteria = null;

		boolean matches = false;

		// Given
		criteria = null;

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		criteria = new DealsSearchCriteria();
		List<String> currencyCodes = new ArrayList<String>();
		criteria.setCurrencyCodes(currencyCodes);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#matchesCurrency(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria, org.diveintojee.poc.ui.unittesting.domain.Deal)}
	 * .
	 */
	@Test
	public final void matchesCurrencyMatchesIfSearchValueIsNullAndDealPropertyIsEmpty() {

		DealsSearchCriteria criteria = null;

		String currencyCode = null;
		Deal deal = new Deal();
		boolean matches = false;

		// Given
		currencyCode = null;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

		// Then
		assertTrue(matches);

		// Given
		currencyCode = StringUtils.EMPTY;
		deal.setCurrencyCode(currencyCode);

		// When
		matches = underTest.matchesCurrency(criteria, deal);

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
