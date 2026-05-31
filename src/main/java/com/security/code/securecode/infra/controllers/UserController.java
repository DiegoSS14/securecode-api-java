package com.security.code.securecode.infra.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.code.securecode.application.dto.UserDto;
import com.security.code.securecode.application.service.UserService;

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
}
