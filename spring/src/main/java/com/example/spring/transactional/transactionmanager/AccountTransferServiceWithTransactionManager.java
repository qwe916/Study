package com.example.spring.transactional.transactionmanager;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;

public class AccountTransferServiceWithTransactionManager {
    private final PlatformTransactionManager transactionManager;
    private final AccountRepositoryWithDataSourceUtils accountRepository;

    public AccountTransferServiceWithTransactionManager(PlatformTransactionManager transactionManager, AccountRepositoryWithDataSourceUtils accountRepository) {
        this.transactionManager = transactionManager;
        this.accountRepository = accountRepository;
    }

    public void accountTransfer(int fromAccountId, int toAccountId, int money) throws SQLException {
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            accountTransferLogic(fromAccountId, toAccountId, money);

            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    private void accountTransferLogic(int fromAccountId, int toAccountId, int money) {
        Account fromAccount = accountRepository.findById(fromAccountId);
        Account toAccount = accountRepository.findById(toAccountId);

        if (fromAccount.getMoney() - money < 0) {
            throw new InsufficientBalanceException();
        }

        accountRepository.update(fromAccountId, toAccount.getMoney() - money);
        accountRepository.update(toAccountId, toAccount.getMoney() + money);
    }
}
