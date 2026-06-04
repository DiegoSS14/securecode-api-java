package com.security.code.securecode.domain.repository;

import java.util.Optional;

import com.security.code.securecode.domain.valueObjects.SecurityCode;

public interface SecurityCodeRepository {
    public void save(String email, SecurityCode code);
    public Optional<SecurityCode> findByEmail(String email);
    public void remove(String email);
}
