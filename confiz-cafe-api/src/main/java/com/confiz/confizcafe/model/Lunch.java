package com.confiz.confizcafe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Lunch {

	@Id
	private String id;
	private Date date;
	private String menu;
	private List<String> reviews;

	public Lunch() {
	}

	public Lunch(String id, Date date, String menu, List<String> reviews) {
		this.id = id;
		this.date = date;
		this.menu = menu;
		this.reviews = reviews;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
}
