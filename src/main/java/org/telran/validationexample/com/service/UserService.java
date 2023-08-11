package org.telran.validationexample.com.service;

import org.telran.validationexample.com.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(long id);

    User addUser(User user);
}
