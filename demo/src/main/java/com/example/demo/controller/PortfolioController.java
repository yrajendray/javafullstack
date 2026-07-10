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

import com.example.demo.dto.PortfolioRequest;
import com.example.demo.dto.PortfolioResponse;
import com.example.demo.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    @Autowired
	PortfolioService portfolioService;

    @PostMapping
    public ResponseEntity<PortfolioResponse> save(
            @RequestBody PortfolioRequest request){

        return ResponseEntity.ok(portfolioService.save(request));
    }

    @GetMapping
    public List<PortfolioResponse> findAll(){
        return portfolioService.findAll();
    }

    @GetMapping("/{id}")
    public PortfolioResponse findById(@PathVariable Integer id){
        return portfolioService.findById(id);
    }

    @PutMapping("/{id}")
    public PortfolioResponse update(
            @PathVariable Integer id,
            @RequestBody PortfolioRequest request){

        return portfolioService.update(id,request);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){

        portfolioService.delete(id);
        return "Portfolio Deleted";
    }

}