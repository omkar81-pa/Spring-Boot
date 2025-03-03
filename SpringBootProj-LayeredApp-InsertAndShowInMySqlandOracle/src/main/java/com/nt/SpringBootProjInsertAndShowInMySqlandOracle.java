package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.EmployeeController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class SpringBootProjInsertAndShowInMySqlandOracle {

	public static void main(String[] args) {
		// Start the Spring Boot application
		ApplicationContext ctx = SpringApplication.run(SpringBootProjInsertAndShowInMySqlandOracle.class, args);

		// Get the controller bean
		EmployeeController controller = ctx.getBean("empController", EmployeeController.class);

		// Create a Scanner object for user input
		Scanner sc = new Scanner(System.in);

		while (true) {
			// Show menu options
			System.out.println("\n1. Insert Employee");
			System.out.println("2. View Employees (Only Manager, Clerk, SalesMan)");
			System.out.println("3. Exit");
			System.out.print("Enter Choice: ");

			// Get user input for choice
			Integer choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine(); // Consume newline character
				// Input employee details

				System.out.print("Enter Employee Name: ");
				String ename = sc.next();

				System.out.print("Enter Employee Salary: ");
				Double salary = sc.nextDouble();

				System.out.print("Enter Employee Designation: ");
				String desg = sc.next();

				System.out.print("Enter Employee Department Number: ");
				Integer deptno = sc.nextInt();

				// Create an Employee object and set the details
				Employee emp = new Employee();

				emp.setEname(ename);
				emp.setSalary(salary);
				emp.setDesg(desg);
				emp.setDeptno(deptno);

				try {
					// Process employee insertion
					String resultMsg = controller.processEmployee(emp);
					System.out.println(resultMsg);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				// Input designations
				System.out.print("Enter Designation 1 (e.g. Manager): ");
				String desg1 = sc.next();

				System.out.print("Enter Designation 2 (e.g. Clerk): ");
				String desg2 = sc.next();

				System.out.print("Enter Designation 3 (e.g. SalesMan): ");
				String desg3 = sc.next();

				try {
					// Get the list of employees for the given designations
					List<Employee> list = controller.showEmployeelsByDesgs(desg1, desg2, desg3);
					System.out.println("Employees with designations " + desg1 + ", " + desg2 + ", " + desg3 + ":");
					list.forEach(emp1 -> System.out.println(emp1));
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 3:
				System.out.println("Exiting....");
				sc.close();
				((ConfigurableApplicationContext) ctx).close(); // Close Spring context
				return;

			default:
				System.out.println("Invalid choice! Please try again.");
			}
		}
	}
}
