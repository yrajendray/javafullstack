package com.example.demo.service;

import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Portfolio;
import com.example.demo.dto.PortfolioRequest;
import com.example.demo.dto.PortfolioResponse;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PortfolioRepository;
import com.example.demo.service.PortfolioService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired 
	PortfolioRepository portfolioRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public PortfolioResponse save(PortfolioRequest request) {

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Portfolio portfolio = new Portfolio();

        portfolio.setCustomer(customer);
        portfolio.setPortfolioName(request.getPortfolioName());
        portfolio.setInvestedAmount(request.getInvestedAmount());
        portfolio.setCurrentValue(request.getCurrentValue());
        portfolio.setProfitLoss(request.getProfitLoss());
        portfolio.setRiskLevel(request.getRiskLevel());
        portfolio.setCreatedDate(request.getCreatedDate());

        Portfolio saved = portfolioRepository.save(portfolio);

        return convertToResponse(saved);
    }

    @Override
    public List<PortfolioResponse> findAll() {

        return portfolioRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PortfolioResponse findById(Integer id) {

        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        return convertToResponse(portfolio);
    }

    @Override
    public PortfolioResponse update(Integer id, PortfolioRequest request) {

        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        portfolio.setCustomer(customer);
        portfolio.setPortfolioName(request.getPortfolioName());
        portfolio.setInvestedAmount(request.getInvestedAmount());
        portfolio.setCurrentValue(request.getCurrentValue());
        portfolio.setProfitLoss(request.getProfitLoss());
        portfolio.setRiskLevel(request.getRiskLevel());
        portfolio.setCreatedDate(request.getCreatedDate());

        Portfolio updated = portfolioRepository.save(portfolio);

        return convertToResponse(updated);
    }

    @Override
    public void delete(Integer id) {

        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        portfolioRepository.delete(portfolio);
    }

    private PortfolioResponse convertToResponse(Portfolio portfolio) {

        PortfolioResponse response = new PortfolioResponse();

        response.setPortfolioId(portfolio.getPortfolioId());
        response.setCustomerId(portfolio.getCustomer().getCustomerId());
        response.setPortfolioName(portfolio.getPortfolioName());
        response.setInvestedAmount(portfolio.getInvestedAmount());
        response.setCurrentValue(portfolio.getCurrentValue());
        response.setProfitLoss(portfolio.getProfitLoss());
        response.setRiskLevel(portfolio.getRiskLevel());
        response.setCreatedDate(portfolio.getCreatedDate());

        return response;
    }
}