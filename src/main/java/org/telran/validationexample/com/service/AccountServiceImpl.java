package org.telran.validationexample.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.validationexample.com.entity.Account;
import org.telran.validationexample.com.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account getById(long id) {
        return accountRepository.getReferenceById(id);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
