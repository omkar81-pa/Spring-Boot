package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDAO dao;

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		int count = dao.insertEmployee(emp);
		return count == 1 ? "Employee Registered Successfully" : "Employee Registration Failed";
	}
}
