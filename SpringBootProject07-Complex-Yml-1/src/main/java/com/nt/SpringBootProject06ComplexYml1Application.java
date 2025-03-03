package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class SpringBootProject06ComplexYml1Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProject06ComplexYml1Application.class, args);
		
		Employee employee = ctx.getBean("emp", Employee.class);
		
		System.out.println(employee); 
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
