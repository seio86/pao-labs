package com.company.entities;

import com.company.entities.Account;

import java.util.Map;
import java.util.Set;

public class SavingsAccount extends Account {
    private int minBalance = 1000;
    private int fee = 10;

    public SavingsAccount() {
    }

    public SavingsAccount(long accountId, double interestRate, double balance, AccountType accountType,
                          Map<Integer, Beneficiary> beneficiaries, Map<Integer, Client> clientMap, Map<Integer, Transaction> transaction, int minBalance, int fee) {

        super((int) accountId, interestRate , balance ,accountType, transaction, clientMap,beneficiaries);
        this.fee = fee;
        this.minBalance = minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(int minBalance) {
        this.minBalance = minBalance;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

}