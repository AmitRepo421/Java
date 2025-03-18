package com.techlabs.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.project.dto.TransactionRequest;
import com.techlabs.project.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER', ROLE_ADMIN)")
    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<String> deposit(@PathVariable Long accountId, 
                                          @Valid @RequestBody TransactionRequest request) {
        transactionService.deposit(accountId, request.getAmount());
        return ResponseEntity.ok("₹" + request.getAmount() + " deposited successfully!");
    }

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER', ROLE_ADMIN)")
    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable Long accountId, 
                                           @Valid @RequestBody TransactionRequest request) {
        transactionService.withdraw(accountId, request.getAmount());
        return ResponseEntity.ok("₹" + request.getAmount() + " withdrawn successfully!");
    }

    @PreAuthorize("hasAnyRole('ROLE_CUSTOMER', ROLE_ADMIN)")
    @PostMapping("/{accountId}/transfer")
    public ResponseEntity<String> transfer(@PathVariable Long accountId, 
                                           @Valid @RequestBody TransactionRequest request) {
        transactionService.transfer(accountId, request.getToAccountNumber(), request.getAmount());
        return ResponseEntity.ok("₹" + request.getAmount() + " transferred successfully!");
    }
}
