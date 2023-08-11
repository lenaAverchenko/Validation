package org.telran.validationexample.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
1. Add amount to account
2. Create User and 2 accounts
3. Init account (put money for one or 2 accounts)
4. Transfer controller - transfer (user_id, acc1_id, acc2_id, amount)
5. Transfer service - send amount from 1 to 2, check if amount on acc1<0 before
transfer - throw exception
6. TransactionAspect - log to  console start transfer, result transfer or error when exception
* */
@SpringBootApplication
public class ValidationApp {
    public static void main(String[] args) {

        SpringApplication.run(ValidationApp.class, args);
    }
}
