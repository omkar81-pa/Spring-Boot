package com.nt.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("mysql")
@Lazy
public class MysqlReportDaoImpl implements ReportDao {

	public MysqlReportDaoImpl() {
		System.out.println("MysqlReportDaoImpl:: 0-param constructor");
	}

	@Override
	public String findData() {
		System.out.println("fetching report from db...");
		return "Report Data";
	}
}
