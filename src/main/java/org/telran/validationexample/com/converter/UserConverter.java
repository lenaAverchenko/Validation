package org.telran.validationexample.com.converter;

import org.telran.validationexample.com.dto.UserDto;
import org.telran.validationexample.com.dto.UserCreateDto;
import org.telran.validationexample.com.entity.User;

public interface UserConverter {

    UserDto toDto(User user);

    User toEntity(UserCreateDto personDto);

}
