package com.mohamed.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails mohamed = User.builder().username("Mohamed").password("{noop}123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();
		UserDetails rehab = User.builder().username("Rehab").password("{noop}123").roles("EMPLOYEE", "MANAGER").build();
		UserDetails zain = User.builder().username("Zain").password("{noop}123").roles("EMPLOYEEE").build();

		return new InMemoryUserDetailsManager(mohamed, rehab, zain);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> {
			configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
			.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
			.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
			.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
			
		});
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}

}
