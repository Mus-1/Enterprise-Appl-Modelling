package com.taxcalculator.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "taxpayers")
public class Taxpayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taxpayer_id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String phone;

	public Taxpayer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Taxpayer(int taxpayer_id, String fname, String lname, String email, String password, String gender, Date dob,
			String phone) {
		super();
		this.taxpayer_id = taxpayer_id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.phone = phone;
	}

	public int getTaxpayer_id() {
		return taxpayer_id;
	}

	public void setTaxpayer_id(int taxpayer_id) {
		this.taxpayer_id = taxpayer_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
