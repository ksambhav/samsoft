/**
 * 
 */
package com.samsoft.core.domain;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author sambhav.jain
 *
 */
@Document
@Data
@Builder
@EqualsAndHashCode(doNotUseGetters = true, of = { "id" })
public abstract class BaseMongoEntity implements IdAware<String> {

	@Id
	protected String id;

	@CreatedDate
	protected Date dateCreated;
}
