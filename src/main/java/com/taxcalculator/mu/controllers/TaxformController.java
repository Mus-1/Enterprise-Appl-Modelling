package com.taxcalculator.mu.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.taxcalculator.mu.dao.TaxCalculationDao;
import com.taxcalculator.mu.dao.TaxformDao;
import com.taxcalculator.mu.entities.TaxCalculation;
import com.taxcalculator.mu.entities.Taxform;
import com.taxcalculator.sc.dao.TaxBracketDao;
import com.taxcalculator.sc.entities.TaxBracket;
import com.taxcalculator.sc.entities.Taxpayer;
import com.taxcalculator.sc.helper.Helper;

@Controller
public class TaxformController {

	private static final double BASIC_PERSONAL_AMOUNT = 14398;

	@Autowired
	private TaxformDao taxformDao;

	@Autowired
	private TaxBracketDao taxBracketDao;

	@Autowired
	private TaxCalculationDao taxCalculationDao;

	@GetMapping("/taxform")
	public String taxform(HttpServletRequest request, Model model) {
		Taxpayer taxpayer = (Taxpayer) request.getSession().getAttribute("taxpayer");
		if (taxpayer == null) {
			return "login";
		} else {
			return "taxform";
		}
	}

	@GetMapping("/form/{formId}")
	public String formDetailsPage(@PathVariable("formId") int formId, Model model) {
		Taxform taxform = this.taxformDao.findById(formId);
		TaxCalculation taxCalculation = this.taxCalculationDao.getTaxCalculationByFormId(formId);
		model.addAttribute("taxform", taxform);
		model.addAttribute("taxCalculation", taxCalculation);
		return "form-details";
	}

	@GetMapping("/form/result/{formId}")
	public String getFormResult(@PathVariable int formId, Model model) {
		TaxCalculation taxCalculation = this.taxCalculationDao.getTaxCalculationByFormId(formId);
		model.addAttribute("taxCalculation", taxCalculation);
		return "result";
	}

	@PostMapping("/taxform")
	public RedirectView registerTaxform(@ModelAttribute("taxform") Taxform taxform, HttpServletRequest request,
			Model model) {

		double total_income = taxform.getEmployment_income() + taxform.getOther_income()
				+ taxform.getCapital_gains_losses() - taxform.getTotal_rrsp() - taxform.getCpp() - taxform.getEi()
				- BASIC_PERSONAL_AMOUNT;

		List<TaxBracket> provincialBrackets = this.taxBracketDao.getProvincialTaxBracketByIncome(total_income,
				taxform.getProvince(), Integer.toString(taxform.getYear()));
		List<TaxBracket> federalBrackets = this.taxBracketDao.getFederalTaxBracketByIncome(total_income,
				Integer.toString(taxform.getYear()));

		// Calculating federal and provincial tax
		double provincial_tax = Helper.calculateTax(total_income, provincialBrackets);
		double federal_tax = Helper.calculateTax(total_income, federalBrackets);
		double total_tax = provincial_tax + federal_tax - taxform.getIncome_taxes_paid();

		// Save taxpayer object to database
		this.taxformDao.saveTaxform(taxform);

		TaxCalculation taxCalculation = new TaxCalculation();
		taxCalculation.setForm_id(taxform.getForm_id());
		taxCalculation.setFederal_tax(federal_tax);
		taxCalculation.setProvincial_tax(provincial_tax);
		taxCalculation.setTotal_tax(total_tax);

		// Saving taxcalculation in db
		this.taxCalculationDao.addTaxCalculation(taxCalculation);

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/form/result/" + taxform.getForm_id());
		return redirectView;
	}
}
