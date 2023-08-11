package org.telran.validationexample.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telran.validationexample.com.converter.UserConverter;
import org.telran.validationexample.com.dto.UserDto;
import org.telran.validationexample.com.dto.UserCreateDto;
import org.telran.validationexample.com.entity.User;
import org.telran.validationexample.com.service.UserService;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    List<UserDto> getAll(){
        return userService.getAll()
                .stream()
                .map(user ->userConverter.toDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    UserDto getById(@PathVariable (name = "id") long id)
    {
        return userConverter.toDto(userService.getById(id));
    }

    @PostMapping
    ResponseEntity<UserDto> addUser(@RequestBody UserCreateDto userCreateDto){
//        User user = userConverter.toEntity(userCreateDto);
//        User userEntity = userService.addUser(user);
//        UserDto userDto = userConverter.toDto(userEntity);
        return ResponseEntity.ok(userConverter.toDto(userService.addUser(userConverter.toEntity(userCreateDto))));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String,String> exceptionHandler(ConstraintViolationException ex){
        Map<String, String> map = new HashMap<>();
        ex.getConstraintViolations().forEach(error ->{
            map.put(error.getPropertyPath().toString(), error.getMessage());});
        return map;
    }
}
