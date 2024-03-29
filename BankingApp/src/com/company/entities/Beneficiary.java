package com.company.entities;

import java.util.List;

public class Beneficiary  implements FieldsListIt, ConstructorAdaptor<Beneficiary> {
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

    @Override
    public Beneficiary allStringConstructor(String... args) {
        return new Beneficiary(
                Long.parseLong(args[0]),
                args[1],
                Integer.parseInt(args[2]),
                AccountType.valueOf(args[3])
        );
    }

    @Override
    public List<String> csvValues() {
        return List.of(String.valueOf(beneficiaryId), String.valueOf(beneficiaryName), String.valueOf(beneficiaryAccNo),
                accountType.toString(), String.valueOf(account.getAccountId()));
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Beneficiary{" +
                "beneficiaryId=" + beneficiaryId +
                ", beneficiaryName='" + beneficiaryName + '\'' +
                ", beneficiaryAccNo=" + beneficiaryAccNo +
                ", accountType=" + accountType +
                '}';
    }
}