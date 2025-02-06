package com.nt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppSecurity {

	public AppSecurity() {
		System.out.println("AppSecurity::0-param constructor");
	}

	@Bean
	AppSecurity cerateInstance() {
		AppSecurity as = new AppSecurity();
		return as;
	}

}
