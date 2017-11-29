package com.fin.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fin.business.models.Subsidiary;

public interface SubsidiaryService {
	public void add(Subsidiary sub);

	public void edit(Subsidiary sub);

	public Subsidiary getSubsidiaryByID(int subID);

	public void delete(Subsidiary sub);

	public List<Subsidiary> getAllSubsidiaries();

	public Subsidiary getSubsidiaryByName(String subName);
}
