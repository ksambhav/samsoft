/**
 * 
 */
package com.samsoft.crm.mongo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author sambhav.jain
 *
 */
@Configuration
@EnableMongoRepositories
@SpringBootApplication
public class CustomerServiceConfiguration {

}
