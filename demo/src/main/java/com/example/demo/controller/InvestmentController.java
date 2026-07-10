package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InvestmentRequest;
import com.example.demo.dto.InvestmentResponse;
import com.example.demo.service.InvestmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/investments")
@RequiredArgsConstructor
public class InvestmentController {

	@Autowired
    InvestmentService investmentService;

    @PostMapping
    public InvestmentResponse save(
            @RequestBody InvestmentRequest request){

        return investmentService.save(request);
    }

    @GetMapping
    public List<InvestmentResponse> getAll(){

        return investmentService.getAll();
    }

    @GetMapping("/{id}")
    public InvestmentResponse getById(
            @PathVariable Integer id){

        return investmentService.getById(id);
    }

    @PutMapping("/{id}")
    public InvestmentResponse update(
            @PathVariable Integer id,
            @RequestBody InvestmentRequest request){

        return investmentService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){

        investmentService.delete(id);
        return "Investment Deleted";
    }

}