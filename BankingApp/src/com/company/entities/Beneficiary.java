package com.company.entities;

public class Beneficiary {
    private long beneficiaryId;
    private String beneficiaryName;
    private int beneficiaryAccNo;
    private AccountType accountType;
    private Account account;
    public Beneficiary() {   }

    public Beneficiary(long beneficiaryId, String beneficiaryName, int beneficiaryAccNo, AccountType accountType) {
        super();
        this.beneficiaryId = beneficiaryId;
        this.beneficiaryName = beneficiaryName;
        this.beneficiaryAccNo = beneficiaryAccNo;
        this.accountType=accountType;
    }

    public long getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(int beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    public int getBeneficiaryAccNo() {
        return beneficiaryAccNo;
    }

    public void setBeneficiaryAccNo(int beneficiaryAccNo) {
        this.beneficiaryAccNo = beneficiaryAccNo;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public AccountType getAccountType() {
        return accountType;
    }
    public void setAccountType(AccountType accountType) {
        this.accountType=accountType;
    }
    public Beneficiary(Account account) {
        super();
        this.account = account;
    }

}