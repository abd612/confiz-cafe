package com.confiz.confizcafe.repository;

import com.confiz.confizcafe.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

	private static final String COLLECTION = "employee";

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Employee> getAllEmployees() {
		return mongoTemplate.findAll(Employee.class, COLLECTION);
	}

	public Employee getEmployeeById(Integer id) {
		return mongoTemplate.findById(id, Employee.class, COLLECTION);
	}

	public Employee createEmployee(Employee employee) {
		return mongoTemplate.save(employee, COLLECTION);
	}

	public Employee updateEmployee(Employee employee) {
		return mongoTemplate.save(employee, COLLECTION);
	}

	public void deleteEmployee(Employee employee) {
		mongoTemplate.remove(employee, COLLECTION);
	}
}
