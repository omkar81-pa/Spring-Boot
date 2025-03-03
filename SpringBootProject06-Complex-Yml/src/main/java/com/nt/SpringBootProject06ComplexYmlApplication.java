package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class SpringBootProject06ComplexYmlApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootProject06ComplexYmlApplication.class, args);

        Customer customer = ctx.getBean("cust", Customer.class);

        System.out.println(customer);
        ((ConfigurableApplicationContext) ctx).close();
    }
}
