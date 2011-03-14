/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain.services;

import java.util.List;

import javax.jws.WebService;

import org.diveintojee.poc.ui.unittesting.domain.Entity;
import org.diveintojee.poc.ui.unittesting.domain.ProductType;

/**
 * @author louis.gueye@gmail.com
 * 
 */
@WebService
public interface ReferentialService {

	String BEAN_ID = "referentialService"; //$NON-NLS-1$

	String WEBSERVICE_ENDPOINT_INTERFACE = "org.diveintojee.poc.ui.unittesting.domain.services.ReferentialService"; //$NON-NLS-1$

	List<Entity> loadAllEntities();

	List<ProductType> loadAllProductTypes();

}
