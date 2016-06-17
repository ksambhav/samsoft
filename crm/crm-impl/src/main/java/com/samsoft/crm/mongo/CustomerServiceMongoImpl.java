/**
 * 
 */
package com.samsoft.crm.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.WriteResult;
import com.samsoft.crm.api.CustomerProfileService;
import com.samsoft.crm.domain.CustomerProfile;
import com.samsoft.crm.domain.EyePrescription;

/**
 * @author sambhav.jain
 *
 */
@Service
public class CustomerServiceMongoImpl implements CustomerProfileService {

	@Autowired
	protected CustomerProfileMongoRepo customerRepo;

	@Autowired
	protected MongoTemplate mongoTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#textSearchByName(java.lang.
	 * String)
	 */
	@Override
	public List<CustomerProfile> textSearchByName(String inputName) {

		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(inputName.split(" "));
		// @formatter:off
		Query query = TextQuery
						.queryText(criteria)
						.addCriteria(Criteria.where("tenant").is("test"))
						.limit(50);
		query.fields().include(CustomerProfile.PROPS.FULL_NAME).include(CustomerProfile.PROPS.MOBILE);
		
		//@formatter:on
		return mongoTemplate.find(query, CustomerProfile.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#findByMobile(java.lang.String)
	 */
	@Override
	public CustomerProfile findByMobile(String mobile) {
		return customerRepo.findByMobile(mobile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#findById(java.lang.String)
	 */
	@Override
	public CustomerProfile findById(String id) {
		return customerRepo.findOne(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#upsert(com.samsoft.crm.domain.
	 * CustomerProfile)
	 */
	@Override
	public CustomerProfile save(CustomerProfile customerProfile) {
		return customerRepo.save(customerProfile);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#addEyePrescription(java.lang.
	 * String, com.samsoft.crm.domain.EyePrescription)
	 */
	@Override
	public int addEyePrescription(String customerId, EyePrescription prescription) {
		WriteResult updateFirst = mongoTemplate.updateFirst(
				Query.query(Criteria.where("_id").is(customerId).and("tenant").is("test")),
				new Update().push(CustomerProfile.PROPS.EYE_PRESCRIPTION, prescription), CustomerProfile.class);
		return updateFirst.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.samsoft.crm.api.CustomerProfileService#removeEyePrescription(java.
	 * lang.String, java.lang.String)
	 */
	@Override
	public int removeEyePrescription(String customerId, String prescriptionId) {
		// @formatter:off
		WriteResult updateFirst = mongoTemplate
			.updateFirst(
					Query
						.query(Criteria
								.where("_id")
								.is(customerId)
								.and("tenant").is("test")),
					new Update().pull(CustomerProfile.PROPS.EYE_PRESCRIPTION, prescriptionId),
					CustomerProfile.class);
		// @formatter:on
		return updateFirst.getN();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.samsoft.crm.api.CustomerProfileService#deleteCustomer(java.lang.
	 * String)
	 */
	@Override
	public boolean deleteCustomer(String customerId) {
		CustomerProfile customerProfile = new CustomerProfile();
		customerProfile.setId(customerId);
		customerRepo.delete(customerProfile);
		return true;
	}

	@Override
	public List<CustomerProfile> save(List<CustomerProfile> customerProfiles) {
		return customerRepo.save(customerProfiles);
	}

	@Override
	public List<CustomerProfile> findAll() {
		return customerRepo.findAll();
	}

}
