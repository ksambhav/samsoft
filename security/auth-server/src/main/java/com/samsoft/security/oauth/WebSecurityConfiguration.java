/**
 * 
 */
package com.samsoft.security.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kumar Sambhav Jain
 *
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	/**
	 * Ignored Static resources.
	 */
	// @formatter:off
	private static final String[] IGNORE_STATIC_RESOURCES = { 
			"/favicon.ico", 
			"/**/*.html", 
			"/**/*.less", 
			"/**/*.css",
			"/**/*.js" };
	// @formatter:on
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// @formatter:off
		web
			.ignoring()
			.antMatchers(HttpMethod.GET, IGNORE_STATIC_RESOURCES);
		// @formatter:on
	}
}
