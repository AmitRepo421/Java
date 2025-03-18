package com.techlabs.project.controller;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.project.service.AccountService;

@RestController
@RequestMapping("/app")
public class AccountController {

	private final AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

//	@PreAuthorize("hasRole('ADMIN')")
//	@PostMapping("/admin/accounts/{customerId}")
//	public ResponseEntity<String> addAccount(@PathVariable Long customerId) {
//		accountService.addAccount(customerId);
//		return ResponseEntity.ok("Account added successfully!");
//	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/admin/accounts/{accountId}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountId) throws AccountNotFoundException {
		accountService.deleteAccount(accountId);
		return ResponseEntity.ok("Account deleted successfully!");
	}
}
