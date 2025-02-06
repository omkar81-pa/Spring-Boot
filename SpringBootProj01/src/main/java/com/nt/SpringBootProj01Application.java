package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.nt", "nt.com.wallmart" })
public class SpringBootProj01Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj01Application.class, args);

		System.out.println(ctx.getClass().getName());

		System.out.println(ctx.getBeanDefinitionCount());

	}

}
