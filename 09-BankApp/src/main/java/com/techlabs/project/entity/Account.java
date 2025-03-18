package com.techlabs.project.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "accounts")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String accountNumber;

	private Double balance;

	public Account() {
		super();
	}

	private static final AtomicLong counter = new AtomicLong(10000);

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	private User customer;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public User getCustomer() {
		return customer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Account(Long id, String accountNumber, Double balance, User customer) {
		super();
		this.id = id;
		this.accountNumber = String.valueOf(counter.incrementAndGet());
		this.balance = balance;
		this.customer = customer;
	}
}