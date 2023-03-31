package com.taxcalculator.mu.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tax_calculation")
public class TaxCalculation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tax_calculation_id;
	private int form_id;
	private double federal_tax;
	private double provincial_tax;
	private double total_tax;

	public TaxCalculation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxCalculation(int tax_calculation_id, int form_id, double federal_tax,
			double provincial_tax, double total_tax) {
		super();
		this.tax_calculation_id = tax_calculation_id;
		this.form_id = form_id;
		this.federal_tax = federal_tax;
		this.provincial_tax = provincial_tax;
		this.total_tax = total_tax;
	}

	public int getTax_calculation_id() {
		return tax_calculation_id;
	}

	public void setTax_calculation_id(int tax_calculation_id) {
		this.tax_calculation_id = tax_calculation_id;
	}

	public int getForm_id() {
		return form_id;
	}

	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}

	public double getFederal_tax() {
		return federal_tax;
	}

	public void setFederal_tax(double federal_tax) {
		this.federal_tax = federal_tax;
	}

	public double getProvincial_tax() {
		return provincial_tax;
	}

	public void setProvincial_tax(double provincial_tax) {
		this.provincial_tax = provincial_tax;
	}

	public double getTotal_tax() {
		return total_tax;
	}

	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}

}
