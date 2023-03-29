package com.taxcalculator.sc.helper;

import java.util.List;
import com.taxcalculator.entities.TaxBracket;

public class Helper {
	public static double calculateTax(double total_income, List<TaxBracket> taxBrackets) {
		double tax = 0;
		double remaining_income = total_income;
		double taxable_income;
		double tax_rate;

		for (TaxBracket bracket : taxBrackets) {
			if (remaining_income <= 0) {
				break;
			}
			taxable_income = Math.min(remaining_income, bracket.getEnd_range() - bracket.getStart_range());
			tax_rate = bracket.getTax_rate_percent() / 100.0;
			tax += taxable_income * tax_rate;
			remaining_income -= taxable_income;

		}
		return tax;
	}
}
