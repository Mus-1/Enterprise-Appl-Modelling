package com.taxcalculator.mu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewsController {
	
	@GetMapping("/reviews")
	public String reviewsPage() {
		return "reviews";
	}
}
