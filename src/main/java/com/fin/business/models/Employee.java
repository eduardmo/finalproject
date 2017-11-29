package com.fin.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersdb.employee")
public class Employee {
	@Id
	@Column
	private long employeePNC;
	@Column
	private String employeeName;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public long getEmployeePNC() {
		return employeePNC;
	}
	public void setEmployeePNC(long employeePNC) {
		this.employeePNC = employeePNC;
	}
	
}
