package com.security.code.securecode.infra.db.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.security.code.securecode.domain.repository.SecurityCodeRepository;
import com.security.code.securecode.domain.valueObjects.SecurityCode;

@Component
public class InMemorySecurityCodeRepository implements SecurityCodeRepository {

    private final Map<String, SecurityCode> storage = new ConcurrentHashMap<>();

    @Override
    public Optional<SecurityCode> findByEmail(String email) {
        SecurityCode securityCode = storage.get(email);
        return Optional.ofNullable(securityCode);
    }

    @Override
    public void remove(String email) {
        storage.remove(email);
    }
    
    @Override
    public void save(String email, SecurityCode code) {
        storage.put(email, code);
    }
}
