package com.company.service;

import com.company.entities.Account;
import com.company.entities.Transaction;

import java.util.List;
import java.util.Optional;



public interface AccountService {
    List<Account> addAccount(Account saving);

    Optional<Account> getAccountByID(long accountId);

    void deposit(double amount, long accountId);

    Transaction transferMoney(Integer senderAccountId, Integer receiverAccountId, Integer amount, Integer customerId,
                              String password);
}