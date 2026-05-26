package com.security.code.securecode.domain.valueObjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.security.code.securecode.infra.exception.PatternException;

public class EmailTest {
    @Test
    public void deveCriarUmEmailValido() {
        Email email = new Email("valid@example.com");
        assertNotNull(email.getValue());
    }

    @Test
    public void deveLancarExcecaoParaEmailVazio() {
        PatternException exception = assertThrows(PatternException.class, () -> new Email(""));
        assertEquals("Email address cannot be empty", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoParaEmailNulo() {
        PatternException exception = assertThrows(PatternException.class, () -> new Email(null));
        assertEquals("Email address cannot be null", exception.getMessage());
    }
}