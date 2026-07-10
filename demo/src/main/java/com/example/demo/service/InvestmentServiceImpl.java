package com.example.demo.service;


import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.*;
import com.example.demo.Entity.Portfolio;
import com.example.demo.dto.InvestmentRequest;
import com.example.demo.dto.InvestmentResponse;
import com.example.demo.repository.InvestmentRepository;
import com.example.demo.repository.InvestmentTypeRepository;
import com.example.demo.repository.PortfolioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestmentServiceImpl implements InvestmentService {

	@Autowired
    InvestmentRepository investmentRepository;
	@Autowired
    PortfolioRepository portfolioRepository;
	@Autowired
    InvestmentTypeRepository investmentTypeRepository;

    @Override
    public InvestmentResponse save(InvestmentRequest request) {

        Portfolio portfolio = portfolioRepository.findById(request.getPortfolioId())
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        InvestmentType investmentType = investmentTypeRepository.findById(request.getInvestmentTypeId())
                .orElseThrow(() -> new RuntimeException("Investment Type not found"));

        Investment investment = new Investment();

        investment.setPortfolio(portfolio);
        investment.setInvestmentType(investmentType);
        investment.setInvestmentName(request.getInvestmentName());
        investment.setSymbol(request.getSymbol());
        investment.setQuantity(request.getQuantity());
        investment.setPurchasePrice(request.getPurchasePrice());
        investment.setCurrentPrice(request.getCurrentPrice());
        investment.setInvestedAmount(request.getInvestedAmount());
        investment.setCurrentValue(request.getCurrentValue());
        investment.setProfitLoss(request.getProfitLoss());
        investment.setInvestmentDate(request.getInvestmentDate());
        investment.setMaturityDate(request.getMaturityDate());
        investment.setStatus(request.getStatus());

        Investment savedInvestment = investmentRepository.save(investment);

        return convertToResponse(savedInvestment);
    }

    @Override
    public List<InvestmentResponse> getAll() {

        return investmentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public InvestmentResponse getById(Integer id) {

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        return convertToResponse(investment);
    }

    @Override
    public InvestmentResponse update(Integer id, InvestmentRequest request) {

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        Portfolio portfolio = portfolioRepository.findById(request.getPortfolioId())
                .orElseThrow(() -> new RuntimeException("Portfolio not found"));

        InvestmentType investmentType = investmentTypeRepository.findById(request.getInvestmentTypeId())
                .orElseThrow(() -> new RuntimeException("Investment Type not found"));

        investment.setPortfolio(portfolio);
        investment.setInvestmentType(investmentType);
        investment.setInvestmentName(request.getInvestmentName());
        investment.setSymbol(request.getSymbol());
        investment.setQuantity(request.getQuantity());
        investment.setPurchasePrice(request.getPurchasePrice());
        investment.setCurrentPrice(request.getCurrentPrice());
        investment.setInvestedAmount(request.getInvestedAmount());
        investment.setCurrentValue(request.getCurrentValue());
        investment.setProfitLoss(request.getProfitLoss());
        investment.setInvestmentDate(request.getInvestmentDate());
        investment.setMaturityDate(request.getMaturityDate());
        investment.setStatus(request.getStatus());

        Investment updatedInvestment = investmentRepository.save(investment);

        return convertToResponse(updatedInvestment);
    }

    @Override
    public void delete(Integer id) {

        Investment investment = investmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investment not found"));

        investmentRepository.delete(investment);
    }

    private InvestmentResponse convertToResponse(Investment investment) {

        InvestmentResponse response = new InvestmentResponse();

        response.setInvestmentId(investment.getInvestmentId());

        response.setPortfolioId(investment.getPortfolio().getPortfolioId());

        response.setPortfolioName(investment.getPortfolio().getPortfolioName());

        response.setInvestmentTypeId(investment.getInvestmentType().getInvestmentTypeId());

        response.setInvestmentType(investment.getInvestmentType().getInvestmentName());

        response.setInvestmentName(investment.getInvestmentName());

        response.setSymbol(investment.getSymbol());

        response.setQuantity(investment.getQuantity());

        response.setPurchasePrice(investment.getPurchasePrice());

        response.setCurrentPrice(investment.getCurrentPrice());

        response.setInvestedAmount(investment.getInvestedAmount());

        response.setCurrentValue(investment.getCurrentValue());

        response.setProfitLoss(investment.getProfitLoss());

        response.setInvestmentDate(investment.getInvestmentDate());

        response.setMaturityDate(investment.getMaturityDate());

        response.setStatus(investment.getStatus());

        response.setCreatedAt(investment.getCreatedAt());

        return response;
    }
}