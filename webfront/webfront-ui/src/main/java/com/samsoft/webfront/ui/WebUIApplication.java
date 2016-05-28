/**
 * 
 */
package com.samsoft.webfront.ui;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class WebUIApplication {

	@RequestMapping(method = RequestMethod.GET, value = "/me")
	public Principal me(Principal principal) {
		return principal;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebUIApplication.class, args);
	}

}
