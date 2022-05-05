package com.confiz.confizcafe.controller;

import com.confiz.confizcafe.model.Employee;
import com.confiz.confizcafe.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping(value = "/getEmployee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@PostMapping(value = "/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee.getId(), employee.getName(), employee.getDesignation(),
				employee.getFingerprint());
	}

	@PutMapping(value = "/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee.getId(), employee.getName(), employee.getDesignation(),
				employee.getFingerprint());
	}

	@DeleteMapping(value = "/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}
}
