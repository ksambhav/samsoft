/**
 * 
 */
package com.samsoft.core.domain;

/**
 * @author sambhav.jain
 *
 */
public interface TenantAware<T> {

	T getTenant();
}
