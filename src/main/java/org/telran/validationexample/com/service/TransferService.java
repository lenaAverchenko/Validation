package org.telran.validationexample.com.service;

import org.telran.validationexample.com.entity.Account;

public interface TransferService {

    void transfer(long sumToSend, long idFrom, long idTo);
}
