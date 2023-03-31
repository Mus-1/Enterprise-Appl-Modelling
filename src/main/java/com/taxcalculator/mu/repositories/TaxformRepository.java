package com.taxcalculator.mu.repositories;

import org.springframework.stereotype.Repository;

import com.taxcalculator.mu.entities.Taxform;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TaxformRepository extends JpaRepository<Taxform, Integer> {

}
