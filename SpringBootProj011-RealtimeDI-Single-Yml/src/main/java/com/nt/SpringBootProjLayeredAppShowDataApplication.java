package com.nt;

import java.beans.PropertyVetoException;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class SpringBootProjLayeredAppShowDataApplication {
   

    @Bean(name = "c3p0")
    @Profile("test")
    DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        // Set Database Connection Properties
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/EmployeeDB");
        dataSource.setUser("root");
        dataSource.setPassword("Omkar@123");

        // C3P0 Connection Pool Settings
        dataSource.setMinPoolSize(10);
        dataSource.setMaxPoolSize(100);
        dataSource.setAcquireIncrement(5);
        dataSource.setMaxIdleTime(300);
        dataSource.setIdleConnectionTestPeriod(60);
        dataSource.setTestConnectionOnCheckout(true);

        return dataSource;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringBootProjLayeredAppShowDataApplication.class, args);

        PayrollMgmtOperationsController controller = ctx.getBean("payroll-controller",
                PayrollMgmtOperationsController.class);

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
        ((ConfigurableApplicationContext) ctx).close();
    }
}
