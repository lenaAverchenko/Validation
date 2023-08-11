package org.telran.validationexample.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.validationexample.com.entity.Account;
import org.telran.validationexample.com.service.AccountService;

import java.util.List;


@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account addAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable (name = "id") long id)
    {
        return accountService.getById(id);
    }

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }
}
