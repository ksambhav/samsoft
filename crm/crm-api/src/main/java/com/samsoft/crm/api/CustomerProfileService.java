/**
 * 
 */
package com.samsoft.crm.api;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

	CustomerProfile save(CustomerProfile customerProfile);

	List<CustomerProfile> save(List<CustomerProfile> customerProfiles);

	int addEyePrescription(String customerId, EyePrescription prescription);

	int removeEyePrescription(String customerId, String prescriptionId);

	boolean deleteCustomer(String customerId);

	Page<CustomerProfile> findAll(Pageable pageRequest);
}
