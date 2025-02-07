package com.nt.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("oracle")
@Lazy
public class OracleReportDaoImpl implements ReportDao {

	public OracleReportDaoImpl() {
		System.out.println("OracleReportDaoImpl:: 0-param constructor");
	}

	@Override
	public String findData() {
		System.out.println("fetching report from db...");
		return "Report Data";
	}
}
