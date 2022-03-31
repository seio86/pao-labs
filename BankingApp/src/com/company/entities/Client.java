package com.company.entities;


import java.util.Set;

public class Client extends User {

    private String clientName;
    private String phoneNo;
    private String emailId;

    private Set<Account> account;

    public Client() {
    }

    public Client(String clientName, String phoneNo, String emailId, Set<Account> account) {
        super();
        this.clientName = clientName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.account = account;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

}