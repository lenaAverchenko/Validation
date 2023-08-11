package org.telran.validationexample.com.converter;

import org.springframework.stereotype.Component;
import org.telran.validationexample.com.dto.UserDto;
import org.telran.validationexample.com.dto.UserCreateDto;
import org.telran.validationexample.com.entity.User;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto toDto(User user) {
        return new UserDto(user.getName(), user.getEmail());
    }

    @Override
    public User toEntity(UserCreateDto personDto) {

        return new User(personDto.getName(), personDto.getEmail());
    }
}
