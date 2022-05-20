package com.company.service;

import com.company.entities.Transaction;

import java.util.List;

public class TransactionServiceImpl implements TransactionService{
    private static TransactionService INSTANCE;

    private TransactionServiceImpl() {
    }

    private static TransactionService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new TransactionServiceImpl();
        }
        return INSTANCE;
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction viewTransaction(long transactionId) {
        return null;
    }

    @Override
    public Transaction findTransactionById(long transactionId) {
        return null;
    }

    @Override
    public List<Transaction> getAllMyAccTransactions(long accountId) {
        return null;
    }
}
