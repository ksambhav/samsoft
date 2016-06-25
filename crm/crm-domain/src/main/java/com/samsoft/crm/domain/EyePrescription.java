/**
 * 
 */
package com.samsoft.crm.domain;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sambhav.jain
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EyePrescription implements Comparable<EyePrescription> {

	@Data
	@Builder
	@AllArgsConstructor
	@NoArgsConstructor
	public static final class Prescription {
		
		protected float sph;
		protected float cyl;
		protected short axis;
		protected float add;
	}

	@NotNull
	@Valid
	protected Prescription left;

	@NotNull
	@Valid
	protected Prescription right;

	protected LocalDate dateCreated;

	@Override
	public int compareTo(EyePrescription o) {
		return this.dateCreated.compareTo(o.dateCreated);
	}
}
