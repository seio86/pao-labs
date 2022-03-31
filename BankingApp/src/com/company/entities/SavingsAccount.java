package com.company.entities;

import com.company.entities.Account;

public class SavingsAccount extends Account {
    private int minBalance = 1000;
    private int fee = 10;

    public SavingsAccount() {  }

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