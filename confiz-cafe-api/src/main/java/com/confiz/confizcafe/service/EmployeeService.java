package com.confiz.confizcafe.service;

import com.confiz.confizcafe.model.Employee;
import com.confiz.confizcafe.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	public Employee getEmployeeById(Integer id) {
		return employeeRepository.getEmployeeById(id);
	}

	public Employee createEmployee(Integer id, String name, String designation, List<byte[]> fingerprint) {
		Employee employee = new Employee();
		if (id != null)
			employee.setId(id);
		if (name != null)
			employee.setName(name);
		if (designation != null)
			employee.setDesignation(designation);
		if (fingerprint != null)
			employee.setFingerprint(fingerprint);
		return employeeRepository.createEmployee(employee);
	}

	public Employee updateEmployee(Integer id, String name, String designation, List<byte[]> fingerprint) {
		Employee employee = getEmployeeById(id);
		if (name != null)
			employee.setName(name);
		if (designation != null)
			employee.setDesignation(designation);
		if (fingerprint != null)
			employee.setFingerprint(fingerprint);
		return employeeRepository.updateEmployee(employee);
	}

	public void deleteEmployee(Integer id) {
		Employee employee = getEmployeeById(id);
		employeeRepository.deleteEmployee(employee);
	}
}
