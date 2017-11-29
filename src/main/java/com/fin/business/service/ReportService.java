package com.fin.business.service;

import com.fin.business.models.Report;

public interface ReportService {
	public void add(Report sub);
	public void edit(Report sub);
	public Report getReportbySubID(int subID);
	public void delete(Report sub);
}
