/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.business;

import java.util.Arrays;
import java.util.List;

import javax.jws.WebService;

import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;
import org.diveintojee.poc.ui.unittesting.domain.services.ReferentialService;
import org.diveintojee.poc.ui.unittesting.persistence.PersistenceManager;
import org.diveintojee.poc.ui.unittesting.persistence.PersistenceManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@Service(ReferentialService.BEAN_ID)
@WebService(endpointInterface = ReferentialService.WEBSERVICE_ENDPOINT_INTERFACE)
public class ReferentialServiceImpl implements ReferentialService {

	@Autowired
	@Qualifier(PersistenceManager.BEAN_ID)
	PersistenceManager persistenceManager;

	/**
	 * @see org.diveintojee.poc.ui.unittesting.domain.services.ReferentialService#loadAllEntities()
	 */
	@Override
	public List<Entity> loadAllEntities() {

		return Arrays.asList(PersistenceManagerImpl.ENTITIES);

	}

	@Override
	public List<ProductType> loadAllProductTypes() {

		return Arrays.asList(PersistenceManagerImpl.PRODUCT_TYPES);

	}

}
