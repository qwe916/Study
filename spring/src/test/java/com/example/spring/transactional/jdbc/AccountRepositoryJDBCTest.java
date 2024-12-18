package com.example.spring.transactional.jdbc;

import com.example.spring.transactional.domain.Account;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.spring.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

class AccountRepositoryJDBCTest {
    private AccountRepositoryJDBC accountTransferRepository;

    @BeforeEach
    void init() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        accountTransferRepository = new AccountRepositoryJDBC(dataSource);
    }

    @AfterEach
    void tearDown() {
        accountTransferRepository.truncate();
    }

    @Test
    void save_account() {
        //given
        Account account = new Account(1, 10000);
        //when
        Account savedAccount = accountTransferRepository.save(account);
        //then
        assertThat(savedAccount).isEqualTo(account);
    }

    @Test
    void find_account_by_account_id() {
        //given
        Account account = new Account(1, 10000);
        Account savedAccount = accountTransferRepository.save(account);
        //when
        Account foundAccount = accountTransferRepository.findById(savedAccount.getId());
        //then
        assertThat(foundAccount).isEqualTo(savedAccount);
    }

    @Test
    void update_account() {
        //given
        Account account = new Account(1, 10000);
        Account savedAccount = accountTransferRepository.save(account);
        //when
        accountTransferRepository.update(savedAccount.getId(), 5000);
        //then
        Account updatedAccount = accountTransferRepository.findById(savedAccount.getId());
        assertThat(updatedAccount.getMoney()).isEqualTo(5000);
    }
}