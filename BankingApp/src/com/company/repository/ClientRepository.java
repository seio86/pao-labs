package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Client;
import com.company.entities.Transaction;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class ClientRepository {

    public void insert(Client client) {
        String insertAccountSql = "INSERT INTO CLIENT (name, phone_no, email, account_id) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSql)) {
            preparedStatement.setString(1, client.getClientName());
            preparedStatement.setString(2, client.getPhoneNo());
            preparedStatement.setString(3, client.getEmailId());
            preparedStatement.setInt(4, client.getAccountNo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Client> findByAcccountNo(int accountNo) throws SQLException {
        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        ResultSet resultSet = null;
        Statement statement = connection.createStatement();
        try {
            resultSet =  statement
                    .executeQuery("SELECT * FROM CLIENT WHERE  account_id = " + accountNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Map<Integer, Client> clientMap = new HashMap<>();
        int i = 0;
        while (resultSet.next()) {
            clientMap.put(i++, mapToClient(resultSet));
        }
        return clientMap;
    }


    private Client mapToClient(ResultSet resultSet) throws SQLException {
        return new Client(
                resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getInt(5));
    }
}
