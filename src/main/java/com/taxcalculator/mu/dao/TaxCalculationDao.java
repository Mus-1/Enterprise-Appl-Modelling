package com.taxcalculator.mu.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.mu.entities.TaxCalculation;
import com.taxcalculator.mu.repositories.TaxCalculationRepository;

@Service
public class TaxCalculationDao {

	@Autowired
	private TaxCalculationRepository taxCalculationRepository;
	
	// get by form id
	public TaxCalculation getTaxCalculationByFormId(int form_id) {
		return this.taxCalculationRepository.findByFormId(form_id);
	}
	
	// create
	public TaxCalculation addTaxCalculation(TaxCalculation taxCalculation) {
		return this.taxCalculationRepository.save(taxCalculation);
	}	
}