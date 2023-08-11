package org.telran.validationexample.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.telran.validationexample.com.entity.Account;


@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private AccountService accountService;


    @Override
    public void transfer(long sumToSend, long idFrom, long idTo) {
        Account accountOne = accountService.getById(idFrom);
        Account accountTwo = accountService.getById(idTo);
        if ((accountOne.getAmount()-sumToSend)<0){
            throw new IllegalArgumentException("The money is not enough to send");
        }
        accountOne.setAmount(accountOne.getAmount()-sumToSend);
        accountService.createAccount(accountOne);
        accountTwo.setAmount(accountTwo.getAmount()+sumToSend);
        accountService.createAccount(accountTwo);
    }
}
