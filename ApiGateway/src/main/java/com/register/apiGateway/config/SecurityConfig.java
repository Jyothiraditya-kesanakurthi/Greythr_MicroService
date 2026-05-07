package com.register.apiGateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {

		return http.csrf(csrf -> csrf.disable()).authorizeExchange(
				ex -> ex.pathMatchers(HttpMethod.OPTIONS).permitAll().anyExchange().permitAll()

		).build();
	}
}