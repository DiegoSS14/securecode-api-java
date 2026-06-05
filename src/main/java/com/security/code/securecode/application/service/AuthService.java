package com.security.code.securecode.application.service;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> startLogin(LoginRequestDto login) {
        Optional<UserEntity> user = userService.findByEmail(login
                .email());

        if (user.isEmpty() || Password.compare(login.password(), user.get().getPassword())) {
            return ResponseEntity.status(403).body("Invalid e-mail or password");
        }

        SecurityCode securityCode = new SecurityCode(10);
        securityCodeRepository.save(login.email(), securityCode);

        System.out.println("Code: " + securityCode.getValue());
        return ResponseEntity.ok("Código enviado com sucesso!");
    }

    public ResponseEntity<String> approveLogin(RequestVerificationDto requestDto) {
        Optional<SecurityCode> findSecurityCode = securityCodeRepository
                .findByEmail(requestDto.email());

        if (findSecurityCode.isEmpty()) {
            return ResponseEntity.status(403).body("Invalid code");
        }

        if (!SecurityCode.equals(findSecurityCode.get().getValue(), requestDto.code())) {
            return ResponseEntity.status(403).body("Invalid code");
        }

        return ResponseEntity.ok("Usuário logado com sucesso");
    }
}
