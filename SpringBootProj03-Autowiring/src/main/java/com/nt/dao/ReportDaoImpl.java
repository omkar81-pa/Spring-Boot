package com.nt.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository("report")
@Lazy
public class ReportDaoImpl implements ReportDao {

	public ReportDaoImpl() {
		System.out.println("ReportDaoImpl:: 0-param constructor");
	}

	@Override
	public String findData() {
		System.out.println("fetching report from db...");
		return "Report Data";
	}
}
