package com.example.demo.repository;

import com.example.demo.Entity.InvestmentType;
import com.example.demo.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestmentTypeRepository extends JpaRepository<InvestmentType,Integer> {

}