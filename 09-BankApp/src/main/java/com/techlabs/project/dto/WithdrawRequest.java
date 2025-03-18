package com.techlabs.project.dto;

import com.techlabs.project.entity.TransactionType;

import jakarta.validation.constraints.NotNull;

public class WithdrawRequest {
	@NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Transaction type is required") // Use @NotNull instead of @NotBlank
    private TransactionType transactionType;

	public Double getAmount() {
		return amount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public WithdrawRequest() {
		super();
	}
    
    
	
}
