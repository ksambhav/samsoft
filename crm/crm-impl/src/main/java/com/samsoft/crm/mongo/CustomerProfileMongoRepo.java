/**
 * 
 */
package com.samsoft.crm.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.samsoft.crm.domain.CustomerProfile;

/**
 * @author sambhav.jain
 *
 */
public interface CustomerProfileMongoRepo extends MongoRepository<CustomerProfile, String> {
	CustomerProfile findByMobile(String mobile);
}
