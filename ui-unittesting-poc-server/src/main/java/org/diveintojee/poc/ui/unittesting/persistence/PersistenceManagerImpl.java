/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.PersistableEntity;
import org.diveintojee.poc.ui.unittesting.domain.Product;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.springframework.stereotype.Component;

/**
 * @author louis.gueye@gmail.com
 */
@Component(PersistenceManager.BEAN_ID)
public class PersistenceManagerImpl implements PersistenceManager {

	private static String[] CURRENCY_CODES = null;

	public static Entity[] ENTITIES = null;

	private static Product[] PRODUCTS = null;

	public static ProductType[] PRODUCT_TYPES = null;

	private static Random rnd = new Random();

	static {
		PersistenceManagerImpl.CURRENCY_CODES = new String[] {
				Currency.getInstance(Locale.FRANCE).getCurrencyCode(),
				Currency.getInstance(Locale.UK).getCurrencyCode(),
				Currency.getInstance(Locale.US).getCurrencyCode() };

		Entity paris = new Entity();
		paris.setId(0L);
		paris.setCurrencyCodes(Arrays.asList(new String[] { "EUR", "USD" }));
		paris.setLabel("Paris");

		Entity london = new Entity();
		london.setId(1L);
		london.setCurrencyCodes(Arrays.asList(new String[] { "EUR", "GBP",
				"USD" }));
		london.setLabel("London");

		Entity newYork = new Entity();
		newYork.setId(2L);
		newYork.setCurrencyCodes(Arrays.asList(new String[] { "GBP", "USD" }));
		newYork.setLabel("New-York");

		Entity tokyo = new Entity();
		tokyo.setId(3L);
		tokyo.setCurrencyCodes(Arrays.asList(new String[] { "USD", "JPY" }));
		tokyo.setLabel("Tokyo");

		Entity hkg = new Entity();
		hkg.setId(4L);
		hkg.setCurrencyCodes(Arrays.asList(new String[] { "USD" }));
		hkg.setLabel("Hong-Kong");

		PersistenceManagerImpl.ENTITIES = new Entity[] { paris, london,
				newYork, hkg, tokyo };

		ProductType pt0 = new ProductType();
		pt0.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		pt0.setLabel("Bonds");

		ProductType pt1 = new ProductType();
		pt1.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		pt1.setLabel("Swap");

		ProductType pt2 = new ProductType();
		pt2.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		pt2.setLabel("Options");

		ProductType pt3 = new ProductType();
		pt3.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		pt3.setLabel("Futures");

		PersistenceManagerImpl.PRODUCT_TYPES = new ProductType[] { pt0, pt1,
				pt2, pt3 };

		Product p0 = new Product();
		p0.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));

		p0.setType(PersistenceManagerImpl.PRODUCT_TYPES[PersistenceManagerImpl.rnd
				.nextInt(PersistenceManagerImpl.PRODUCT_TYPES.length)]);
		p0.setIsin("FR0000000001");

		Product p1 = new Product();
		p1.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		p1.setType(PersistenceManagerImpl.PRODUCT_TYPES[PersistenceManagerImpl.rnd
				.nextInt(PersistenceManagerImpl.PRODUCT_TYPES.length)]);
		p1.setIsin("FR0000000002");

		Product p2 = new Product();
		p2.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		p2.setType(PersistenceManagerImpl.PRODUCT_TYPES[PersistenceManagerImpl.rnd
				.nextInt(PersistenceManagerImpl.PRODUCT_TYPES.length)]);
		p2.setIsin("US0000000001");

		Product p3 = new Product();
		p3.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		p3.setType(PersistenceManagerImpl.PRODUCT_TYPES[PersistenceManagerImpl.rnd
				.nextInt(PersistenceManagerImpl.PRODUCT_TYPES.length)]);
		p3.setIsin("US0000000002");

		Product p4 = new Product();
		p4.setId(Long.valueOf(PersistenceManagerImpl.rnd.nextInt(1000)));
		p4.setType(PersistenceManagerImpl.PRODUCT_TYPES[PersistenceManagerImpl.rnd
				.nextInt(PersistenceManagerImpl.PRODUCT_TYPES.length)]);
		p4.setIsin("US0000000003");

		PersistenceManagerImpl.PRODUCTS = new Product[] { p0, p1, p2, p3, p4 };

	}

	private final Map<Class<?>, Map<Long, Object>> repository = new HashMap<Class<?>, Map<Long, Object>>();

	/**
	 * @see org.diveintojee.poc.rest.persistence.PersistenceManager#clear(java.lang.Class)
	 */
	@Override
	public <T> void clear(final Class<T> entityClass) {

		if (entityClass == null)
			return;

		getRepository().remove(entityClass);

	}

	/**
	 * @see org.diveintojee.poc.rest.persistence.PersistenceManager#delete(java.lang.Class,
	 *      java.lang.Object)
	 */
	@Override
	public <T> void delete(final Class<T> entityClass, final Long id) {

		if (entityClass == null)
			return;

		if (id == null)
			return;

		Map<Long, Object> entities = getRepository().get(entityClass);

		if (MapUtils.isEmpty(entities))
			return;

		entities.remove(id);

	}

	/**
	 * @see org.diveintojee.poc.rest.persistence.PersistenceManager#findAll(java.lang.Class)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <T> List<T> findAll(final Class<T> entityClass) {

		if (entityClass == null)
			return null;

		Map<Long, Object> entities = getRepository().get(entityClass);

		if (MapUtils.isEmpty(entities))
			return null;

		return new ArrayList(entities.values());

	}

	/**
	 * @see org.diveintojee.poc.ui.unittesting.persistence.PersistenceManager#generateDeals(int,
	 *      int, int)
	 */
	@Override
	public Set<Deal> generateDeals(final int countDeals,
			final int dateIntervalInDays, final int maxAmount) {

		Set<Deal> deals = new HashSet<Deal>();

		Calendar endDateCalendar = Calendar.getInstance();
		endDateCalendar.add(Calendar.DAY_OF_MONTH, dateIntervalInDays);
		Date endDate = endDateCalendar.getTime();
		long max = endDate.getTime();

		Calendar beginDateCalendar = Calendar.getInstance();
		beginDateCalendar.add(Calendar.DAY_OF_MONTH, -dateIntervalInDays);
		Date beginDate = beginDateCalendar.getTime();
		long min = beginDate.getTime();

		for (int i = 0; i < countDeals; i++) {

			Deal deal = new Deal();

			Long id = Long.valueOf(i);
			deal.setId(id);

			deal.setAsOfDate(new Date(Math.round((Math.random() * (max - min))
					+ min)));

			deal.setEntity(PersistenceManagerImpl.ENTITIES[PersistenceManagerImpl.rnd
					.nextInt(PersistenceManagerImpl.ENTITIES.length)]);
			deal.setProduct(PersistenceManagerImpl.PRODUCTS[PersistenceManagerImpl.rnd
					.nextInt(PersistenceManagerImpl.PRODUCTS.length)]);
			deal.setCurrencyCode(PersistenceManagerImpl.CURRENCY_CODES[PersistenceManagerImpl.rnd
					.nextInt(PersistenceManagerImpl.CURRENCY_CODES.length)]);
			deal.setAmount(BigDecimal.valueOf(PersistenceManagerImpl.rnd
					.nextInt(maxAmount)));

			deals.add(deal);

		}

		return deals;

	}

	/**
	 * @see org.diveintojee.poc.rest.persistence.PersistenceManager#get(java.lang.Class,
	 *      java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(final Class<T> entityClass, final Long id) {

		if (entityClass == null)
			return null;

		if (id == null)
			return null;

		Map<Long, Object> entities = getRepository().get(entityClass);

		if (MapUtils.isEmpty(entities))
			return null;

		return (T) entities.get(id);

	}

	/**
	 * @return
	 */
	private Map<Class<?>, Map<Long, Object>> getRepository() {
		return repository;
	}

	/**
	 * @see org.diveintojee.poc.rest.persistence.PersistenceManager#persist(java.lang.Object)
	 */
	@Override
	public Long persist(final Object entity) {

		if (entity == null)
			return null;

		Map<Long, Object> entities = getRepository().get(entity.getClass());

		if (entities == null)
			getRepository().put(entity.getClass(), new HashMap<Long, Object>());

		entities = getRepository().get(entity.getClass());

		Set<Long> idsAsSet = entities.keySet();

		List<Long> idsAsList = new ArrayList<Long>(idsAsSet);

		Collections.sort(idsAsList);

		Long entityId = ((PersistableEntity) entity).getId();

		if (entityId == null) {

			Long lastId = idsAsList.size() == 0 ? null : idsAsList
					.get(idsAsList.size() - 1);

			if (lastId == null)
				((PersistableEntity) entity).setId(0L);
			else
				((PersistableEntity) entity).setId(Long.valueOf(lastId
						.longValue() + 1));

		}

		getRepository().get(entity.getClass()).put(
				((PersistableEntity) entity).getId(), entity);

		return ((PersistableEntity) entity).getId();

	}

}
