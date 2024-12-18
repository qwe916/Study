package com.example.spring.transactional.jdbc;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.NotFoundAccountException;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;

public class AccountRepositoryWithTransaction {
    private final DataSource dataSource;

    public AccountRepositoryWithTransaction(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Account save(Account account) {
        String sql = "insert into account(account_id, money) values (?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setInt(2, account.getMoney());
            preparedStatement.executeUpdate();
            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    public Account findById(int accountId) {
        String sql = "select * from account where account_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("account_id"));
                account.setMoney(resultSet.getInt("money"));
                return account;
            } else {
                throw new NotFoundAccountException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, preparedStatement, resultSet);
        }
    }

    public Account findById(Connection connection, int accountId) {
        String sql = "select * from account where account_id = ?";

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, accountId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("account_id"));
                account.setMoney(resultSet.getInt("money"));
                return account;
            } else {
                throw new NotFoundAccountException();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeResultSet(resultSet);
            JdbcUtils.closeStatement(preparedStatement);
        }
    }

    public void update(Connection connection, int accountId, int money) {
        String sql = "update account set money = ? where account_id = ?";

        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, money);
            preparedStatement.setInt(2, accountId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeStatement(preparedStatement);
        }
    }

    public void truncate() {
        String sql = "truncate table account";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(connection, preparedStatement, null);
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        JdbcUtils.closeResultSet(resultSet);
        JdbcUtils.closeStatement(statement);
        JdbcUtils.closeConnection(connection);
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
