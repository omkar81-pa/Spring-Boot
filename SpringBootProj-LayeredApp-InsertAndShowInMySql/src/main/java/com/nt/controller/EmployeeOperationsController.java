package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("empController")
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeService empService;

	public String processEmployee(Employee emp) throws Exception {
		String resultMsg = empService.registerEmployee(emp);
		return resultMsg;
	}

	public List<Employee> showEmployeelsByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = empService.fetchEmployeesByDesg(desg1, desg2, desg3);

		return list;
	}
}
