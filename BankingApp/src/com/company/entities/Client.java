package com.company.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client extends User implements FieldsListIt,ConstructorAdaptor<Client> {
    private int clientId;
    private String clientName;
    private String phoneNo;
    private String emailId;

    public Map<Integer, Account> getAccount() {
        return account;
    }

    private Map<Integer, Account> account;

    public Client() {
    }

    public Client(int clientId, String clientName, String phoneNo, String emailId) {
        super();
        this.clientId = clientId;
        this.clientName = clientName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public void setAccount(Map<Integer, Account> account) {
        this.account = account;
    }

    public void addAccount(Account account) {
        if (this.account == null) {
            this.account = new HashMap<>();
        }
        this.account.put(account.getAccountId(), account);
    }

    @Override
    public List<String> csvValues() {
        return List.of(String.valueOf(clientId), clientName, phoneNo, emailId, account.keySet().toString());
    }

    @Override
    public Client allStringConstructor(String... args) {
        return new Client(
                Integer.parseInt(args[0]),
                args[1],
                args[2],
                args[3]
        );
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}