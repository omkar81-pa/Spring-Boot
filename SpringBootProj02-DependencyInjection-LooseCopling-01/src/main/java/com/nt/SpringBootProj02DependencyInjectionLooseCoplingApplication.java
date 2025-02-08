package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/ApplicationContext.xml")
public class SpringBootProj02DependencyInjectionLooseCoplingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj02DependencyInjectionLooseCoplingApplication.class, args);
		
		Vehicle vehicle = ctx.getBean("vehicle", Vehicle.class);
		
		String msg = vehicle.journey("Hyd", "Rewa");
		
		System.out.println(msg);
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
