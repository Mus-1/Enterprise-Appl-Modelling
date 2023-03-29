package com.taxcalculator.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tax_bracket")
public class TaxBracket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String tax_bracket_id;
	private String territory;
	private double start_range;
	private Double end_range;
	private String year;
	private double tax_rate_percent;

	public TaxBracket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxBracket(String tax_bracket_id, String territory, double start_range, Double end_range, String year,
			double tax_rate_percent) {
		super();
		this.tax_bracket_id = tax_bracket_id;
		this.territory = territory;
		this.start_range = start_range;
		this.end_range = end_range;
		this.year = year;
		this.tax_rate_percent = tax_rate_percent;
	}

	public String getTax_bracket_id() {
		return tax_bracket_id;
	}

	public void setTax_bracket_id(String tax_bracket_id) {
		this.tax_bracket_id = tax_bracket_id;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public double getStart_range() {
		return start_range;
	}

	public void setStart_range(double start_range) {
		this.start_range = start_range;
	}

	public Double getEnd_range() {
		return end_range;
	}

	public void setEnd_range(Double end_range) {
		this.end_range = end_range;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getTax_rate_percent() {
		return tax_rate_percent;
	}

	public void setTax_rate_percent(double tax_rate_percent) {
		this.tax_rate_percent = tax_rate_percent;
	}

	@Override
	public String toString() {
		return "TaxBracket [tax_bracket_id=" + tax_bracket_id + ", territory=" + territory + ", start_range="
				+ start_range + ", end_range=" + end_range + ", year=" + year + ", tax_rate_percent=" + tax_rate_percent
				+ "]";
	}
}
