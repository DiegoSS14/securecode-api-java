package com.security.code.securecode.infra.db.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.code.securecode.infra.db.jpa.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public List<UserEntity> findAll();
    public Optional<UserEntity> findById(String id);

    public Optional<UserEntity> findByEmail(String email);
}
