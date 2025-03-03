package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class SpringBootProject07RealtimeDiSpringBootProfilesApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootProject07RealtimeDiSpringBootProfilesApplication.class,
                args);

        EmployeeOperationsController controller = ctx.getBean("empController", EmployeeOperationsController.class);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Desg1: ");
        String desg1 = sc.next();

        System.out.print("Enter Desg2: ");
        String desg2 = sc.next();

        System.out.print("Enter Desg3: ");
        String desg3 = sc.next();

        sc.close();

        try {
            List<Employee> list = controller.showEmployeelsByDesgs(desg1, desg2, desg3);

            list.forEach(emp -> {
                System.out.println(emp);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
        ((ConfigurableApplicationContext) ctx).close();
    }
}
