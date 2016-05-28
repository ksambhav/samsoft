/**
 * 
 */
package com.samsoft.webfront.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@EnableOAuth2Sso
public class WebUIApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebUIApplication.class, args);
	}

}
