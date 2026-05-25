package com.security.code.securecode.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CodeTest {
    @Test
    public void testGenerateCode() {
        String code = Code.generateCode();
        assertEquals(5, code.length());
    }
}
