package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.CurrentWorkingDays;

@SpringBootApplication
public class SpringBootProj01DependencyInjection1Application {

	@Bean(name = "ld")
	public LocalDateTime createDAte() {
		return LocalDateTime.now();
	}
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj01DependencyInjection1Application.class, args);
		
		CurrentWorkingDays finder = ctx.getBean("wmg", CurrentWorkingDays.class);
		
		String msg = finder.generateMessage("Omkar");
		
		System.out.println(msg);
	}

}
