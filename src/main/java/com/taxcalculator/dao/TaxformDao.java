package com.taxcalculator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.entities.Taxform;
import com.taxcalculator.repositories.TaxformRepository;

@Service
public class TaxformDao {
	@Autowired
	private TaxformRepository taxformRepository;
	
	public Taxform findById(Integer id) {
		return this.taxformRepository.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
	}
	
	public Taxform saveTaxform(Taxform taxform) {
		return this.taxformRepository.save(taxform);
	}
	
	public Taxform updateTaxform(Taxform taxform, Integer id) {
		this.taxformRepository.findById(id).orElseThrow(()->new RuntimeException("User not found!"));
		return this.taxformRepository.save(taxform);
	}
	
	
}