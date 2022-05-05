package com.confiz.confizcafe.service;

import com.confiz.confizcafe.model.Admin;
import com.confiz.confizcafe.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	public String verifyAdmin(Admin admin) {
		return adminRepository.verifyAdmin(admin);
	}

	public List<Admin> getAllAdmins() {
		return adminRepository.getAllAdmins();
	}

	public Admin getAdminById(Integer id) {
		return adminRepository.getAdminById(id);
	}

	public Admin createAdmin(Integer id, String name, String username, String password) {
		Admin admin = new Admin();
		if (id != null)
			admin.setId(id);
		if (name != null)
			admin.setName(name);
		if (username != null)
			admin.setUsername(username);
		if (password != null)
			admin.setPassword(password);
		return adminRepository.createAdmin(admin);
	}

	public Admin updateAdmin(Integer id, String name, String username, String password) {
		Admin admin = getAdminById(id);
		if (name != null)
			admin.setName(name);
		if (username != null)
			admin.setUsername(username);
		if (password != null)
			admin.setPassword(password);
		return adminRepository.updateAdmin(admin);
	}

	public void deleteAdmin(Integer id) {
		Admin admin = getAdminById(id);
		adminRepository.deleteAdmin(admin);
	}
}
