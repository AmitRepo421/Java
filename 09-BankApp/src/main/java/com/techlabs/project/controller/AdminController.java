package com.techlabs.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.project.dto.AccountResponse;
import com.techlabs.project.dto.AddBankAccountRequest;
import com.techlabs.project.dto.AddCustomerRequest;
import com.techlabs.project.entity.Account;
import com.techlabs.project.entity.User;
import com.techlabs.project.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/admin/add-customer")
	public User addCustomer(@Valid @RequestBody AddCustomerRequest request) {
		return adminService.addCustomer(request);
	}

	@PostMapping("/admin/add-account")
	public AccountResponse addBankAccount(@Valid @RequestBody AddBankAccountRequest request) {
		return adminService.addBankAccount(request);
	}
}
