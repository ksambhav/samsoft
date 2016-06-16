/**
 * 
 */
package com.samsoft.crm.domain;

import java.util.SortedSet;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;

import com.samsoft.core.domain.TenantAwareBaseMongoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sambhav.jain
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerProfile extends TenantAwareBaseMongoEntity<String> {

	public static interface PROPS {
		String FULL_NAME = "fullName";
		String EYE_PRESCRIPTION = "eyePrescripition";
		String MOBILE = "mobile";
	}

	@TextIndexed
	protected String fullName;

	@Indexed(background = false, unique = true)
	protected String mobile;
	protected String address;

	protected SortedSet<EyePrescription> eyePrescripition;

}
