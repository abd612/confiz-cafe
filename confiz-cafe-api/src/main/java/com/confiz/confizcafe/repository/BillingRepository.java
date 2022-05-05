package com.confiz.confizcafe.repository;

import com.confiz.confizcafe.model.Billing;
import com.confiz.confizcafe.model.BillingSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class BillingRepository {

	private static final String COLLECTION = "billing";

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Billing> getAllBillings() {
		return mongoTemplate.findAll(Billing.class, COLLECTION);
	}

	public Billing getBillingById(String id) {
		return mongoTemplate.findById(id, Billing.class, COLLECTION);
	}

	public List<Billing> getBillingsByEmployeeId(Integer employeeId) {
		Query query = new Query(Criteria.where("employeeId").is(employeeId));
		return mongoTemplate.find(query, Billing.class, COLLECTION);
	}

	public List<Billing> getBillingsByDate(Date date) {
		Query query = new Query(Criteria.where("date").is(date));
		return mongoTemplate.find(query, Billing.class, COLLECTION);
	}

	public List<Billing> getBillingsBetweenDates(Date startDate, Date endDate) {
		Query query = new Query(Criteria.where("date").gte(startDate).lte(endDate));
		return mongoTemplate.find(query, Billing.class, COLLECTION);
	}

	public List<Billing> getBillingsByEmployeeIdBetweenDates(Integer employeeId, Date startDate, Date endDate) {
		Query query = new Query(Criteria.where("employeeId").is(employeeId).and("date").gte(startDate).lte(endDate));
		return mongoTemplate.find(query, Billing.class, COLLECTION);
	}

	public List<BillingSummary> getBillingSummaries(Date startDate, Date endDate) {
		MatchOperation match = Aggregation.match(Criteria.where("date").gte(startDate).lte(endDate));
		GroupOperation group = Aggregation.group("employeeId").sum("cost").as("totalBill");
		ProjectionOperation project = Aggregation.project().andExpression("_id").as("employeeId")
				.andExpression("totalBill").as("totalBill");
		Aggregation aggregation = Aggregation.newAggregation(match, group, project);
		AggregationResults<BillingSummary> results = mongoTemplate.aggregate(aggregation, COLLECTION,
				BillingSummary.class);
		return results.getMappedResults();
	}

	public List<BillingSummary> getBillingSummary(Integer employeeId, Date startDate, Date endDate) {
		MatchOperation match = Aggregation
				.match(Criteria.where("employeeId").is(employeeId).and("date").gte(startDate).lte(endDate));
		GroupOperation group = Aggregation.group("employeeId").sum("cost").as("totalBill");
		ProjectionOperation project = Aggregation.project().andExpression("_id").as("employeeId")
				.andExpression("totalBill").as("totalBill");
		Aggregation aggregation = Aggregation.newAggregation(match, group, project);
		AggregationResults<BillingSummary> results = mongoTemplate.aggregate(aggregation, COLLECTION,
				BillingSummary.class);
		return results.getMappedResults();
	}

	public Billing createBilling(Billing billing) {
		return mongoTemplate.save(billing, COLLECTION);
	}

	public Billing updateBilling(Billing billing) {
		return mongoTemplate.save(billing, COLLECTION);
	}

	public void deleteBilling(Billing billing) {
		mongoTemplate.remove(billing, COLLECTION);
	}
}
