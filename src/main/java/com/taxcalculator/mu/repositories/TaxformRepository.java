package com.taxcalculator.mu.repositories;

import org.springframework.stereotype.Repository;
import com.taxcalculator.mu.entities.Taxform;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TaxformRepository extends JpaRepository<Taxform, Integer> {
	@Query("SELECT t FROM Taxform t WHERE t.taxpayer_id = :taxpayer_id")
	List<Taxform> getByTaxpayerId(@Param("taxpayer_id") int taxpayer_id);
}