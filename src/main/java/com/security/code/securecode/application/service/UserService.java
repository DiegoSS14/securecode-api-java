package com.security.code.securecode.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.security.code.securecode.infra.db.jpa.UserEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService {
    public JpaRepository<UserEntity, String> repository;

    public Optional<UserEntity> findById(String id) {
        return repository.findById(id);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
