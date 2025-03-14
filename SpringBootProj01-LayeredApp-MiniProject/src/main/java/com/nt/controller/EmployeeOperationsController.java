package com.nt.controller;

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
}
