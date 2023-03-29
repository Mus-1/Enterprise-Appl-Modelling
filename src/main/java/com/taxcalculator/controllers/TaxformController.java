package com.taxcalculator.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import com.taxcalculator.dao.TaxBracketDao;
import com.taxcalculator.dao.TaxCalculationDao;
import com.taxcalculator.dao.TaxformDao;
import com.taxcalculator.entities.TaxBracket;
import com.taxcalculator.entities.TaxCalculation;
import com.taxcalculator.entities.Taxform;
import com.taxcalculator.entities.Taxpayer;
import com.taxcalculator.sc.helper.Helper;

@Controller
public class TaxformController {
	@Autowired
	private TaxformDao taxformDao;

	@Autowired
	private TaxBracketDao taxBracketDao;
	
	@Autowired
	private TaxCalculationDao taxCalculationDao;

	@GetMapping("/taxform")
	public String taxform(HttpServletRequest request) {
		Taxpayer taxpayer = (Taxpayer) request.getSession().getAttribute("taxpayer");
		if (taxpayer == null) {
			return "login";
		} else {
			return "taxform";
		}
	}

	@PostMapping("/taxform")
	public RedirectView registerTaxform(@ModelAttribute("taxform") Taxform taxform,
			HttpServletRequest request) {
		
		double total_income=taxform.getEmployment_income()+taxform.getOther_income()+taxform.getCapital_gains_losses()-taxform.getIncome_taxes_paid()-taxform.getTotal_rrsp();
		System.out.println(total_income);
		
		List<TaxBracket> provincialBrackets=this.taxBracketDao.getProvincialTaxBracketByIncome(total_income, taxform.getProvince(),Integer.toString(taxform.getYear()));
		List<TaxBracket> federalBrackets=this.taxBracketDao.getFederalTaxBracketByIncome(total_income,Integer.toString(taxform.getYear()));
		
		// Calculating federal and provincial tax
		double provincial_tax=Helper.calculateTax(total_income, provincialBrackets);
		double federal_tax=Helper.calculateTax(total_income, federalBrackets);
		double total_tax=provincial_tax+federal_tax;
		
		// Save taxpayer object to database
		this.taxformDao.saveTaxform(taxform);

		TaxCalculation taxCalculation=new TaxCalculation();
		taxCalculation.setForm_id(taxform.getForm_id());
		taxCalculation.setFederal_tax(federal_tax);
		taxCalculation.setProvincial_tax(provincial_tax);
		taxCalculation.setTotal_tax(total_tax);
		
		// Saving taxcalculation in db
		this.taxCalculationDao.addTaxCalculation(taxCalculation);

		RedirectView redirectView = new RedirectView();	
		redirectView.setUrl(request.getContextPath() + "/taxform");
		return redirectView;
	}

}
