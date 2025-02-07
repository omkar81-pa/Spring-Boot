package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.ReportDao;

@Service
public class ReportService {

	@Autowired
	@Qualifier("oracle")
	private ReportDao reportDao;
	
	public void generateReport() {
		reportDao.findData();
		System.out.println("generating report........");
	}
}
