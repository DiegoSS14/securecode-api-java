package com.security.code.securecode.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class EmailTest {
    @Test
    public void deveCriarUmEmailValido() {
        Email email = new Email("valid@example.com");
        assertNotNull(email.getValue());
    }

    @Test
    public void deveLancarExcecaoParaEmailVazio() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertEquals("Email address cannot be empty", exception.getMessage());
    }

    @Test
    public void deveLancarExcecaoParaEmailNulo() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> new Email(null));
        assertEquals("Email address cannot be null", exception.getMessage());
    }
}