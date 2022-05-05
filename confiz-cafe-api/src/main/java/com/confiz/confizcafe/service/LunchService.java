package com.confiz.confizcafe.service;

import com.confiz.confizcafe.model.Lunch;
import com.confiz.confizcafe.repository.LunchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LunchService {

	@Autowired
	private LunchRepository lunchRepository;

	public List<Lunch> getAllLunches() {
		return lunchRepository.getAllLunches();
	}

	public Lunch getLunchById(String id) {
		return lunchRepository.getLunchById(id);
	}

	public Lunch getLunchByDate(String dateString) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lunchRepository.getLunchByDate(date);
	}

	public Lunch getLunchForToday() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return lunchRepository.getLunchByDate(date);
	}

	public Lunch createLunch(String dateString, String menu, List<String> reviews) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			if (dateString != null)
				date = formatter.parse(dateString);
			else
				date = formatter.parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Lunch lunch = new Lunch();
		if (date != null)
			lunch.setDate(date);
		if (menu != null)
			lunch.setMenu(menu);
		if (reviews != null)
			lunch.setReviews(reviews);
		else
			lunch.setReviews(new ArrayList<>());
		return lunchRepository.createLunch(lunch);
	}

	public Lunch updateLunch(String dateString, String menu, List<String> reviews) {
		Lunch lunch = getLunchByDate(dateString);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null)
			lunch.setDate(date);
		if (menu != null)
			lunch.setMenu(menu);
		if (reviews != null)
			lunch.setReviews(reviews);
		return lunchRepository.updateLunch(lunch);
	}

	public Lunch addReview(String review) {
		Lunch lunch = getLunchForToday();
		List<String> reviews = lunch.getReviews();
		reviews.add(review);
		lunch.setReviews(reviews);
		return lunchRepository.updateLunch(lunch);
	}

	public void deleteLunch(String id) {
		Lunch lunch = getLunchById(id);
		lunchRepository.deleteLunch(lunch);
	}
}
