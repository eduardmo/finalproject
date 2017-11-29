package com.fin.dataSource.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.business.models.Report;
import com.fin.business.models.Subsidiary;
import com.fin.dataSource.dao.ReportDAO;

@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	SessionFactory sessF;
	
	
	@Override
	public void add(Report sub) {
		sessF.getCurrentSession().save(sub);
	}

	@Override
	public void edit(Report sub) {
		sessF.getCurrentSession().update(sub);		
	}

	@Override
	public Report getReportbySubID(int subID) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Report.class);
		crit.add(Restrictions.like("subsidiaryID", subID));
		return (Report) crit.uniqueResult();
	}

	@Override
	public void delete(Report sub) {
		sessF.getCurrentSession().delete(sub);		
	}

	@Override
	public List<Report> getAllSubsidiaries() {
		return null;
	}

}
