package org.telran.validationexample.com.service;

import org.telran.validationexample.com.entity.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    Account getById(long id);

    List<Account> getAll();
}
