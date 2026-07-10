package com.example.demo.service;

import com.example.demo.dto.PortfolioRequest;
import com.example.demo.dto.PortfolioResponse;

import java.util.List;

public interface PortfolioService {

    PortfolioResponse save(PortfolioRequest request);

    List<PortfolioResponse> findAll();

    PortfolioResponse findById(Integer id);

    PortfolioResponse update(Integer id, PortfolioRequest request);

    void delete(Integer id);

}