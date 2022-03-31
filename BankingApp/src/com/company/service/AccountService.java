package com.company.service;
import com.company.entities.Account;
import com.company.entities.SavingsAccount;
import com.company.entities.TermAccount;
import com.company.entities.Transaction;

import java.util.List;

//doar partea de interfete in service deocamdata

public interface AccountService {
    List<Account> addAccount(Account saving);
        List<SavingsAccount> addSavingsAccount(SavingsAccount saving);
        List<TermAccount> addTermAccount(TermAccount term);
         boolean deleteSavingId(long accountId);
         boolean deleteTermId(long accountId);
    Account getAccountByID(long accountId);

    Transaction deposit(double amount, long accountId);
    Transaction transferMoney(long senderAccountId, long receiverAccountId, double amount, long customerId,
                                     String password);
}