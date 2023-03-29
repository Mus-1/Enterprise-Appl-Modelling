package com.taxcalculator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.entities.Taxpayer;
import com.taxcalculator.repositories.TaxpayerRepository;

@Service
public class TaxpayerDao {
	@Autowired
	private TaxpayerRepository taxpayerRepository;
	
	public Taxpayer findById(Integer id) {
		return this.taxpayerRepository.findById(id).orElseThrow(()->new RuntimeException("Taxpayer not found!"));
	}

	public Taxpayer findByEmailAndPassword(String email, String password) {
		return this.taxpayerRepository.findByEmailAndPassword(email, password);
	}
	
	public Taxpayer saveTaxpayer(Taxpayer taxpayer) {
		return this.taxpayerRepository.save(taxpayer);
	}
	
	public Taxpayer updateTaxpayer(Taxpayer taxpayer, Integer id) {
		this.taxpayerRepository.findById(id).orElseThrow(()->new RuntimeException("Taxpayer not found!"));
		return this.taxpayerRepository.save(taxpayer);
	}
	
	
}