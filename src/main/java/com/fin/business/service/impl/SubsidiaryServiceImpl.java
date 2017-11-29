package com.fin.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fin.business.models.Subsidiary;
import com.fin.business.service.SubsidiaryService;
import com.fin.dataSource.dao.SubsidiaryDAO;

@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {

	@Autowired
	SubsidiaryDAO subD;
	
	@Transactional
	public void add(Subsidiary sub) {
		subD.add(sub);
	}

	@Transactional
	public void edit(Subsidiary sub) {
		subD.edit(sub);
	}

	@Transactional
	public Subsidiary getSubsidiaryByID(int subID) {
		return subD.getEmployeeByID(subID);
	}

	@Transactional
	public void delete(Subsidiary sub) {
		subD.delete(sub);

	}

	@Transactional
	public List<Subsidiary> getAllSubsidiaries() {
		return subD.getAllSubsidiaries();
	}

	@Override
	public Subsidiary getSubsidiaryByName(String subName) {
		return subD.getSubsidiaryByName(subName);
	}


}
