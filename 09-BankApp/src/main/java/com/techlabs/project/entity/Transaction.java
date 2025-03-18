package com.techlabs.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "from_account_id")
	private Account fromAccount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_account_id", nullable = true)
	private Account toAccount; // Only for transfers

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TransactionType transactionType; // CREDIT, DEBIT, TRANSFER

	private Double amount;

	private LocalDateTime transactionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false)
	private Account account;

	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Transaction(Long id, Account fromAccount, Account toAccount, TransactionType transactionType, Double amount,
			LocalDateTime transactionDate) {
		super();
		this.id = id;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transactionType = transactionType;
		this.amount = amount;
		this.transactionDate = transactionDate;
	}

	public Transaction(TransactionType transactionType, Double amount, Account account) {
		this.transactionType = transactionType;
		this.amount = amount;
		this.account = account;
	}

	public Transaction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public Account getFromAccount() {
		return fromAccount;
	}

	public Account getToAccount() {
		return toAccount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction(Account toAccount, TransactionType transactionType, Double amount) {
		super();
		this.toAccount = toAccount;
		this.transactionType = transactionType;
		this.amount = amount;
	}

}
