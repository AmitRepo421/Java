package com.techlabs.project.dto;

public class AccountResponse {

	private long id;
	
	private String accountNumber;
	
	private double balance;

	public long getId() {
		return id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountResponse() {
		super();
	}
	
	
}
