package com.taxcalculator.ms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int review_id;
	private int taxpayer_id;
	private String title;
	private String description;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int review_id, int taxpayer_id, String title, String description) {
		super();
		this.review_id = review_id;
		this.taxpayer_id = taxpayer_id;
		this.title = title;
		this.description = description;
	}

	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public int getTaxpayer_id() {
		return taxpayer_id;
	}

	public void setTaxpayer_id(int taxpayer_id) {
		this.taxpayer_id = taxpayer_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
