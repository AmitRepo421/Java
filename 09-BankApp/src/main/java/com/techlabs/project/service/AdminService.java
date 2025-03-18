package com.techlabs.project.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlabs.project.dto.AccountResponse;
import com.techlabs.project.dto.AddBankAccountRequest;
import com.techlabs.project.dto.AddCustomerRequest;
import com.techlabs.project.entity.Account;
import com.techlabs.project.entity.Role;
import com.techlabs.project.entity.User;
import com.techlabs.project.repository.AccountRepository;
import com.techlabs.project.repository.RoleRepository;
import com.techlabs.project.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepo;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User addCustomer(AddCustomerRequest request) {
		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new IllegalArgumentException("Email is already registered.");
		}

		User customer = new User();
		customer.setFirstName(request.getFirstName());
		customer.setLastName(request.getLastName());
		customer.setEmail(request.getEmail());
		customer.setPassword(passwordEncoder.encode(request.getPassword()));

		Role role = roleRepo.findById(request.getRole()).get();

		customer.setRole(role);

		return userRepository.save(customer);
	}

	public AccountResponse addBankAccount(AddBankAccountRequest request) {
		User customer = userRepository.findById(request.getCustomerId())
				.orElseThrow(() -> new IllegalArgumentException("Customer not found"));

		Account account = new Account();
		account.setCustomer(customer);
		account.setAccountNumber(UUID.randomUUID().toString()); // Generate unique account number
		account.setBalance(request.getInitialBalance());

		Account dbAccount = accountRepository.save(account);
		
		AccountResponse response = new AccountResponse();
		response.setId(dbAccount.getId());
		response.setAccountNumber(dbAccount.getAccountNumber());
		response.setBalance(dbAccount.getBalance());
		
		return response;
	}
}
