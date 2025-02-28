package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("MySql_empDAO")
public class MySqlEmployeeDAOImpl implements IEmployeeDAO {

	private static final String GET_EMPS_BY_DESGS = "SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String INSERT_EMPLOYEE_STRING = "INSERT INTO EMP(ENAME,SAL,JOB,DEPTNO) VALUES(?,?,?,?)";

	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESGS);) {
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			try (ResultSet rs = ps.executeQuery();) {
				list = new ArrayList();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));

					list.add(emp);
				}
			}
		} catch (SQLException se) {
			System.out.println("Some DB Problems, wait for sumTime");
			throw se;
		} catch (Exception e) {
			System.out.println("Some up known Problems, wait for sumTime");
			throw e;
		}
		return list;
	}

	@Override
	public Integer insertEmployee(Employee emp) throws Exception {
		Integer result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE_STRING);) {
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
