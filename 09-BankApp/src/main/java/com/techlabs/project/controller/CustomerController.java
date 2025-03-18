package com.techlabs.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlabs.project.dto.CustomerUpdateRequest;
import com.techlabs.project.entity.User;
import com.techlabs.project.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/admin/customers")
//    public ResponseEntity<String> addCustomer(@Valid @RequestBody User customerRequest) {
//        customerService.addCustomer(customerRequest);
//        return ResponseEntity.ok("Customer added successfully!");
//    }

   
    @DeleteMapping("/admin/customers/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok("Customer deleted successfully!");
    }

    @PutMapping("/customers/{customerId}/update")
    public ResponseEntity<String> updateCustomer(@PathVariable Long customerId,
                                                 @Valid @RequestBody CustomerUpdateRequest request) {
        customerService.updateCustomer(customerId, request);
        return ResponseEntity.ok("Customer details updated successfully!");
    }
}
