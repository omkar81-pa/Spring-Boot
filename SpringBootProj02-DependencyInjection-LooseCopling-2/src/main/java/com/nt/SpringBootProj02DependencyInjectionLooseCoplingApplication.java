package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Criketer;

@SpringBootApplication
@ImportResource("com/nt/cfgs/ApplicationContext.xml")
public class SpringBootProj02DependencyInjectionLooseCoplingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj02DependencyInjectionLooseCoplingApplication.class, args);
		
		Criketer criketer = ctx.getBean("criket", Criketer.class);
		
		String msg = criketer.batting();
		
		System.out.println(msg);
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
