package com.techlabs.project.service;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.techlabs.project.entity.Account;
import com.techlabs.project.entity.User;
import com.techlabs.project.exception.CustomerNotFoundException;
import com.techlabs.project.repository.AccountRepository;
import com.techlabs.project.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final UserRepository userRepository;

	public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
		this.accountRepository = accountRepository;
		this.userRepository = userRepository;
	}

//	public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }	

	public Account getAccountByNumber(String accountNumber) throws AccountNotFoundException {
		return accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));
	}

	@Transactional
	public void addAccount(Long customerId) {
		User customer = userRepository.findById(customerId)
				.orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
		Account account = new Account();
		account.setCustomer(customer);
		accountRepository.save(account);
	}

	@Transactional
	public void deleteAccount(Long accountId) throws AccountNotFoundException {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new AccountNotFoundException("Account not found!"));
		accountRepository.delete(account);
	}
}
