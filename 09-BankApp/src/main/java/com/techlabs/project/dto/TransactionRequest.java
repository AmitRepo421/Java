package com.techlabs.project.dto;

import com.techlabs.project.entity.TransactionType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {

	@NotNull(message = "Transaction type is required")
	private TransactionType transactionType;

	@Min(value = 1, message = "Amount must be greater than 0")
	private Double amount;

	private long toAccountNumber; // for transfers

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public long getToAccountNumber() {
		return toAccountNumber;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setToAccountNumber(long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public TransactionRequest(TransactionType transactionType, Double amount, long toAccountNumber) {
		this.transactionType = transactionType;
		this.amount = amount;
		this.toAccountNumber = toAccountNumber;
	}

	public TransactionRequest() {
		super();
	}
}
