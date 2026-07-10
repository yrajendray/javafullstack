package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;

public interface CustomerService{

    CustomerResponse addCustomer(CustomerRequest request);

    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomer(Integer id);

    CustomerResponse updateCustomer(Integer id,
                                    CustomerRequest request);

    void deleteCustomer(Integer id);

}