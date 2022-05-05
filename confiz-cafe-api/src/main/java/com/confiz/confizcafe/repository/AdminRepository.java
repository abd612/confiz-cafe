package com.confiz.confizcafe.repository;

import com.confiz.confizcafe.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

	private static final String COLLECTION = "admin";

	@Autowired
	private MongoTemplate mongoTemplate;

	public String verifyAdmin(Admin admin) {
		Query query = new Query(
				Criteria.where("username").is(admin.getUsername()).and("password").is(admin.getPassword()));
		if (mongoTemplate.findOne(query, Admin.class, COLLECTION) != null) {
			return "success";
		} else
			return "failure";
	}

	public List<Admin> getAllAdmins() {
		return mongoTemplate.findAll(Admin.class, COLLECTION);
	}

	public Admin getAdminById(Integer id) {
		return mongoTemplate.findById(id, Admin.class, COLLECTION);
	}

	public Admin createAdmin(Admin admin) {
		return mongoTemplate.save(admin, COLLECTION);
	}

	public Admin updateAdmin(Admin admin) {
		return mongoTemplate.save(admin, COLLECTION);
	}

	public void deleteAdmin(Admin admin) {
		mongoTemplate.remove(admin, COLLECTION);
	}
}
