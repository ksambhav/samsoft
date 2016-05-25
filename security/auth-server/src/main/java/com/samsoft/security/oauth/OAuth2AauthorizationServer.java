/**
 * 
 */
package com.samsoft.security.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2AauthorizationServer {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2AauthorizationServer.class, args);
	}
}
