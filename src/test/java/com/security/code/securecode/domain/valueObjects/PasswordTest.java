package com.security.code.securecode.domain.valueObjects;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PasswordTest {
    @Test
    void deveCriarUmaSenhaHash() {
        Password password = new Password("12345");
        assertNotEquals("12345", password.getValue());
    }
}
