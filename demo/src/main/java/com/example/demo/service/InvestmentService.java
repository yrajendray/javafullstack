package com.example.demo.service;



import java.util.List;

import com.example.demo.dto.InvestmentRequest;
import com.example.demo.dto.InvestmentResponse;

public interface InvestmentService {

    InvestmentResponse save(InvestmentRequest request);

    List<InvestmentResponse> getAll();

    InvestmentResponse getById(Integer id);

    InvestmentResponse update(Integer id, InvestmentRequest request);

    void delete(Integer id);

}