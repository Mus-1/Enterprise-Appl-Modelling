package com.taxcalculator.sc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxcalculator.sc.entities.TaxBracket;
import com.taxcalculator.sc.repositories.TaxBracketRepository;

@Service
public class TaxBracketDao {

	@Autowired
	private TaxBracketRepository taxBracketRepository;

	public List<TaxBracket> getProvincialTaxBracketByIncome(double totalIncome, String province, String year) {
		return this.taxBracketRepository.getProvincialTaxBracketByTotalIncome(totalIncome, province, year);
	}

	public List<TaxBracket> getFederalTaxBracketByIncome(double totalIncome, String year) {
		return this.taxBracketRepository.getFederalTaxeBracketByTotalIncome(totalIncome, year);
	}

	public TaxBracket createTaxBracket(TaxBracket taxBracket) {
		return this.taxBracketRepository.save(taxBracket);
	}

	public TaxBracket updateTaxBracket(TaxBracket taxBracket, int taxBracketId) {
		this.taxBracketRepository.findById(taxBracketId).orElseThrow(() -> new RuntimeException("No records found!"));
		return this.taxBracketRepository.save(taxBracket);
	}
}
