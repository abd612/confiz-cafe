package com.confiz.confizcafe.service;

import com.confiz.confizcafe.model.Billing;
import com.confiz.confizcafe.model.BillingSummary;
import com.confiz.confizcafe.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillingService {

	private static final Double DEFAULT_COST = 100D;

	@Autowired
	private BillingRepository billingRepository;

	public List<Billing> getAllBillings() {
		return billingRepository.getAllBillings();
	}

	public Billing getBillingById(String id) {
		return billingRepository.getBillingById(id);
	}

	public List<Billing> getBillingsByEmployeeId(Integer employeeId) {
		return billingRepository.getBillingsByEmployeeId(employeeId);
	}

	public List<Billing> getBillingByDate(Date date) {
		return billingRepository.getBillingsByDate(date);
	}

	public List<Billing> getBillingDetails(Integer employeeId, String startDateString, String endDateString) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (employeeId != null)
			return billingRepository.getBillingsByEmployeeIdBetweenDates(employeeId, startDate, endDate);
		else
			return billingRepository.getBillingsBetweenDates(startDate, endDate);
	}

	public List<BillingSummary> getBillingSummary(Integer employeeId, String startDateString, String endDateString) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<BillingSummary> billingSummaries = new ArrayList<>();

		if (employeeId != null)
			billingSummaries = billingRepository.getBillingSummary(employeeId, startDate, endDate);
		else
			billingSummaries = billingRepository.getBillingSummaries(startDate, endDate);

		for (BillingSummary billingSummary : billingSummaries) {
			billingSummary.setStartDate(startDate);
			billingSummary.setEndDate(endDate);
		}

		return billingSummaries;
	}

	public Billing createBilling(Integer employeeId, String dateString, Double cost) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (dateString != null)
				date = formatter.parse(dateString);
			else
				date = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Billing billing = new Billing();
		if (employeeId != null)
			billing.setEmployeeId(employeeId);
		if (date != null)
			billing.setDate(date);
		if (cost != null)
			billing.setCost(cost);
		else
			billing.setCost(DEFAULT_COST);
		return billingRepository.createBilling(billing);
	}

	public Billing updateBilling(String id, Integer employeeId, Date date, Double cost) {
		Billing billing = getBillingById(id);
		if (employeeId != null)
			billing.setEmployeeId(employeeId);
		if (date != null)
			billing.setDate(date);
		if (cost != null)
			billing.setCost(cost);
		return billingRepository.updateBilling(billing);
	}

	public void deleteBilling(String id) {
		Billing billing = getBillingById(id);
		billingRepository.deleteBilling(billing);
	}
}
