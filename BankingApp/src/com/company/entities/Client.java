package com.company.entities;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client extends User implements FieldsListIt,ConstructorAdaptor<Client> {
    private int clientId;
    private String clientName;
    private String phoneNo;
    private String emailId;
    private int accountNo;

    public Client() {
    }

    public Client(int clientId, String clientName, String phoneNo, String emailId) {
        super();
        this.clientId = clientId;
        this.clientName = clientName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public Client(int clientId, String clientName,
                  String phoneNo, String emailId, int accountNo) {
        super();
        this.clientId = clientId;
        this.clientName = clientName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.accountNo = accountNo;
    }

    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public int getAccountNo() {
        return accountNo;
    }

    @Override
    public List<String> csvValues() {
        return List.of(String.valueOf(clientId), clientName, phoneNo, emailId
                , String.valueOf(accountNo));
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

    public void addAccount(Account account) {
        accountNo = account.getAccountId();
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
}