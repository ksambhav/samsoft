/**
 * 
 */
package com.samsoft.core.domain;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sambhav.jain
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters=true,callSuper=true)
@CompoundIndexes({ @CompoundIndex(name = "tenant_index", unique = false, def = "{tenant:1}") })
public abstract class TenantAwareBaseMongoEntity<T> extends BaseMongoEntity implements TenantAware<T> {

	protected T tenant;

	/**
	 * @return the tenant
	 */
	public T getTenant() {
		return tenant;
	}

	/**
	 * @param tenant
	 *            the tenant to set
	 */
	public void setTenant(T tenant) {
		this.tenant = tenant;
	}

}
