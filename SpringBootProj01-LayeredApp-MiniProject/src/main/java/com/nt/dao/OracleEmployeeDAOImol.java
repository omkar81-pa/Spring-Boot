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

@Repository("Oracle_empDAO")
public class OracleEmployeeDAOImol implements IEmployeeDAO {

	@Autowired
	private DataSource ds;

	private static final String INSERT_EMPLOYEE = "INSERT INTO EMP(EMPNO, ENAME, JOB, SAL, DEPTNO)VALUES (?, ?, ?, ?, ?)";
	private static final String GET_EMPS_QUERY = "SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE JOB IN(?, ?, ?) ORDER BY JOB";

	@Override
	public Integer insertEmployee(Employee emp) throws Exception {
		Integer result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEE);) {
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getDesg());
			ps.setDouble(4, emp.getSalary());
			ps.setInt(5, emp.getDeptno());

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

	@Override
	public List<Employee> showEmployeesByDesgs(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_QUERY);) {
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);

			try (ResultSet rs = ps.executeQuery();) {
				list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getDouble(4));
					emp.setDeptno(rs.getInt(5));

					list.add(emp);
				}
			} catch (SQLException se) {
				se.printStackTrace();
				throw se;
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}
		return list;
	}
}
