package com.security.code.securecode.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.code.securecode.application.dto.UpdateRequestDto;
import com.security.code.securecode.infra.db.jpa.UserEntity;
import com.security.code.securecode.infra.db.repository.UserRepository;
import com.security.code.securecode.infra.exception.PatternException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    public UserRepository repository;

    public Optional<UserEntity> findById(String id) {
        return repository.findById(id);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity create(UserEntity user) {
        return repository.saveAndFlush(user);
    }

    public UserEntity update(String email, UpdateRequestDto userUpdate) {
        UserEntity user = findByEmail(email).orElseThrow(() -> new PatternException("Invalid user"));
        if (userUpdate.getName() != null) {
            user.setName(userUpdate.getName());
        }
        if (userUpdate.getEmail() != null) {
            user.setEmail(userUpdate.getEmail());
        }
        if (userUpdate.getPassword() != null) {
            user.setPassword(userUpdate.getPassword());
        }
        if (user == null) {
            throw new PatternException("User not exists");
        }
        return repository.save(user);
    }
}
