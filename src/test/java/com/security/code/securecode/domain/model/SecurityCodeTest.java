package com.security.code.securecode.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.security.code.securecode.domain.valueObjects.SecurityCode;

public class SecurityCodeTest {
    @Test
    public void deveGerarUmCodigoDeSeguranca() {
        String code = SecurityCode.generateCode();
        assertEquals(5, code.length());
    }
    
    @Test
    public void deveGerarOsAtributos() {
        SecurityCode code;

        try (MockedStatic<SecurityCode> securityCodeMock = Mockito.mockStatic(SecurityCode.class)) {
            securityCodeMock.when(SecurityCode::generateCode).thenReturn("12345");

            code = new SecurityCode();
        }

        assertNotNull(code.getValue());
        assertNotNull(code.getCreatedAt());
        assertNotNull(code.getExpiresIn());
        assertEquals(0, code.getAttempt());
        assertEquals(3, code.getMaxAttempt());
        System.out.println(code);
    }
    
    @Test
    public void deveCompararDoisCodigos() {
        SecurityCode code1;
        SecurityCode code2;

        try (MockedStatic<SecurityCode> securityCodeMock = Mockito.mockStatic(SecurityCode.class)) {
            securityCodeMock.when(SecurityCode::generateCode).thenReturn("12345", "54321");

            code1 = new SecurityCode();
            code2 = new SecurityCode();
        }
        
        assertFalse(SecurityCode.equals(code1, code2));
        assertTrue(SecurityCode.equals(code1, code1));
    }
    
    @Test
    public void deveVerificarSeOcodigoEvalido() {
        LocalDateTime meioDia = LocalDateTime.of(2026, 5, 26, 12, 0);

        SecurityCode code;
        try (MockedStatic<LocalDateTime> oRelogioDoJava = Mockito.mockStatic(LocalDateTime.class)) {
            oRelogioDoJava.when(LocalDateTime::now).thenReturn(meioDia);
            
            try (MockedStatic<SecurityCode> securityCodeMock = Mockito.mockStatic(SecurityCode.class)) {
                securityCodeMock.when(SecurityCode::generateCode).thenReturn("12345");

                code = new SecurityCode(20);
            }
            assertTrue(code.isValid());
        }
        LocalDateTime meioDiaEVinteEUm = LocalDateTime.of(2026, 5, 26, 12, 21);
        try (MockedStatic<LocalDateTime> oRelogioDoJava = Mockito.mockStatic(LocalDateTime.class)) {
            oRelogioDoJava.when(LocalDateTime::now).thenReturn(meioDiaEVinteEUm);

            assertFalse(code.isValid()); 
        }
    }
}
