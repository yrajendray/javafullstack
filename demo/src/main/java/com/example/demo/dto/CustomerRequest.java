package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerRequest {

	 private String firstName;
	    private String lastName;
	    private String email;
	    private String password;
    
    private String panNumber;
    private String aadhaarNumber;
    private LocalDate dob;
    private String gender;
    private String address;
    private String city;
    private String state;
    private String pincode;
    private String riskProfile;
    private BigDecimal annualIncome;
	
    
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getRiskProfile() {
		return riskProfile;
	}
	public void setRiskProfile(String riskProfile) {
		this.riskProfile = riskProfile;
	}
	public BigDecimal getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(BigDecimal annualIncome) {
		this.annualIncome = annualIncome;
	}

    // Getters and Setters
    
    
}