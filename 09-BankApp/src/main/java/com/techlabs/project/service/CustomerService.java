package com.techlabs.project.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlabs.project.dto.CustomerUpdateRequest;
import com.techlabs.project.dto.TransactionRequest;
import com.techlabs.project.entity.Account;
import com.techlabs.project.entity.Transaction;
import com.techlabs.project.entity.TransactionType;
import com.techlabs.project.entity.User;
import com.techlabs.project.exception.AccountNotFoundException;
import com.techlabs.project.exception.CustomerNotFoundException;
import com.techlabs.project.exception.DuplicateEmailException;
import com.techlabs.project.repository.AccountRepository;
import com.techlabs.project.repository.TransactionRepository;
import com.techlabs.project.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private final UserRepository userRepository;
    
    @Autowired
    private final PasswordEncoder passwordEncoder;

    public CustomerService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addCustomer(User customer) {
        if (userRepository.existsByEmail(customer.getEmail())) {
            throw new DuplicateEmailException("Email already exists!");
        }
        userRepository.save(customer);
    }
    
    public Account getAccountByNumber(long accountNumber) {
        return accountRepository.findByAccountNumber(String.valueOf(accountNumber)) 
                .orElseThrow(() -> new AccountNotFoundException("Account not found!"));
    }
    
    @Transactional
    public List<Account> getCustomerAccounts(Long customerId) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        return customer.getAccounts(); 
    }
    
    @Transactional
    public void deleteCustomer(Long customerId) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));
        userRepository.delete(customer);
    }

    @Transactional
    public void updateCustomer(Long customerId, CustomerUpdateRequest request) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found!"));

        if (request.getFirstName() != null) customer.setFirstName(request.getFirstName());
        if (request.getLastName() != null) customer.setLastName(request.getLastName());
        if (request.getEmail() != null) customer.setEmail(request.getEmail());
        if (request.getPassword() != null) customer.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(customer);
    }    
    
    public String depositMoney(Long accountId, TransactionRequest request) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        account.setBalance(account.getBalance() + request.getAmount());
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(account);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return "₹" + request.getAmount() + " deposited successfully!";
    }

    public String withdrawMoney(Long accountId, TransactionRequest request) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        if (account.getBalance() < request.getAmount()) {
            throw new IllegalArgumentException("Insufficient funds!");
        }

        account.setBalance(account.getBalance() - request.getAmount());
        accountRepository.save(account);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(account);
        transaction.setTransactionType(TransactionType.DEBIT);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return "₹" + request.getAmount() + " withdrawn successfully!";
    }

    public String transferMoney(Long fromAccountId, TransactionRequest request) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Sender account not found"));

        Account toAccount = accountRepository.findByAccountNumber(String.valueOf(request.getToAccountNumber()))
                .orElseThrow(() -> new AccountNotFoundException("Account not found!"));

        if (fromAccount.getBalance() < request.getAmount()) {
            throw new IllegalArgumentException("Insufficient balance!");
        }

        fromAccount.setBalance(fromAccount.getBalance() - request.getAmount());
        toAccount.setBalance(toAccount.getBalance() + request.getAmount());
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setAmount(request.getAmount());
        transaction.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction);

        return "₹" + request.getAmount() + " transferred successfully!";
    }
}