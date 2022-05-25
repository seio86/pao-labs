package com.company.repository;

import com.company.config.DatabaseConfiguration;
import com.company.entities.Account;
import com.company.entities.AccountType;

import java.sql.*;

public class AccountRepositoryUsingPreparedStatement {

    TransactionRepository transactionRepository;
    ClientRepository clientRepository;
    BeneficiaryRepository beneficiaryRepository;

    public AccountRepositoryUsingPreparedStatement(TransactionRepository transactionRepository,
                                                   ClientRepository clientRepository,
                                                   BeneficiaryRepository beneficiaryRepository) {
        this.transactionRepository = transactionRepository;
        this.clientRepository = clientRepository;
        this.beneficiaryRepository = beneficiaryRepository;
    }

    public void insertAccount(Account account) {
        String insertAccountSql = "INSERT INTO account(account_id, interest, balance, type) VALUES(?, ?, ?, ?)";

        Connection connection = DatabaseConfiguration.getDatabaseConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertAccountSql)) {
            preparedStatement.setInt(1, account.getAccountId());
            preparedStatement.setDouble(2, account.getInterestRate());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.setString(4, account.getAccountType().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Account getAccountById(int id) {
        String selectSql = "SELECT * FROM account WHERE account_id="+id;

        Connection connection = DatabaseConfiguration.getDatabaseConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectSql);
            return mapToAccount(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public void updatePersonName(String name, int id) {
//        String updateNameSql = "UPDATE person SET name=? WHERE id=?";
//
//        Connection connection = DatabaseConfiguration.getDatabaseConnection();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setInt(2, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    private Account mapToAccount(ResultSet resultSet) throws SQLException {
        resultSet.next();
        int accountId = resultSet.getInt(2);

        return new Account(
                accountId,
                resultSet.getDouble(3),
                resultSet.getDouble(4),
                AccountType.valueOf(resultSet.getString(5)),
                transactionRepository.findByAccountNo(accountId),
                clientRepository.findByAcccountNo(accountId),
                beneficiaryRepository.findByAcccountNo(accountId));
    }
}