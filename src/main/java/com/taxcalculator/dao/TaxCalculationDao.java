package com.taxcalculator.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.entities.TaxCalculation;
import com.taxcalculator.repositories.TaxCalculationRepository;

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