package com.fin.dataSource.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fin.business.models.Employee;
import com.fin.business.models.Subsidiary;
import com.fin.dataSource.dao.SubsidiaryDAO;

@Repository
public class SubsidiaryDAOImpl implements SubsidiaryDAO {

	@Autowired
	SessionFactory sessF;
	
	@Override
	public void add(Subsidiary sub) {
		sessF.getCurrentSession().save(sub);
	}

	@Override
	public void edit(Subsidiary sub) {
		sessF.getCurrentSession().update(sub);

	}

	@Override
	public Subsidiary getEmployeeByID(int subID) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Subsidiary.class);
		crit.add(Restrictions.like("subsidiaryID", subID));
		return (Subsidiary) crit.uniqueResult();
	}

	@Override
	public void delete(Subsidiary sub) {
		sessF.getCurrentSession().delete(sub);
	}

	@Override
	public List<Subsidiary> getAllSubsidiaries() {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Subsidiary.class);
		List<Subsidiary> list = (List<Subsidiary>)crit.list();
		
		return list;
	}

	@Override
	public Subsidiary getSubsidiaryByName(String subName) {
		sessF.getCurrentSession().beginTransaction();
		Criteria crit = sessF.getCurrentSession().createCriteria(Subsidiary.class);
		crit.add(Restrictions.like("subsidiaryName", subName));
		return (Subsidiary) crit.uniqueResult();
	}

}
