package com.example.spring.transactional.jdbc;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static com.example.spring.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.*;

class AccountTransferServiceJDBCTest {
    private static final Account ACCOUNT1 = new Account(1, 10000);
    private static final Account ACCOUNT2 = new Account(2, 10000);

    private AccountRepositoryJDBC accountRepository;
    private AccountTransferServiceJDBC accountTransferService;

    @BeforeEach
    void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        accountRepository = new AccountRepositoryJDBC(dataSource);
        accountTransferService = new AccountTransferServiceJDBC(accountRepository);
    }

    @AfterEach
    void afterEach() {
        accountRepository.truncate();
    }

    @Test
    void account_transfer_success() {
        //given
        accountRepository.save(ACCOUNT1);
        accountRepository.save(ACCOUNT2);
        //when
        accountTransferService.accountTransfer(ACCOUNT1.getId(), ACCOUNT2.getId(), 5000);
        //then
        Account fromAccount = accountRepository.findById(ACCOUNT1.getId());
        Account toAccount = accountRepository.findById(ACCOUNT2.getId());

        assertThat(fromAccount.getMoney()).isEqualTo(5000);
        assertThat(toAccount.getMoney()).isEqualTo(15000);
    }

    @Test
    void account_transfer_fail() {
        //given
        accountRepository.save(ACCOUNT1);
        accountRepository.save(ACCOUNT2);
        //when
        assertThatThrownBy(() -> accountTransferService.accountTransfer(ACCOUNT1.getId(), ACCOUNT2.getId(), 50000))
                .isInstanceOf(InsufficientBalanceException.class);

        assertThat(accountRepository.findById(ACCOUNT1.getId()).getMoney()).isEqualTo(-40000);
        assertThat(accountRepository.findById(ACCOUNT2.getId()).getMoney()).isEqualTo(10000);
    }
}