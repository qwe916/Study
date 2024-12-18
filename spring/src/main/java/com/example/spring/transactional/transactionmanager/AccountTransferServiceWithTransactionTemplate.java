package com.example.spring.transactional.transactionmanager;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountTransferServiceWithTransactionTemplate {
    private final TransactionTemplate transactionTemplate;
    private final AccountRepositoryWithDataSourceUtils accountRepository;

    public AccountTransferServiceWithTransactionTemplate(PlatformTransactionManager transactionManager, AccountRepositoryWithDataSourceUtils accountRepository) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
        this.accountRepository = accountRepository;
    }

    public void accountTransfer(int fromAccountId, int toAccountId, int money) {
        transactionTemplate.executeWithoutResult((transactionStatus ->
                accountTransferLogic(fromAccountId, toAccountId, money)));
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
