package com.example.spring.transactional.transactionmanager;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import static com.example.spring.jdbc.connection.ConnectionConst.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AccountTransferServiceWithTransactionTemplateTest {
    private static final Account ACCOUNT1 = new Account(1, 10000);
    private static final Account ACCOUNT2 = new Account(2, 10000);

    private AccountTransferServiceWithTransactionTemplate accountTransferService;
    private AccountRepositoryWithDataSourceUtils accountRepository;

    @BeforeEach
    void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        accountRepository = new AccountRepositoryWithDataSourceUtils(dataSource);
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        accountTransferService = new AccountTransferServiceWithTransactionTemplate(transactionManager, accountRepository);
    }

    @AfterEach
    void afterEach() {
        accountRepository.truncate();
    }

    @Test
    void account_transfer_success(){
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
    void account_transfer_fail_with_transaction() {
        //given
        accountRepository.save(ACCOUNT1);
        accountRepository.save(ACCOUNT2);
        //when
        assertThatThrownBy(() -> accountTransferService.accountTransfer(ACCOUNT1.getId(), ACCOUNT2.getId(), 50000))
                .isInstanceOf(InsufficientBalanceException.class);
        //then
        Account fromAccount = accountRepository.findById(ACCOUNT1.getId());
        Account toAccount = accountRepository.findById(ACCOUNT2.getId());

        assertThat(fromAccount.getMoney()).isEqualTo(10000);
        assertThat(toAccount.getMoney()).isEqualTo(10000);
    }

}