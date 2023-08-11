package org.telran.validationexample.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telran.validationexample.com.entity.Account;
import org.telran.validationexample.com.entity.User;
import org.telran.validationexample.com.repository.UserRepository;

import java.util.List;

@Service
//@Profile("prod")
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<User> getAll() {
        System.out.println("Hello again!");
        return userRepository.findAll();
    }

    @Override
    public User getById(long id) {
// просто для перехвата
//            throw new IllegalArgumentException("User with id " + id + " not found");

        return userRepository.getReferenceById(id);
    }

    @Override
    public User addUser(User user) {
        Account account1 = new Account();
        Account account2 = new Account();
        user.getAccounts().add(account1);
        user.getAccounts().add(account2);
        return userRepository.save(user);
    }
}
