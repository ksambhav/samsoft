/**
 * 
 */
package com.samsoft.core.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author sambhav.jain
 *
 */
@Document
@Data
@EqualsAndHashCode(doNotUseGetters = true, of = { "id" })
@NoArgsConstructor
public abstract class BaseMongoEntity implements Identifiable<String> {

	@Id
	protected String id;

	@CreatedDate
	protected Date dateCreated;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
