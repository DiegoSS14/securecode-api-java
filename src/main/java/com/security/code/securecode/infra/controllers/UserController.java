package com.security.code.securecode.infra.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.code.securecode.application.dto.UpdateRequestDto;
import com.security.code.securecode.application.dto.UserDto;
import com.security.code.securecode.application.dto.UserReturnDto;
import com.security.code.securecode.application.service.UserService;
import com.security.code.securecode.infra.db.jpa.UserEntity;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<UserReturnDto>> findAll() {
        List<UserReturnDto> users = service.findAll().stream()
                .map(user -> new UserReturnDto(user.getName(), user.getEmail()))
                .toList();
        return ResponseEntity.ok(users);
    }

    @PutMapping
    public ResponseEntity<UserReturnDto> update(@RequestBody UpdateRequestDto userDto) {
        Optional<UserEntity> userEntity = service.findByEmail(userDto.getEmail());
        if (userEntity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return service.update(userDto.getEmail(), userDto);
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid UserDto userDto) {
        Optional<UserEntity> userEntity = service.findByEmail(userDto.getEmail());
        if (userEntity.isEmpty()) {
            service.create(userDto);
        }
        return ResponseEntity.accepted()
                .body("Se este e-mail estiver cadastrado, você receberá um link para acessar sua conta ou redefinir sua senha.");
    }
}
