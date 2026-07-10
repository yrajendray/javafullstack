package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "investment_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvestmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_type_id")
    private Integer investmentTypeId;

    @Column(name = "investment_name", unique = true)
    private String investmentName;

    @OneToMany(mappedBy = "investmentType")
    private List<Investment> investments;

	public Integer getInvestmentTypeId() {
		return investmentTypeId;
	}

	public void setInvestmentTypeId(Integer investmentTypeId) {
		this.investmentTypeId = investmentTypeId;
	}

	public String getInvestmentName() {
		return investmentName;
	}

	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}

	public List<Investment> getInvestments() {
		return investments;
	}

	public void setInvestments(List<Investment> investments) {
		this.investments = investments;
	}
    
    
    
}