package com.hr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/hr/home", "/hr/signIn", "/hr/createUser")
						.permitAll().anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/hr/signIn").failureUrl("/hr/signIn?error=true").loginProcessingUrl("/login")
						.usernameParameter("empNetworkId").passwordParameter("password")// by default spring expects
						 // username parameter as
						// username
						.defaultSuccessUrl("/hr/homePage", true).permitAll());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}