package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeServiceImpl implements IEmployeeMgmtService {

	@Autowired
	@Qualifier("oracle_empDAO")
	private IEmployeeDAO empDao;

	@Override
	public List<Employee> fatchEmployeeByDesgs(String desg1, String desg2, String desg3) throws Exception {
		desg1 = desg1.toUpperCase();
		desg2 = desg2.toUpperCase();
		desg3 = desg3.toUpperCase();
		List<Employee> list = empDao.showEmployeesByDesgs(desg1, desg2, desg3);

		list.forEach(emp -> {
			
			emp.setGrossSalary(emp.getSalary() + (emp.getSalary() * 0.4));
			emp.setNetSalary(emp.getGrossSalary() - (emp.getGrossSalary() * 0.15));
		});
		return list;
	}
}
