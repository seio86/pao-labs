package com.company.entities;

import java.util.*;

public class Account {
    private long accountId;
    private double interestRate;
    private double balance;
    private AccountType accountType;
    private Client client;
    private Set<Beneficiary> beneficiaries;
    private Set<Transaction> transaction;

    public Account() {

    }

    public Account(long accountId, double interestRate, double balance, AccountType accountType,
                   Set<Beneficiary> beneficiaries, Client client, Set<Transaction> transaction) {
        super();
        this.accountId = accountId;
        this.interestRate = interestRate;
        this.balance = balance;
        this.accountType = accountType;
        this.transaction = transaction;
        this.client = client;
        this.beneficiaries = beneficiaries;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Set<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Set<Transaction> transaction) {
        this.transaction = transaction;
    }

    public Set<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Client getClient() {
        return client;
    }

    public void setCustomer(Client customer) {
        this.client = customer;
    }
}
