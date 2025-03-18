package com.techlabs.project.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.techlabs.project.entity.Account;
import com.techlabs.project.entity.Transaction;
import com.techlabs.project.entity.TransactionType;
import com.techlabs.project.exception.AccountNotFoundException;
import com.techlabs.project.exception.InsufficientBalanceException;
import com.techlabs.project.exception.InvalidTransactionException;
import com.techlabs.project.repository.AccountRepository;
import com.techlabs.project.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void deposit(Long accountId, Double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Deposit amount must be greater than zero!");
        }
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found!"));
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Transactional
    public void withdraw(Long accountId, Double amount) {
        if (amount <= 0) {
            throw new InvalidTransactionException("Withdrawal amount must be greater than zero!");
        }
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found!"));

        if (account.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    @Transactional
    public void transfer(Long fromAccountId, Long toAccountId, Double amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found!"));

        Account toAccount = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Recipient account not found!"));

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance for transfer!");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction debitTransaction = new Transaction(TransactionType.DEBIT, amount, fromAccount);
        Transaction creditTransaction = new Transaction(TransactionType.CREDIT, amount, toAccount);
        Transaction transferTransaction = new Transaction(toAccountId, fromAccount, toAccount, TransactionType.TRANSFER, amount, LocalDateTime.now());
        transactionRepository.save(debitTransaction);
        transactionRepository.save(creditTransaction);
        transactionRepository.save(transferTransaction);
    }
}
