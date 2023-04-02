package com.taxcalculator.sc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.taxcalculator.mu.dao.TaxCalculationDao;
import com.taxcalculator.mu.dao.TaxformDao;
import com.taxcalculator.mu.entities.TaxCalculation;
import com.taxcalculator.mu.entities.Taxform;
import com.taxcalculator.sc.dao.TaxpayerDao;
import com.taxcalculator.sc.entities.Taxpayer;

@Controller
public class TaxpayerController {
	@Autowired
	private TaxpayerDao taxpayerDao;

	@Autowired
	private TaxformDao taxFormDao;
	
	@Autowired
	private TaxCalculationDao taxCalculationDao;
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/profile")
	public String profilePage(HttpServletRequest request, Model model) {
		Taxpayer taxpayer = (Taxpayer) request.getSession().getAttribute("taxpayer");
		if (taxpayer == null) {
			return "login";
		} else {
			List<Taxform> forms=this.taxFormDao.getTaxFormByTaxpayerId(taxpayer.getTaxpayer_id());
			List<Map<String, Object>> formCalculations = new ArrayList<>();
			for (Taxform form : forms) {
			    TaxCalculation calculation = this.taxCalculationDao.getTaxCalculationByFormId(form.getForm_id());
			    
			    Map<String, Object> formCalculation = new HashMap<>();
			    formCalculation.put("form", form);
			    formCalculation.put("calculation", calculation);
			    formCalculations.add(formCalculation);
			}
			
			model.addAttribute("formCalculations",formCalculations);
			return "profile";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().removeAttribute("taxpayer");
		return "login";
	}

	@PostMapping("/login")
	public RedirectView loginTaxpayer(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpServletRequest request, Model model) {
		Taxpayer taxpayer = this.taxpayerDao.findByEmailAndPassword(email, password);
		RedirectView redirectView = new RedirectView();
		if (taxpayer != null) {
			request.getSession().setAttribute("taxpayer", taxpayer);
			redirectView.setUrl(request.getContextPath() + "/");
		} else {
			redirectView.setUrl(request.getContextPath() + "/login");
		}
		return redirectView;
	}

	@PostMapping("/register")
	public RedirectView registerTaxpayer(@ModelAttribute("taxpayer") Taxpayer taxpayer, BindingResult result,
			HttpServletRequest request) {

		this.taxpayerDao.saveTaxpayer(taxpayer);
		// Save taxpayer object to database
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/login");
		return redirectView;
	}

}
