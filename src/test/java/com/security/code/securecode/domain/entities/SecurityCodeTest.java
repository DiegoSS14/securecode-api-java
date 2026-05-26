package com.security.code.securecode.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SecurityCodeTest {
    @Test
    public void testGenerateCode() {
        String code = SecurityCode.generateCode();
        assertEquals(5, code.length());
    }
    
    @Test
    public void testGenerateAttrubutes() {
        SecurityCode code = new SecurityCode();
        assertNotNull(code.getCode());
        assertNotNull(code.getCreatedAt());
        assertNotNull(code.getExpiresIn());
        assertNotNull(code.getId());
        System.out.println(code);
    }
}
