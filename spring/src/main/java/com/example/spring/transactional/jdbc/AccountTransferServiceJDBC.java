package com.example.spring.transactional.jdbc;

import com.example.spring.transactional.domain.Account;
import com.example.spring.transactional.exception.InsufficientBalanceException;

public class AccountTransferServiceJDBC {
    private final AccountRepositoryJDBC accountRepository;


    public AccountTransferServiceJDBC(AccountRepositoryJDBC accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void accountTransfer(int fromAccountId, int toAccountId, int money) {
        Account fromAccount = accountRepository.findById(fromAccountId);
        Account toAccount = accountRepository.findById(toAccountId);

        accountRepository.update(fromAccountId, toAccount.getMoney() - money);
        if (fromAccount.getMoney() - money < 0) {
            throw new InsufficientBalanceException();
        }
        accountRepository.update(toAccountId, toAccount.getMoney() + money);
    }
}
