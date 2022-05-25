package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.entities.AccountType;
import com.company.entities.Beneficiary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class BeneficiaryRepository {

    public void insert(Beneficiary beneficiary) {
        String insertAccountSql = "INSERT INTO BENEFICIARY (beneficiaryId, beneficiaryName, beneficiaryAccNo" +
                ", accountType, account_id) VALUES(?, ?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSql)) {
            preparedStatement.setLong(1, beneficiary.getBeneficiaryId());
            preparedStatement.setString(2, beneficiary.getBeneficiaryName());
            preparedStatement.setInt(3, beneficiary.getBeneficiaryAccNo());
            preparedStatement.setString(4, beneficiary.getAccountType().toString());
            preparedStatement.setInt(5, beneficiary.getAccount().getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Beneficiary> findByAcccountNo(int accountId) throws SQLException {
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        ResultSet resultSet = null;
        try {
            resultSet =  connection.createStatement().executeQuery("SELECT * FROM BENEFICIARY WHERE  account_id = " + accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<Integer, Beneficiary> beneficiaryMap = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            beneficiaryMap.put(i++, mapToBeneficiary(resultSet));
        }
        return beneficiaryMap;
    }


    private Beneficiary mapToBeneficiary(ResultSet resultSet) throws SQLException {
        return new Beneficiary(
                resultSet.getInt(2),
                resultSet.getString(3),
                resultSet.getInt(4),
                AccountType.valueOf(resultSet.getString(5)));
    }
}