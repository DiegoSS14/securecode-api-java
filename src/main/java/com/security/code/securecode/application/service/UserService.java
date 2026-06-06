package com.security.code.securecode.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.code.securecode.application.dto.UpdateRequestDto;
import com.security.code.securecode.application.dto.UserDto;
import com.security.code.securecode.application.dto.UserReturnDto;
import com.security.code.securecode.domain.model.User;
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

    public ResponseEntity<UserReturnDto> create(UserDto userDto) {
        User user = new User(userDto);
        UserEntity userEntity = repository.saveAndFlush(new UserEntity(user));
        if (userEntity == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(201).body(new UserReturnDto(userEntity.getName(), userEntity.getEmail()));
    }

    public ResponseEntity<UserReturnDto> update(String email, UpdateRequestDto userUpdate) {
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
        repository.save(user);
        return ResponseEntity.ok(new UserReturnDto(user.getName(), user.getEmail()));
    }
}
