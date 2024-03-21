package com.shubham.social.media.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.sessionManagement(
				management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		        .authorizeHttpRequests(Authorize -> Authorize
				.requestMatchers("/api/**").authenticated() // api starting with /api need usrname password
				.anyRequest().permitAll())  // non api staring with /api will be permitter
		        .httpBasic().and()
				.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}
