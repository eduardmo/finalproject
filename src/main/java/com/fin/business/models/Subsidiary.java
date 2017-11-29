package com.fin.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="chaindb.subsidiary")
public class Subsidiary {
	@Id
	@Column
	private int subsidiaryID;
	@Column
	private String subsidiaryName;
	@Column
	private float subsidiaryProfits;
	@Column
	private long subsidiaryManagerPNC;
	@Column
	private String requestStatus;
	
	public String getSubsidiaryName() {
		return subsidiaryName;
	}
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
	}
	public float getSubsidiaryProfits() {
		return subsidiaryProfits;
	}
	public void setSubsidiaryProfits(float subsidiaryProfits) {
		this.subsidiaryProfits = subsidiaryProfits;
	}
	public long getSubsidiaryManagerPNC() {
		return subsidiaryManagerPNC;
	}
	public void setSubsidiaryManagerPNC(long subsidiaryManagerPNC) {
		this.subsidiaryManagerPNC = subsidiaryManagerPNC;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String subsidiaryRequests) {
		this.requestStatus = subsidiaryRequests;
	}
	public int getSubsidiaryID() {
		return subsidiaryID;
	}
	public void setSubsidiaryID(int subsidiaryID) {
		this.subsidiaryID = subsidiaryID;
	}
}
