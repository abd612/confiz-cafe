package com.confiz.confizcafe.controller;

import com.confiz.confizcafe.model.Billing;
import com.confiz.confizcafe.model.BillingSummary;
import com.confiz.confizcafe.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class BillingController {

	@Autowired
	private BillingService billingService;

	@GetMapping(value = "/getAllBillings")
	public List<Billing> getAllBillings() {
		return billingService.getAllBillings();
	}

	@GetMapping(value = "/getBilling/{id}")
	public Billing getBilling(@PathVariable("id") String id) {
		return billingService.getBillingById(id);
	}

	@GetMapping(value = "/getBillingDetails")
	public List<Billing> getBillingDetails(@RequestParam(value = "employeeId", required = false) Integer employeeId,
			@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
		return billingService.getBillingDetails(employeeId, startDate, endDate);
	}

	@GetMapping(value = "/getBillingSummary")
	public List<BillingSummary> getBillingSummary(
			@RequestParam(value = "employeeId", required = false) Integer employeeId,
			@RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
		return billingService.getBillingSummary(employeeId, startDate, endDate);
	}

	@PostMapping(value = "/createBilling")
	public Billing createBilling(@RequestBody Integer employeeId) {
		return billingService.createBilling(employeeId, null, null);
	}

	@DeleteMapping(value = "/deleteBilling/{id}")
	public void deleteBilling(@PathVariable("id") String id) {
		billingService.deleteBilling(id);
	}
}
