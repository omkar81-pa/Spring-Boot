package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("mysql_empDAO")
public class MySqlEmployeeDAOImpl implements IEmployeeDAO {

	@Autowired
	private DataSource ds;

	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE(ENAME, SALARY, DESG, DEPTNO) VALUES(?, ?, ?, ?)";

	@Override
	public Integer insertEmployee(Employee emp) throws Exception {
		Integer result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE)) {

			ps.setString(1, emp.getEname());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getDesg());
			ps.setInt(4, emp.getDeptno());

			result = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
}
