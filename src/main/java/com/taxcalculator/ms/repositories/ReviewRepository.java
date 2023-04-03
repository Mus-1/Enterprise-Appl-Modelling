package com.taxcalculator.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taxcalculator.ms.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
