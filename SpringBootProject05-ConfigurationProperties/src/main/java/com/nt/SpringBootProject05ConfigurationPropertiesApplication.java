package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class SpringBootProject05ConfigurationPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProject05ConfigurationPropertiesApplication.class, args);
		
		Employee employee = ctx.getBean("emp", Employee.class);
		System.out.println(employee);
	}
}
