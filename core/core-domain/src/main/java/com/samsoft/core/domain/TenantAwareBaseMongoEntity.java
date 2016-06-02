/**
 * 
 */
package com.samsoft.core.domain;

import lombok.Data;

/**
 * @author sambhav.jain
 *
 */
@Data
public abstract class TenantAwareBaseMongoEntity<T> extends BaseMongoEntity implements TenantAware<T> {
	
	protected T tenant;
}
