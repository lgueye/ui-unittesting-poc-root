/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

import java.io.Serializable;

/**
 * @author louis.gueye@gmail.com
 */
public interface PersistableEntity extends Serializable {

	/**
	 * @return
	 */
	Long getId();

	/**
	 * @param id
	 */
	void setId(Long id);
}
