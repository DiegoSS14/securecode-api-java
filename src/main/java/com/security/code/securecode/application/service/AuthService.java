package com.security.code.securecode.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.code.securecode.application.dto.LoginRequestDto;
import com.security.code.securecode.application.dto.RequestVerificationDto;
import com.security.code.securecode.domain.repository.SecurityCodeRepository;
import com.security.code.securecode.domain.valueObjects.Password;
import com.security.code.securecode.domain.valueObjects.SecurityCode;
import com.security.code.securecode.infra.db.jpa.UserEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthService {
    private UserService userService;
    private SecurityCodeRepository securityCodeRepository;

    @Transactional
    public void startLogin(LoginRequestDto login) {
        UserEntity user = userService.findByEmail(login
            .email()).get();
        if (user == null) {
            throw new IllegalArgumentException("Invalid password or email");
        }
        
        if (Password.compare(login.password(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid password or email");
        }

        System.out.println(SecurityCode.generateCode());
    }

    public void approveLogin(RequestVerificationDto requestDto) {
        SecurityCode securityCode = securityCodeRepository
            .findByEmail(requestDto.email())
            .get();
        
            if (securityCode == null) {
                throw new IllegalArgumentException("Invalid security code");
            }

            System.out.println("Login was successful");
    }
}
