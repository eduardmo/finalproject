package com.fin.business.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopdb.report")
public class Report {
	@Id
	@Column
	private int reportID;
	@Column
	private float profit;
	@Column
	private int itemsSold;
	@Column
	private int subsidiaryID;
	public int getReportID() {
		return reportID;
	}
	public void setReportID(int reportID) {
		this.reportID = reportID;
	}
	public float getProfit() {
		return profit;
	}
	public void setProfit(float profit) {
		this.profit = profit;
	}
	public int getItemsSold() {
		return itemsSold;
	}
	public void setItemsSold(int itemsSold) {
		this.itemsSold = itemsSold;
	}
	public int getSubsidiaryID() {
		return subsidiaryID;
	}
	public void setSubsidiaryID(int subsidiaryID) {
		this.subsidiaryID = subsidiaryID;
	}

}
