package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.PatientInfo;

@SpringBootApplication
public class SpringBootProject03DataInjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
		// Start Spring Boot application and get application context
		ApplicationContext ctx = SpringApplication
				.run(SpringBootProject03DataInjectionUsingValueAnnotationApplication.class, args);

		// Retrieve and print PatientInfo bean
		PatientInfo info = ctx.getBean("pInfo", PatientInfo.class);
		System.out.println(info);
	}
}
