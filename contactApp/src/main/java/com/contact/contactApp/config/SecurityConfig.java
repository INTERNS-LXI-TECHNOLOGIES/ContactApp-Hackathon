package com.contact.contactApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors(withDefaults())
		    .csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/contactapp/signup","/contactapp/get/signup","/cumulus/client/signup").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(withDefaults())
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
    // @Bean
	// public PasswordEncoder passwordEncoder(){
	// 	return new BCryptPasswordEncoder();
	// }
}
