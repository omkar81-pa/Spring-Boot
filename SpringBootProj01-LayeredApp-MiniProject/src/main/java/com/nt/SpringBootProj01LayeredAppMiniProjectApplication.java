package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.EmployeeOperationsController;
import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class SpringBootProj01LayeredAppMiniProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootProj01LayeredAppMiniProjectApplication.class, args);

		EmployeeOperationsController controller1 = ctx.getBean("empController", EmployeeOperationsController.class);

		PayrollMgmtOperationsController controller = ctx.getBean("payroll-controller",
				PayrollMgmtOperationsController.class);

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter EmpNo: ");
		int empNo = sc.nextInt();
		System.out.print("Enter name: ");
		String name = sc.next();

		System.out.print("Enter desg: ");
		String desg = sc.next();

		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();

		System.out.print("Enter deptno (10,20, 30, 40,....)");
		int deptno = sc.nextInt();

		Employee emp1 = new Employee();
		emp1.setEmpno(empNo);
		emp1.setEname(name);
		emp1.setDesg(desg);
		emp1.setDeptno(deptno);
		emp1.setSalary(salary);

		try {
			String resultMsg = controller1.processEmployee(emp1);
			System.out.println(resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.print("Enter Desg1: ");
		String desg1 = sc.next();

		System.out.print("Enter Desg2: ");
		String desg2 = sc.next();

		System.out.print("Enter Desg3: ");
		String desg3 = sc.next();

		sc.close();

		try {
			List<Employee> list = controller.showEmployeelsByDesgs(desg1, desg2, desg3);
			System.out.println("Employees belonging to " + desg1 + " " + desg2 + " " + desg3 + " are");
			list.forEach(emp -> {
				System.out.println(emp);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}
}
