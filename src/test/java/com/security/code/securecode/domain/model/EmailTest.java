package com.security.code.securecode.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.security.code.securecode.domain.exception.DomainException;

public class EmailTest {
    @Test
    public void deveCriarUmEmailValido() {
        Email email = new Email("valid@example.com");
        assertNotNull(email.getValue());
    }

    @Test
    public void deveLancarExcecaoParaEmailVazio() {
        DomainException exception = assertThrows(DomainException.class, () -> new Email(""));
        assertEquals("Email address cannot be empty", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoParaEmailNulo() {
        DomainException exception = assertThrows(DomainException.class, () -> new Email(null));
        assertEquals("Email address cannot be null", exception.getMessage());
    }
}