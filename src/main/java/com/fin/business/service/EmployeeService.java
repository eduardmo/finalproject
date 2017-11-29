package com.fin.business.service;

import java.util.List;

import com.fin.business.models.Employee;

public interface EmployeeService {
	public void add(Employee employee);
	public void edit(Employee employee);
	public Employee getEmployeeByUserName(String username);
	public void delete(Employee employee);
	public List<Employee> getAllEmployees();
	Employee getEmployeeByPNC(long employeePNC);
	List<Employee> getAllManagers();

}
