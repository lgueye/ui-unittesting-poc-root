/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.diveintojee.poc.ui.unittesting.persistence.PersistenceManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * @author louis
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class DealServiceImplTest {

	@InjectMocks
	private final DealServiceImpl underTest = new DealServiceImpl();

	@Mock
	private final PersistenceManager persistenceManager = null;

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#findByCriteria(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria)}
	 * .
	 */
	@Test
	public final void findByCriteriaReturnsNullIfCriteriaIsNull() {

		// Given
		final Set<Deal> deals = new HashSet<Deal>();
		deals.add(new Deal());

		given(persistenceManager.generateDeals(0, 0, 0)).willReturn(deals);

		// When
		List<Deal> results = underTest.findByCriteria(null);

		// Then
		assertNull(results);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#findByCriteria(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria)}
	 * .
	 */
	@Test
	public final void findByCriteriaReturnsNullIfPersistenceReturnsEmpty() {
		// Given
		given(persistenceManager.generateDeals(0, 0, 0)).willReturn(
				new HashSet<Deal>());

		// When
		List<Deal> results = underTest
				.findByCriteria(new DealsSearchCriteria());

		// Then
		assertNull(results);

	}

	/**
	 * Test method for
	 * {@link org.diveintojee.poc.ui.unittesting.business.DealServiceImpl#findByCriteria(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria)}
	 * .
	 */
	@Test
	public final void findByCriteriaReturnsNullIfPersistenceReturnsNull() {
		// Given
		given(persistenceManager.generateDeals(0, 0, 0)).willReturn(null);

		// When
		List<Deal> results = underTest
				.findByCriteria(new DealsSearchCriteria());

		// Then
		assertNull(results);

	}

}
