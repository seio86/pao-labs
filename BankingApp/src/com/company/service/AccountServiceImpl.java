package com.company.service;

import com.company.Main;
import com.company.entities.Account;
import com.company.entities.Client;
import com.company.entities.Transaction;

import java.util.List;
import java.util.Optional;

/**
 * Singleton means that we only have ONE instance of that class
 * we force it by
 * using a static method (public T getInstance)
 * setting private access to constructor
 * keeping a private static field of that instance (so we can verify if it is null or not
 */
public class AccountServiceImpl implements AccountService {


    private static AccountService INSTANCE;

    private AccountServiceImpl() {
    }

    private static AccountService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AccountServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public List<Account> addAccount(Account saving) {
        Main.accountsList.add(saving);
        return Main.accountsList;
    }

    @Override
    public Optional<Account> getAccountByID(long accountId) {
        return Main.accountsList.stream().filter(account -> account.getAccountId() == accountId).findFirst();
    }

    @Override
    public void deposit(double amount, long accountId) {
        getAccountByID(accountId).ifPresent(account -> account.deposit(amount));
    }

    @Override
    public Transaction transferMoney(Integer senderAccountId, Integer receiverAccountId, Integer amount, Integer customerId, String password) {
        Client client1 = Main.clientsList.stream().filter(client -> client.getCustomerId() == customerId).findFirst().get();
        Transaction transaction = new Transaction(Main.uid++, senderAccountId, receiverAccountId, amount, Integer.parseInt(password));
//        client1.getAccount().addTransaction(transaction, customerId);
        return transaction;
    }
}
