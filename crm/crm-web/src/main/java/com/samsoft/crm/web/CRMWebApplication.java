/**
 * 
 */
package com.samsoft.crm.web;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import com.samsoft.crm.mongo.CustomerServiceConfiguration;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@Import({ CustomerServiceConfiguration.class })
public class CRMWebApplication extends WebMvcAutoConfigurationAdapter {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new PageableHandlerMethodArgumentResolver());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CRMWebApplication.class, args);
	}

}
