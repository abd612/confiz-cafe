package com.confiz.confizcafe.repository;

import com.confiz.confizcafe.model.Lunch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class LunchRepository {

	private static final String COLLECTION = "lunch";

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Lunch> getAllLunches() {
		return mongoTemplate.findAll(Lunch.class, COLLECTION);
	}

	public Lunch getLunchById(String id) {
		return mongoTemplate.findById(id, Lunch.class, COLLECTION);
	}

	public Lunch getLunchByDate(Date date) {
		Query query = new Query(Criteria.where("date").is(date));
		return mongoTemplate.findOne(query, Lunch.class, COLLECTION);
	}

	public Lunch createLunch(Lunch lunch) {
		return mongoTemplate.save(lunch, COLLECTION);
	}

	public Lunch updateLunch(Lunch lunch) {
		return mongoTemplate.save(lunch, COLLECTION);
	}

	public void deleteLunch(Lunch lunch) {
		mongoTemplate.remove(lunch, COLLECTION);
	}
}
