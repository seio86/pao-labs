package com.company.service;
import com.company.entities.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction transaction);
    Transaction viewTransaction(long transactionId);
    Transaction findTransactionById(long transactionId);
    List<Transaction> getAllMyAccTransactions(long accountId);
}
