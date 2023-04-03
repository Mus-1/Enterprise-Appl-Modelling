package com.taxcalculator.ms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.ms.entities.Review;
import com.taxcalculator.ms.repositories.ReviewRepository;

@Service
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;

	public Review getReviewById(int review_id) {
		return this.reviewRepository.findById(review_id).orElseThrow();
	}

	public List<Review> getAllReviews() {
		return this.reviewRepository.findAll();
	}

	public Review addReview(Review review) {
		return this.reviewRepository.save(review);
	}
}
