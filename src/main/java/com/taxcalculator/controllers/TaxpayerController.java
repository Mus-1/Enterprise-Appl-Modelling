package com.taxcalculator.controllers;

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
import com.taxcalculator.dao.TaxpayerDao;
import com.taxcalculator.entities.Taxpayer;

@Controller
public class TaxpayerController {
	@Autowired
	private TaxpayerDao taxpayerDao;
	
	
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
	public String profilePage(HttpServletRequest request) {
		Taxpayer taxpayer = (Taxpayer) request.getSession().getAttribute("taxpayer");
		if(taxpayer==null) {
			return "login";
		}else {			
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
			redirectView.setUrl(request.getContextPath() + "/profile");
		} else {
			redirectView.setUrl(request.getContextPath() + "/login");
		}
		return redirectView;
	}
	
	@PostMapping("/register")
	public RedirectView registerTaxpayer(@ModelAttribute("taxpayer") Taxpayer taxpayer, BindingResult result, HttpServletRequest request) {
	    
		this.taxpayerDao.saveTaxpayer(taxpayer);
	    // Save taxpayer object to database
	    RedirectView redirectView = new RedirectView();
	    redirectView.setUrl(request.getContextPath() + "/login");
	    return redirectView;
	}

}
