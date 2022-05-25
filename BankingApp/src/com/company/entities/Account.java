package com.company.entities;

import com.company.Main;
import com.company.csv.CsvReader;
import com.company.csv.CsvReaderImpl;

import java.util.*;


public class Account implements FieldsListIt, ConstructorAdaptor<Account>, Comparator<Account> {
    private int accountId;
    private double interestRate;
    private double balance;
    private AccountType accountType;
    private Map<Integer, Transaction> transaction;
    private Map<Integer, Client> client;
    private Map<Integer, Beneficiary> beneficiaries;

    public Account() {

    }

    public Account(int accountId, double interestRate, double balance, AccountType accountType
            , Map<Integer, Transaction> transaction, Map<Integer, Client> client, Map<Integer, Beneficiary> beneficiaries) {
        super();
        this.accountId = accountId;
        this.interestRate = interestRate;
        this.balance = balance;
        this.accountType = accountType;
        this.beneficiaries = beneficiaries;
        this.client = client;
        this.transaction = transaction;
//        Main.logger.info("New account with id " + accountId + "  created!");
        Main.myLogger.info("New account with id " + accountId + "  created!");
    }

    @Override
    public Account allStringConstructor(String... args) {
        return new Account(
                Integer.parseInt(args[0]),
                Double.parseDouble(args[1]),
                Double.parseDouble(args[2]),
                AccountType.valueOf(args[3]),
                readTransactions(args[4]),
                readClients(args[5]),
                readBeneficiaries(args[6])
        );
    }

    private Map<Integer, Transaction> readTransactions(String ids) {
        CsvReader<Transaction> csvReader = new CsvReaderImpl<>();
        List<Transaction> transactions = csvReader.readFromCsv(new Transaction());
        Map<Integer, Transaction> transactionHashMap = new HashMap<>();
        int i = 0;
        System.out.println("ids = " + ids);
        for (String id : ids.substring(1, ids.length() - 1).split(",")) {
            System.out.println("id = " + id);
            int key = Integer.parseInt(id.strip());
            transactionHashMap.put(key, transactions.get(i++));
        }
        return transactionHashMap;
    }

    private Map<Integer, Client> readClients(String ids) {
        CsvReader<Client> csvReader = new CsvReaderImpl<>();
        List<Client> clients = csvReader.readFromCsv(new Client());
        Map<Integer, Client> clientHashMap = new HashMap<>();
        int i = 0;
        for (String id : ids.substring(1, ids.length() - 1).split(",")) {
            int key = Integer.parseInt(id.strip());
            clientHashMap.put(key, clients.get(i++));
        }
        return clientHashMap;
    }

    private Map<Integer, Beneficiary> readBeneficiaries(String ids) {
        CsvReader<Beneficiary> csvReader = new CsvReaderImpl<>();
        List<Beneficiary> beneficiaryList = csvReader.readFromCsv(new Beneficiary());
        Map<Integer, Beneficiary> beneficiaryHashMap = new HashMap<>();
        int i = 0;
        for (String id : ids.substring(1, ids.length() - 1).split(",")) {
            int key = Integer.parseInt(id.strip());
            beneficiaryHashMap.put(key, beneficiaryList.get(i++));
        }
        return beneficiaryHashMap;
    }

    @Override
    public List<String> csvValues() {
        return List.of(
                String.valueOf(accountId),
                String.valueOf(interestRate),
                String.valueOf(balance),
                accountType.toString(),
                transaction.keySet().toString(),
                client.keySet().toString(),
                beneficiaries.keySet().toString());
    }

    public int getAccountId() {
        return accountId;
    }


    public void deposit(double amount) {
        this.balance += amount;
    }

    public void addTransaction(Transaction transaction, int i) {
        this.transaction.put(i, transaction);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", interestRate=" + interestRate +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ",\n transaction=" + transaction +
                ",\n client=" + client +
                ",\n beneficiaries=" + beneficiaries +
                '}';
    }

    @Override
    public int compare(Account account1, Account account2) {
        if (account1.balance < account2.balance) {
            return -1;
        } else if (account1.balance > account2.balance) {
            return 1;
        }
        if (account1.interestRate > account2.interestRate) {
            return -1;
        } else if (account1.interestRate < account2.interestRate) {
            return 1;
        }
        return 0;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Map<Integer, Transaction> getTransaction() {
        return transaction;
    }

    public Map<Integer, Client> getClient() {
        return client;
    }

    public Map<Integer, Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }
}
