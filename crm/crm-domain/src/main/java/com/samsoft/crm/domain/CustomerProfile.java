/**
 * 
 */
package com.samsoft.crm.domain;

import java.util.SortedSet;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.samsoft.core.domain.TenantAwareBaseMongoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sambhav.jain
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, callSuper = true)
@JsonInclude(value = Include.NON_NULL)
public class CustomerProfile extends TenantAwareBaseMongoEntity<String> {

	public static interface PROPS {
		String FULL_NAME = "fullName";
		String EYE_PRESCRIPTION = "eyePrescripition";
		String MOBILE = "mobile";
	}

	@TextIndexed
	@NotEmpty
	protected String fullName;

	@Indexed(background = false, unique = true)
	@Pattern(regexp = "\\d{10}")
	protected String mobile;
	protected String address;

	@Valid
	protected SortedSet<EyePrescription> eyePrescripition;

}
