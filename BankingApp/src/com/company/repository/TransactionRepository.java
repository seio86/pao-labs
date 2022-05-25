package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Transaction;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TransactionRepository {


    public void insert(Transaction transaction) {
        String insertAccountSql = "INSERT INTO TRANSACTION (`from`, `to`, amount, pin) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSql)) {
            preparedStatement.setInt(1, transaction.getFromAccountNumber());
            preparedStatement.setInt(2, transaction.getToAccountNumber());
            preparedStatement.setDouble(3, transaction.getTransactionAmount());
            preparedStatement.setString(4, transaction.getAuthPin().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Map<Integer, Transaction> findByAccountNo(int accountNo) throws SQLException {
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        try {
            resultSet =  statement
                    .executeQuery("SELECT * FROM TRANSACTION WHERE  `from` = " + accountNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<Integer, Transaction> transactionMap = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            transactionMap.put(i++, mapToTransaction(resultSet));
        }
        return transactionMap;
    }


    private Transaction mapToTransaction(ResultSet resultSet) throws SQLException {
        return new Transaction(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getInt(3),
                resultSet.getInt(4),
                resultSet.getInt(5));
    }
}