package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.ReportService;

@SpringBootApplication
public class SpringBootProj03AutowiringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj03AutowiringApplication.class, args);
		
		ReportService reportService =ctx.getBean(ReportService.class);
		
		reportService.generateReport();
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
