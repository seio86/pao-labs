package com.company.entities;

import java.util.List;

public class Transaction implements FieldsListIt, ConstructorAdaptor<Transaction> {

    private Integer id;
    private Integer fromAccountNumber;
    private Integer toAccountNumber;
    private Integer transactionAmount;
    private Integer authPin;

    public Transaction(Integer id, Integer fromAccountNumber, Integer toAccountNumber,
                       Integer transactionAmount, Integer authPin) {
        this.id = id;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transactionAmount = transactionAmount;
        this.authPin = authPin;
    }

    public Transaction() {
    }

    @Override
    public List<String> csvValues() {
        return List.of(String.valueOf(id), String.valueOf(fromAccountNumber), String.valueOf(toAccountNumber),
                String.valueOf(transactionAmount), String.valueOf(authPin));
    }

    @Override
    public Transaction allStringConstructor(String... args) {
        return new Transaction(
                Integer.parseInt(args[0]),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3]),
                Integer.parseInt(args[4])
        );
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", fromAccountNumber=" + fromAccountNumber +
                ", toAccountNumber=" + toAccountNumber +
                ", transactionAmount=" + transactionAmount +
                ", authPin=" + authPin +
                '}';
    }
}
