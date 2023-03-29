package com.taxcalculator.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tax_form")
public class Taxform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int form_id;
	private int taxpayer_id;
	private int year;
	private String address;
	private String city;
	private String province;
	private String postalcode;
	private String martial_status;
	private double employment_income;
	private double other_income;
	private double capital_gains_losses;
	private double income_taxes_paid;
	private double total_rrsp;
	
	@CreationTimestamp
	@Column(name = "tax_filing_date", nullable = false, updatable = false)
	private Date tax_filing_date;
	public Taxform() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxform(int form_id, int taxpayer_id, int year, String address, String city, String province,
			String postalcode, String martial_status, float employment_income, float other_income,
			float capital_gains_losses, float income_taxes_paid, float total_rrsp, Date tax_filing_date) {
		super();
		this.form_id = form_id;
		this.taxpayer_id = taxpayer_id;
		this.year = year;
		this.address = address;
		this.city = city;
		this.province = province;
		this.postalcode = postalcode;
		this.martial_status = martial_status;
		this.employment_income = employment_income;
		this.other_income = other_income;
		this.capital_gains_losses = capital_gains_losses;
		this.income_taxes_paid = income_taxes_paid;
		this.total_rrsp = total_rrsp;
		this.tax_filing_date = tax_filing_date;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public int getTaxpayer_id() {
		return taxpayer_id;
	}
	public void setTaxpayer_id(int taxpayer_id) {
		this.taxpayer_id = taxpayer_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getMartial_status() {
		return martial_status;
	}
	public void setMartial_status(String martial_status) {
		this.martial_status = martial_status;
	}
	public double getEmployment_income() {
		return employment_income;
	}
	public void setEmployment_income(float employment_income) {
		this.employment_income = employment_income;
	}
	public double getOther_income() {
		return other_income;
	}
	public void setOther_income(float other_income) {
		this.other_income = other_income;
	}
	public double getCapital_gains_losses() {
		return capital_gains_losses;
	}
	public void setCapital_gains_losses(float capital_gains_losses) {
		this.capital_gains_losses = capital_gains_losses;
	}
	public double getIncome_taxes_paid() {
		return income_taxes_paid;
	}
	public void setIncome_taxes_paid(float income_taxes_paid) {
		this.income_taxes_paid = income_taxes_paid;
	}
	public double getTotal_rrsp() {
		return total_rrsp;
	}
	public void setTotal_rrsp(float total_rrsp) {
		this.total_rrsp = total_rrsp;
	}
	public Date getTax_filing_date() {
		return tax_filing_date;
	}
	public void setTax_filing_date(Date tax_filing_date) {
		this.tax_filing_date = tax_filing_date;
	}
}
