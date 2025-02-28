package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Hotel;
import com.nt.sbeans.MenuItemPrices;

@SpringBootApplication
public class SpringBootProject02ValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProject02ValueAnnotationApplication.class, args);

		Hotel hotal = ctx.getBean("hotel", Hotel.class);
		System.out.println(hotal);

		MenuItemPrices mPrices = ctx.getBean("menup", MenuItemPrices.class);
		System.out.println(mPrices);
		((ConfigurableApplicationContext) ctx).close();
	}
}
