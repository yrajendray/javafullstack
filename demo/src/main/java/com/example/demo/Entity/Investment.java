package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "investments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "investment_id")
    private Integer investmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investment_type_id", nullable = false)
    private InvestmentType investmentType;

    @Column(name = "investment_name")
    private String investmentName;

    private String symbol;

    private BigDecimal quantity;

    @Column(name = "purchase_price")
    private BigDecimal purchasePrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "invested_amount")
    private BigDecimal investedAmount;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Column(name = "profit_loss")
    private BigDecimal profitLoss;

    @Column(name = "investment_date")
    private LocalDate investmentDate;

    @Column(name = "maturity_date")
    private LocalDate maturityDate;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

	public Integer getInvestmentId() {
		return investmentId;
	}

	public void setInvestmentId(Integer investmentId) {
		this.investmentId = investmentId;
	}

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}

	public InvestmentType getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(InvestmentType investmentType) {
		this.investmentType = investmentType;
	}

	public String getInvestmentName() {
		return investmentName;
	}

	public void setInvestmentName(String investmentName) {
		this.investmentName = investmentName;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public BigDecimal getInvestedAmount() {
		return investedAmount;
	}

	public void setInvestedAmount(BigDecimal investedAmount) {
		this.investedAmount = investedAmount;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}

	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	public LocalDate getInvestmentDate() {
		return investmentDate;
	}

	public void setInvestmentDate(LocalDate investmentDate) {
		this.investmentDate = investmentDate;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
    
}