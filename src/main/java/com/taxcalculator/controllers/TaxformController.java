package com.taxcalculator.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.taxcalculator.dao.TaxformDao;
import com.taxcalculator.dao.TaxpayerDao;
import com.taxcalculator.entities.Taxform;
import com.taxcalculator.entities.Taxpayer;
import com.taxcalculator.helper.TaxCalculation;

@Controller
public class TaxformController {
	@Autowired
	private TaxformDao taxformDao;
	@GetMapping("/taxform")
	public String taxform(HttpServletRequest request) {
		Taxpayer taxpayer = (Taxpayer) request.getSession().getAttribute("taxpayer");
		if(taxpayer==null) {
			return "login";
		}else {			
			return "taxform";
		}
	}
	@PostMapping("/taxform")
	public RedirectView registerTaxform(@ModelAttribute("taxform") Taxform taxform, BindingResult result,
			HttpServletRequest request) throws SQLException, ClassNotFoundException {
		Taxform taxformObj = (Taxform) request.getSession().getAttribute("Taxform");
		System.out.println("Income: "+taxform.getEmployment_income()+"  Year: "+taxform.getYear());
		TaxCalculation.calculateFederalTax(taxform.getEmployment_income(),taxform.getYear());
		//TaxCalculation.calculateFederalTax(taxformObj.getEmployment_income(),taxformObj.getYear());
		//TaxCalculation.calculateProvincialTax(taxformObj.getEmployment_income(),taxformObj.getProvince());
		this.taxformDao.saveTaxform(taxform);
		// Save taxpayer object to database
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/taxform");
		return redirectView;
	}
	
}
