package com.taxcalculator.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxCalculation {
	static String name,pass,url; 
    private static Connection conn;
    
//this.conn = conn;
    public TaxCalculation() throws SQLException, ClassNotFoundException {
    	
    }

    public static double calculateProvincialTax(double totalIncome, String province) throws SQLException {
        double taxRate = 0.0;

        // Retrieve the tax rate for the given province and year from the database
        PreparedStatement stmt = conn.prepareStatement("SELECT tax_rate FROM tax_table WHERE territory = ? AND year = 2020");
        stmt.setString(1, province);
        ResultSet rs = stmt.executeQuery();

        // Extract the tax rate from the result set
        if (rs.next()) {
            taxRate = rs.getDouble("tax_rate");
        }

        // Calculate the provincial tax owed
        double provincialTax = totalIncome * taxRate;

        //return provincialTax;
        System.out.println("ProvincialTax: "+provincialTax);
        return 0;
    }

    public static double calculateFederalTax(double totalIncome, int year) throws SQLException, ClassNotFoundException {
        double taxRate = 0.0;
        Class.forName("com.mysql.jdbc.Driver");  
    	url="jdbc:mysql://localhost:3306/taxcalculator";  
        name="root";  
        pass="root";  
        conn = DriverManager.getConnection(url,name,pass);  
        System.out.println("Connection created");  

        // Retrieve the federal tax rate for the given year from the database
        PreparedStatement stmt = conn.prepareStatement("SELECT tax_rate_percent FROM tax_bracket WHERE territory = 'Federal' AND year = ?");
        stmt.setInt(1, year);
        ResultSet rs = stmt.executeQuery();

        // Extract the tax rate from the result set
        if (rs.next()) {
            taxRate = rs.getDouble("tax_rate_percent");
        }

        // Calculate the federal tax owed
        double federalTax = (totalIncome * taxRate)/100;
        System.out.println("FederalTax: "+federalTax);
        return 0;
        //return federalTax;
    }
}
