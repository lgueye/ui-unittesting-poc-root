/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain.services;

import java.util.List;

import javax.jws.WebService;

import org.diveintojee.poc.ui.unittesting.domain.Deal;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@WebService
public interface DealService {

	String BEAN_ID = "dealService";

	String WEBSERVICE_ENDPOINT_INTERFACE = "org.diveintojee.poc.ui.unittesting.domain.services.DealService";

	List<Deal> findByCriteria(DealsSearchCriteria criteria);
}
