package com.taxcalculator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taxcalculator.entities.TaxCalculation;

@Repository
public interface TaxCalculationRepository extends JpaRepository<TaxCalculation, Integer>{
	@Query("SELECT tc from TaxCalculation tc WHERE tc.form_id=:form_id")
	TaxCalculation findByFormId(@Param("form_id") int form_id);
}
