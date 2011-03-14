/**
 * 
 */
package org.diveintojee.poc.ui.unittesting.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author louis.gueye@gmail.com
 */
public class AbstractPersistableEntity implements PersistableEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1811720500803292244L;
	protected Long id;

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public final boolean equals(final Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof AbstractPersistableEntity))
			return false;
		AbstractPersistableEntity other = (AbstractPersistableEntity) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * @see org.diveintojee.poc.rest.domain.PersistableEntity#getId()
	 */
	@Override
	public Long getId() {
		return this.id;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public void setId(final Long id) {
		this.id = id;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
