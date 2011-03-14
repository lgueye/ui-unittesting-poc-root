/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.diveintojee.poc.ui.unittesting.domain.Deal;
import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.DealService;
import org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria;
import org.diveintojee.poc.ui.unittesting.persistence.PersistenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@Service(DealService.BEAN_ID)
@WebService(endpointInterface = DealService.WEBSERVICE_ENDPOINT_INTERFACE)
public class DealServiceImpl implements DealService {

	@Autowired
	@Qualifier(PersistenceManager.BEAN_ID)
	PersistenceManager persistenceManager;

	/**
	 * @see org.diveintojee.poc.ui.unittesting.domain.services.DealService#findByCriteria(org.diveintojee.poc.ui.unittesting.domain.services.DealsSearchCriteria)
	 */
	@Override
	public List<Deal> findByCriteria(final DealsSearchCriteria criteria) {

		Set<Deal> deals = persistenceManager.generateDeals(100, 20, 1000000);

		if (CollectionUtils.isEmpty(deals))
			return null;

		List<Deal> results = new ArrayList<Deal>();

		if (criteria == null)
			return results;

		for (Deal deal : deals)
			if (matchesStartDate(criteria, deal)
					&& matchesEndDate(criteria, deal)
					&& matchesCurrency(criteria, deal)
					&& matchesEntity(criteria, deal)
					&& matchesProductType(criteria, deal)
					&& matchesIsin(criteria, deal))
				results.add(deal);

		return results;
	}

	protected boolean matchesCurrency(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || CollectionUtils.isEmpty(criteria
				.getCurrencyCodes()))
				&& StringUtils.isEmpty(deal.getCurrencyCode()))
			return true;

		if ((criteria == null || CollectionUtils.isEmpty(criteria
				.getCurrencyCodes()))
				&& !StringUtils.isEmpty(deal.getCurrencyCode()))
			return true;

		if (StringUtils.isEmpty(deal.getCurrencyCode()))
			return false;

		List<String> searchValue = criteria.getCurrencyCodes();

		String dealProperty = deal.getCurrencyCode();

		if (CollectionUtils.isEmpty(searchValue))
			return true;

		return searchValue.contains(dealProperty);

	}

	protected boolean matchesEndDate(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || criteria.getEndDate() == null)
				&& deal.getAsOfDate() == null)
			return true;

		if (criteria == null || criteria.getEndDate() == null)
			return true;

		if (deal.getAsOfDate() == null)
			return false;

		Date searchValue = criteria.getEndDate();

		Date dealProperty = deal.getAsOfDate();

		if (searchValue == null)
			return true;

		return (dealProperty.equals(searchValue) || dealProperty
				.before(searchValue));

	}

	protected boolean matchesEntity(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || criteria.getEntity() == null)
				&& (deal == null || deal.getEntity() == null))
			return true;

		if (criteria == null || criteria.getEntity() == null)
			return true;

		if (deal == null || deal.getEntity() == null)
			return false;

		Entity searchValue = criteria.getEntity();

		Entity dealProperty = deal.getEntity();

		if (searchValue == null)
			return true;

		return dealProperty.equals(searchValue);

	}

	protected boolean matchesIsin(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || StringUtils.isEmpty(criteria.getIsin()))
				&& (deal.getProduct() == null || StringUtils.isEmpty(deal
						.getProduct().getIsin())))
			return true;

		if (criteria == null || StringUtils.isEmpty(criteria.getIsin()))
			return true;

		if (deal.getProduct() == null
				|| StringUtils.isEmpty(deal.getProduct().getIsin()))
			return false;

		String searchValue = criteria.getIsin();

		String dealProperty = deal.getProduct().getIsin();

		if (StringUtils.isEmpty(searchValue))
			return true;

		return dealProperty.equals(searchValue);

	}

	protected boolean matchesProductType(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || criteria.getProductType() == null)
				&& (deal.getProduct() == null || deal.getProduct().getType() == null))
			return true;

		if (criteria == null || criteria.getProductType() == null)
			return true;

		if (deal.getProduct() == null || deal.getProduct().getType() == null)
			return false;

		ProductType searchValue = criteria.getProductType();

		ProductType dealProperty = deal.getProduct().getType();

		if (searchValue == null)
			return true;

		return dealProperty.equals(searchValue);

	}

	protected boolean matchesStartDate(final DealsSearchCriteria criteria,
			final Deal deal) {

		if (deal == null)
			return false;

		if ((criteria == null || criteria.getStartDate() == null)
				&& deal.getAsOfDate() == null)
			return true;

		if (criteria == null || criteria.getStartDate() == null)
			return true;

		if (deal.getAsOfDate() == null)
			return false;

		Date searchValue = criteria.getStartDate();

		Date dealProperty = deal.getAsOfDate();

		if (searchValue == null)
			return true;

		return (dealProperty.equals(searchValue) || dealProperty
				.after(searchValue));

	}
}
