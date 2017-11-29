package com.fin.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.business.models.Report;
import com.fin.business.service.ReportService;
import com.fin.dataSource.dao.EmployeeDAO;
import com.fin.dataSource.dao.ReportDAO;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired
	ReportDAO repD;
	
	@Transactional
	public void add(Report sub) {
		repD.add(sub);
	}

	@Transactional
	public void edit(Report sub) {
		repD.edit(sub);
	}

	@Transactional
	public Report getReportbySubID(int subID) {
		return repD.getReportbySubID(subID);
	}

	@Transactional
	public void delete(Report sub) {
		repD.delete(sub);
	}

}
