package com.mohamed.springboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails mohamed = User.builder()
				.username("Mohamed")
				.password("{noop}123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN")
				.build();
		UserDetails rehab = User.builder()
				.username("Rehab")
				.password("{noop}123")
				.roles("EMPLOYEE", "MANAGER")
				.build();
		UserDetails zain = User.builder()
				.username("Zain")
				.password("{noop}123")
				.roles("EMPLOYEEE")
				.build();
		
		return new InMemoryUserDetailsManager(mohamed, rehab, zain);
	}
}
