/**
 * 
 */
package com.samsoft.crm.mongo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author sambhav.jain
 *
 */
@Configuration
@EnableMongoRepositories
@EnableMongoAuditing
@SpringBootApplication
public class CustomerServiceConfiguration {

}
