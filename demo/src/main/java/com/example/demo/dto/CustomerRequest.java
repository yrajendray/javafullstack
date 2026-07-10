package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerRequest {

    private Integer userId;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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