package com.example.demo.dto;

import java.math.BigDecimal;


public class CustomerResponse {

    private Integer customerId;

    private Integer userId;

    private String firstName;

    private String lastName;

    private String email;

    private String aadhaarNumber;

    private String panNumber;

    private String gender;

    private String dob;

    private String address;

    private String city;

    private String state;

    private String pincode;

    private BigDecimal annualIncome;

    private String riskProfile;

    public CustomerResponse() {
    }

    public CustomerResponse(Integer customerId,
                            Integer userId,
                            String firstName,
                            String lastName,
                            String email,
                            String aadhaarNumber,
                            String panNumber,
                            String gender,
                            String dob,
                            String address,
                            String city,
                            String state,
                            String pincode,
                            BigDecimal annualIncome,
                            String riskProfile) {

        this.customerId = customerId;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.aadhaarNumber = aadhaarNumber;
        this.panNumber = panNumber;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.annualIncome = annualIncome;
        this.riskProfile = riskProfile;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

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

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public void setRiskProfile(String riskProfile) {
        this.riskProfile = riskProfile;
    }

}