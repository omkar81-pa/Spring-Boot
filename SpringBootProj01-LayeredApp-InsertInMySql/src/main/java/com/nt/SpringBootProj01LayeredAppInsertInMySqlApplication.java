package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeController;
import com.nt.model.Employee;

@SpringBootApplication
public class SpringBootProj01LayeredAppInsertInMySqlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj01LayeredAppInsertInMySqlApplication.class, args);

		EmployeeController controller = ctx.getBean("employee", EmployeeController.class);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name: ");
		String ename = sc.nextLine();
		System.out.println("Enter Employee Salary: ");
		double salary = sc.nextDouble();

		sc.nextLine(); // consume newline

		System.out.println("Enter Employee Designation: ");
		String desg = sc.nextLine();

		System.out.println("Enter Employee Department Number: ");
		int deptno = sc.nextInt();

		Employee emp = new Employee();
		emp.setEname(ename);
		emp.setSalary(salary);
		emp.setDesg(desg);
		emp.setDeptno(deptno);

		try {
			String result = controller.registerEmployee(emp);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
		sc.close();
	}
}
