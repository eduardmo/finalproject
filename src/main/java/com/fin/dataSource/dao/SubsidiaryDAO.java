package com.fin.dataSource.dao;

import java.util.List;
import com.fin.business.models.Subsidiary;

public interface SubsidiaryDAO {
	public void add(Subsidiary sub);
	public void edit(Subsidiary sub);
	public Subsidiary getEmployeeByID(int subID);
	public Subsidiary getSubsidiaryByName(String subName);
	public void delete(Subsidiary sub);
	public List<Subsidiary> getAllSubsidiaries();
}
