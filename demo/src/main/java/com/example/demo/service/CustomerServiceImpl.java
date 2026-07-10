package com.example.demo.service;



import com.example.demo.Entity.Customer;
import com.example.demo.dto.CustomerRequest;
import com.example.demo.dto.CustomerResponse;
import com.example.demo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

    @Override
    public CustomerResponse addCustomer(CustomerRequest request) {

        Customer customer = new Customer();

        customer.setUserId(request.getUserId());
        customer.setPanNumber(request.getPanNumber());
        customer.setAadhaarNumber(request.getAadhaarNumber());
        customer.setDob(request.getDob());
        customer.setGender(request.getGender());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setState(request.getState());
        customer.setPincode(request.getPincode());
        customer.setRiskProfile(request.getRiskProfile());
        customer.setAnnualIncome(request.getAnnualIncome());

        customer = customerRepository.save(customer);

        return mapToResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponse getCustomer(Integer id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return mapToResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(Integer id, CustomerRequest request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setPanNumber(request.getPanNumber());
        customer.setAadhaarNumber(request.getAadhaarNumber());
        customer.setDob(request.getDob());
        customer.setGender(request.getGender());
        customer.setAddress(request.getAddress());
        customer.setCity(request.getCity());
        customer.setState(request.getState());
        customer.setPincode(request.getPincode());
        customer.setRiskProfile(request.getRiskProfile());
        customer.setAnnualIncome(request.getAnnualIncome());

        customer = customerRepository.save(customer);

        return mapToResponse(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {

        customerRepository.deleteById(id);
    }

    private CustomerResponse mapToResponse(Customer customer) {

        CustomerResponse response = new CustomerResponse();

        response.setCustomerId(customer.getCustomerId());
        response.setUserId(customer.getUserId());
        response.setPanNumber(customer.getPanNumber());
        response.setAadhaarNumber(customer.getAadhaarNumber());
        response.setDob(customer.getDob());
        response.setGender(customer.getGender());
        response.setAddress(customer.getAddress());
        response.setCity(customer.getCity());
        response.setState(customer.getState());
        response.setPincode(customer.getPincode());
        response.setRiskProfile(customer.getRiskProfile());
        response.setAnnualIncome(customer.getAnnualIncome());

        return response;
    }
}