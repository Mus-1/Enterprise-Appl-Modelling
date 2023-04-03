package com.taxcalculator.ms.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.taxcalculator.ms.dao.ReviewDao;
import com.taxcalculator.ms.entities.Review;
import com.taxcalculator.sc.dao.TaxpayerDao;
import com.taxcalculator.sc.entities.Taxpayer;

@Controller
public class ReviewController {
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private TaxpayerDao taxpayerDao;
	
	@GetMapping("/reviews")
	public String getReviewsPage(Model model) {
	    List<Review> reviews = this.reviewDao.getAllReviews();
	    Map<Review, Taxpayer> reviewTaxpayerMap = new HashMap<>();

	    for (Review review : reviews) {
	        Taxpayer taxpayer = this.taxpayerDao.findById(review.getTaxpayer_id());
	        reviewTaxpayerMap.put(review, taxpayer);
	    }
	    model.addAttribute("reviewTaxpayerMap", reviewTaxpayerMap);
	    return "reviews";
	}
	
	@PostMapping("/reviews")
	public RedirectView addReview(@ModelAttribute Review review) {
		this.reviewDao.addReview(review);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("reviews");
		return redirectView;
	}
}
