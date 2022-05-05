package com.confiz.confizcafe.controller;

import com.confiz.confizcafe.model.Admin;
import com.confiz.confizcafe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping(value = "/verifyAdmin")
	public String verifyAdmin(@RequestBody Admin admin) {
		return adminService.verifyAdmin(admin);
	}

	@GetMapping(value = "/getAllAdmins")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}

	@GetMapping(value = "/getAdmin/{id}")
	public Admin getAdmin(@PathVariable("id") Integer id) {
		return adminService.getAdminById(id);
	}

	@PostMapping(value = "/createAdmin")
	public Admin createAdmin(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		return adminService.createAdmin(id, name, username, password);
	}

	@PutMapping(value = "/updateAdmin")
	public Admin updateAdmin(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password) {
		return adminService.updateAdmin(id, name, username, password);
	}

	@DeleteMapping(value = "/deleteAdmin/{id}")
	public void deleteAdmin(@PathVariable("id") Integer id) {
		adminService.deleteAdmin(id);
	}
}
