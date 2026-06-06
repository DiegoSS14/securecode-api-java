package com.security.code.securecode.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.code.securecode.application.dto.LoginRequestDto;
import com.security.code.securecode.application.dto.RequestVerificationDto;
import com.security.code.securecode.application.service.AuthService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("auth")
@AllArgsConstructor
public class AuthController {

    AuthService authService;

    @PostMapping("login")
    public ResponseEntity<String> postMethodName(@RequestBody LoginRequestDto login) {
        return authService.startLogin(login);
    }

    @PostMapping("verify")
    public ResponseEntity<String> postMethodName(@RequestBody RequestVerificationDto requestDto) {
        return authService.approveLogin(requestDto);
    }
}
