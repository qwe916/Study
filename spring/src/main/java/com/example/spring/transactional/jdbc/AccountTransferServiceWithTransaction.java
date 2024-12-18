package com.example.spring.transactional.jdbc;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class AccountTransferServiceWithTransaction {
    private final AccountRepositoryWithTransaction accountRepository;
    private final DataSource dataSource;


    public AccountTransferServiceWithTransaction(AccountRepositoryWithTransaction accountRepository, DataSource dataSource) {
        this.accountRepository = accountRepository;
        this.dataSource = dataSource;
    }

    public void accountTransfer(int fromAccountId, int toAccountId, int money) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);

            accountTransferLogic(fromAccountId, toAccountId, money, connection);

            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw e;
        } finally {
            release(connection);
        }
    }

    private void accountTransferLogic(int fromAccountId, int toAccountId, int money, Connection connection) {
        Account fromAccount = accountRepository.findById(connection, fromAccountId);
        Account toAccount = accountRepository.findById(connection, toAccountId);


        if (fromAccount.getMoney() - money < 0) {
            throw new InsufficientBalanceException();
        }

        accountRepository.update(connection, fromAccountId, toAccount.getMoney() - money);
        accountRepository.update(connection, toAccountId, toAccount.getMoney() + money);
    }

    private void release(Connection connection) {
        if (connection != null) {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
