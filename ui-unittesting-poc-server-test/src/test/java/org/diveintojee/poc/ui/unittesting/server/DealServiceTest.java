package org.diveintojee.poc.ui.unittesting.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.collections.CollectionUtils;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.DealService;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.diveintojee.poc.ui.unittesting.domain.services.ReferentialService;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.thread.QueuedThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author louis.gueye@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { Constants.TESTS_CONTEXT })
public class DealServiceTest {

	private static final String SERVER_MODULE_CONTEXT = ResourceBundle
			.getBundle(Constants.CONFIG_BUNDLE_NAME).getString(
					Constants.SERVER_MODULE_CONTEXT_KEY);

	private static final String JETTY_PORT = ResourceBundle.getBundle(
			Constants.CONFIG_BUNDLE_NAME).getString(Constants.JETTY_PORT_KEY);

	private static Server server;

	/**
	 * @throws Throwable
	 */
	@AfterClass
	public static void afterClass() throws Throwable {

		DealServiceTest.server.stop();
		DealServiceTest.server.join();

	}

	/**
	 * @throws Throwable
	 */
	@BeforeClass
	public static void beforeClass() throws Throwable {

		DealServiceTest.server = new Server();

		QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMaxThreads(100);
		DealServiceTest.server.setThreadPool(threadPool);

		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(Integer.valueOf(DealServiceTest.JETTY_PORT));
		connector.setMaxIdleTime(30000);
		connector.setConfidentialPort(8443);
		DealServiceTest.server.setConnectors(new Connector[] { connector });

		WebAppContext webappTestingServerWebApp = new WebAppContext();
		webappTestingServerWebApp.setWar("../"
				+ DealServiceTest.SERVER_MODULE_CONTEXT + "/target/"
				+ DealServiceTest.SERVER_MODULE_CONTEXT + ".war");
		webappTestingServerWebApp.setContextPath("/"
				+ DealServiceTest.SERVER_MODULE_CONTEXT);

		DealServiceTest.server.addHandler(webappTestingServerWebApp);

		DealServiceTest.server.start();

		DealServiceTest.server.setStopAtShutdown(true);

		DealServiceTest.server.setSendServerVersion(true);

	}

	@Autowired
	@Qualifier(DealService.BEAN_ID)
	private DealService dealService;

	@Autowired
	@Qualifier(ReferentialService.BEAN_ID)
	private ReferentialService referentialService;

	/**
    * 
    */
	@Before
	public void before() {
		Assert.assertNotNull(dealService);
	}

	@Test
	public final void findByCriteriaWillMatchCurrency() {
		// Given
		List<String> currencyCodes = Arrays.asList(new String[] {
				Currency.getInstance(Locale.UK).getCurrencyCode(),
				Currency.getInstance(Locale.US).getCurrencyCode() });

		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setCurrencyCodes(currencyCodes);

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(currencyCodes.contains(deal.getCurrencyCode()));

			}
	}

	@Test
	public final void findByCriteriaWillMatchEndDate() {
		// Given
		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.add(Calendar.DAY_OF_MONTH, 15);
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setEndDate(endDateCalendar.getTime());

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(deal.getAsOfDate().before(criteria.getEndDate()));

			}
	}

	@Test
	public final void findByCriteriaWillMatchEntity() {
		// Given
		List<Entity> entities = referentialService.loadAllEntities();
		assertNotNull(entities);
		assertTrue(entities.size() > 3);

		Entity entity = entities.get(2);
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setEntity(entity);

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(deal.getEntity().equals(entity));

			}
	}

	@Test
	public final void findByCriteriaWillMatchIsin() {
		// Given

		String isin = "FR0000000001";
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setIsin(isin);

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(deal.getProduct().getIsin().equals(isin));

			}
	}

	@Test
	public final void findByCriteriaWillMatchProductType() {
		// Given
		List<ProductType> productTypes = referentialService
				.loadAllProductTypes();
		assertNotNull(productTypes);
		assertTrue(productTypes.size() > 3);

		ProductType productType = productTypes.get(2);
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setProductType(productType);

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(deal.getProduct().getType().equals(productType));

			}
	}

	@Test
	public final void findByCriteriaWillMatchStartDate() {
		// Given
		Calendar startDateCalendar = Calendar.getInstance();
		startDateCalendar.add(Calendar.DAY_OF_MONTH, 1);
		DealsSearchCriteria criteria = new DealsSearchCriteria();
		criteria.setStartDate(startDateCalendar.getTime());

		// When
		List<Deal> results = dealService.findByCriteria(criteria);

		// Then
		if (!CollectionUtils.isEmpty(results))
			for (Deal deal : results) {
				assertNotNull(deal);
				assertTrue(deal.getAsOfDate().after(criteria.getStartDate()));

			}
	}

}
