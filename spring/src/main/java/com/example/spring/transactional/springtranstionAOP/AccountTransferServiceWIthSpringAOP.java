package com.example.spring.transactional.springtranstionAOP;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;
import com.example.spring.transactional.transactionmanager.AccountRepositoryWithDataSourceUtils;
import org.springframework.transaction.annotation.Transactional;

public class AccountTransferServiceWIthSpringAOP {
    private final AccountRepositoryWithDataSourceUtils accountRepository;

    public AccountTransferServiceWIthSpringAOP(AccountRepositoryWithDataSourceUtils accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void accountTransfer(int fromAccountId, int toAccountId, int money) throws Exception {
        accountTransferLogic(fromAccountId, toAccountId, money);
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
