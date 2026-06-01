package com.security.code.securecode.infra.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.code.securecode.application.dto.UserDto;
import com.security.code.securecode.application.service.UserService;
import com.security.code.securecode.domain.model.User;
import com.security.code.securecode.infra.db.jpa.UserEntity;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping()
    public List<UserDto> findAll() {
        return service.findAll().stream()
            .map(UserDto::new)
            .toList();
    }

    @PostMapping
    public UserEntity postMethodName(@RequestBody UserDto userDto) {
        User user = new User(userDto);
        UserEntity userEntity = new UserEntity(user);
        return service.create(userEntity);
    }
    
}
