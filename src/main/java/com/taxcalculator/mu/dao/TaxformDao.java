package com.taxcalculator.mu.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxcalculator.mu.entities.Taxform;
import com.taxcalculator.mu.repositories.TaxformRepository;

@Service
public class TaxformDao {
	@Autowired
	private TaxformRepository taxformRepository;

	public Taxform findById(Integer id) {
		return this.taxformRepository.findById(id).orElseThrow(() -> new RuntimeException("Form not found!"));
	}
	
	public List<Taxform> getTaxFormByTaxpayerId(int taxpayer_id){
		return this.taxformRepository.getByTaxpayerId(taxpayer_id);
	}

	public Taxform saveTaxform(Taxform taxform) {
		return this.taxformRepository.save(taxform);
	}

	public Taxform updateTaxform(Taxform taxform, Integer id) {
		this.taxformRepository.findById(id).orElseThrow(() -> new RuntimeException("Form not found!"));
		return this.taxformRepository.save(taxform);
	}
}