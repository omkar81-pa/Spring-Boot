package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class SpringBootProject04ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProject04ConfigurationPropertiesApplication.class, args);
		
		Company company = ctx.getBean("comp", Company.class);
		
		System.out.println(company);
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
