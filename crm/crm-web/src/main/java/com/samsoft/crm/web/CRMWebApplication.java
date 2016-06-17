/**
 * 
 */
package com.samsoft.crm.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.samsoft.crm.mongo.CustomerServiceConfiguration;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@Import({ CustomerServiceConfiguration.class })
public class CRMWebApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CRMWebApplication.class, args);
	}

}
