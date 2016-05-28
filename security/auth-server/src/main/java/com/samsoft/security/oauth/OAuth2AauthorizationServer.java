/**
 * 
 */
package com.samsoft.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author Kumar Sambhav Jain
 *
 */
@SpringBootApplication
@EnableAuthorizationServer
public class OAuth2AauthorizationServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//@formatter:off
		clients.inMemory()
				.withClient("acme")
				.secret("acmesecret")
				.authorizedGrantTypes("authorization_code", "refresh_token", "password")
				.autoApprove(true)
				.redirectUris("http://localhost")
				.scopes("openid");
		//@formatter:on
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// @formatter:off
		endpoints
			.authenticationManager(authenticationManager)
			.tokenStore(tokenStore())
			.accessTokenConverter(jwtAccessTokenConverter());
		// @formatter:on
	}

	@Bean
	public TokenStore tokenStore() {
		TokenStore store = new JwtTokenStore(jwtAccessTokenConverter());
		return store;
	}

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		/*
		 * KeyPair keyPair = new KeyStoreKeyFactory(new
		 * ClassPathResource("keystore.jks"), "foobar".toCharArray())
		 * .getKeyPair("test"); converter.setKeyPair(keyPair);
		 */
		converter.setSigningKey("sambhav"); // simple symmetric encryption key.
		return converter;
	}

	public static void main(String[] args) {
		SpringApplication.run(OAuth2AauthorizationServer.class, args);
	}
}
