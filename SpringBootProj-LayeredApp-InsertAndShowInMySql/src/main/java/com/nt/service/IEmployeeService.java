package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
	public String registerEmployee(Employee emp) throws Exception;

	public List<Employee> fetchEmployeesByDesg(String desg1, String desg2, String desg3) throws Exception;
}