package com.confiz.confizcafe.controller;

import com.confiz.confizcafe.model.Lunch;
import com.confiz.confizcafe.service.LunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LunchController {

	@Autowired
	private LunchService lunchService;

	@GetMapping(value = "/getAllLunches")
	public List<Lunch> getAllLunches() {
		return lunchService.getAllLunches();
	}

	@GetMapping(value = "/getLunchById/{id}")
	public Lunch getLunchById(@PathVariable("id") String id) {
		return lunchService.getLunchById(id);
	}

	@GetMapping(value = "/getLunchByDate/{date}")
	public Lunch getLunchByDate(@PathVariable("date") String date) {
		return lunchService.getLunchByDate(date);
	}

	@GetMapping(value = "/getLunchForToday")
	public Lunch getLunchForToday() {
		return lunchService.getLunchForToday();
	}

	@PutMapping(value = "/addReview")
	public Lunch addReview(@RequestParam(value = "review") String review) {
		return lunchService.addReview(review);
	}

	@PostMapping(value = "/createLunch")
	public Lunch createLunch(@RequestParam(value = "date", required = false) String date,
			@RequestParam(value = "menu", required = false) String menu,
			@RequestParam(value = "reviews", required = false) List<String> reviews) {
		return lunchService.createLunch(date, menu, reviews);
	}

	@PutMapping(value = "/updateLunch")
	public Lunch updateLunch(@RequestParam(value = "date") String date,
			@RequestParam(value = "menu", required = false) String menu,
			@RequestParam(value = "reviews", required = false) List<String> reviews) {
		return lunchService.updateLunch(date, menu, reviews);
	}

	@DeleteMapping(value = "/deleteLunch/{id}")
	public void deleteLunch(@PathVariable("id") String id) {
		lunchService.deleteLunch(id);
	}
}
