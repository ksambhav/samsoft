/**
 * 
 */
package com.samsoft.crm.api;

import java.util.List;

import com.samsoft.crm.domain.CustomerProfile;
import com.samsoft.crm.domain.EyePrescription;

/**
 * @author sambhav.jain
 *
 */
public interface CustomerProfileService {

	List<CustomerProfile> textSearchByName(String inputName);

	CustomerProfile findByMobile(String mobile);

	CustomerProfile findById(String id);

	CustomerProfile upsert(CustomerProfile customerProfile);

	int addEyePrescription(String customerId, EyePrescription prescription);

	int removeEyePrescription(String customerId, String prescriptionId);

	boolean deleteCustomer(String customerId);
}
