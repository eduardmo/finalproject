package com.fin.dataSource.dao;

import java.util.List;

import com.fin.business.models.Report;

public interface ReportDAO {
	public void add(Report sub);
	public void edit(Report sub);
	public Report getReportbySubID(int subID);
	public void delete(Report sub);
	public List<Report> getAllSubsidiaries();
}
