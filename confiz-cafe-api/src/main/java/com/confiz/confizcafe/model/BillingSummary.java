package com.confiz.confizcafe.model;

import java.util.Date;

public class BillingSummary {

	private Integer employeeId;
	private Date startDate;
	private Date endDate;
	private Double totalBill;

	public BillingSummary() {
	}

	public BillingSummary(Integer employeeId, Date startDate, Date endDate, Double totalBill) {
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalBill = totalBill;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
}
