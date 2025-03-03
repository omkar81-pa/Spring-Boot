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
public class SpringBootProjLayeredAppInsertAndShowInMySqlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProjLayeredAppInsertAndShowInMySqlApplication.class,
				args);

		EmployeeOperationsController controller = ctx.getBean("empController", EmployeeOperationsController.class);

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n1. Insert Employee");
			System.out.println("2. View Employee (Only Manager, Clerk, SalesMan)");
			System.out.println("3. Exit");
			System.out.print("Enter Choice: ");

			Integer choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.print("Enter Employee Name: ");
				String ename = sc.nextLine();

				System.out.print("Enter Employee Salery: ");
				Double salery = sc.nextDouble();

				System.out.print("Enter Employee Designation: ");
				String desg = sc.next();

				System.out.print("Enter Employee Department Number: ");
				Integer deptno = sc.nextInt();

				Employee emp = new Employee();

				emp.setEname(ename);
				emp.setSalary(salery);
				emp.setDesg(desg);
				emp.setDeptno(deptno);

				try {
					String resultMsg = controller.processEmployee(emp);
					System.out.println(resultMsg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				System.out.print("Enter Desg1: ");
				String desg1 = sc.next();

				System.out.print("Enter Desg2: ");
				String desg2 = sc.next();

				System.out.print("Enter Desg3: ");
				String desg3 = sc.next();

				try {
					List<Employee> list = controller.showEmployeelsByDesgs(desg1, desg2, desg3);
					System.out.println("Employees belonging to " + desg1 + " " + desg2 + " " + desg3 + " are");
					list.forEach(emp1 -> {
						System.out.println(emp1);
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("Exiting....");
				sc.close();
				((ConfigurableApplicationContext) ctx).close();
				return;

			default:
				System.out.println("Invalid choice! Try again.");
			}
		}
	}
}
