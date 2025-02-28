package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	public String registerEmployee(Employee emp) {
		try {
			return service.registerEmployee(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}
}
