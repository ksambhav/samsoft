/**
 * 
 */
package com.samsoft.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Kumar Sambhav Jain
 *
 */
@Configuration
@Order(-20)
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
			"/**/*.js",
			"/index.html" 
		};
	// @formatter:on

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// @formatter:off
		web
			.ignoring()
			.antMatchers(HttpMethod.GET, IGNORE_STATIC_RESOURCES);
		// @formatter:on
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http
			.formLogin()
				.loginPage("/")
				.loginProcessingUrl("/login")
			.and()
				.requestMatchers()
				.antMatchers("/","/login", "/oauth/authorize", "/oauth/confirm_access")
			.and()
				.csrf().disable();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager);
	}
}
