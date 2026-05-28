package com.security.code.securecode.domain.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import com.security.code.securecode.domain.model.SecurityCode;

public class SecurityCodeTest {
    @Test
    public void deveGerarUmCodigoDeSeguranca() {
        String code = SecurityCode.generateCode();
        assertEquals(5, code.length());
    }
    
    @Test
    public void deveGerarOsAtributos() {
        SecurityCode code = new SecurityCode("email.test@gmail.com");
        assertNotNull(code.getCode());
        assertNotNull(code.getCreatedAt());
        assertNotNull(code.getExpiresIn());
        assertNotNull(code.getId());
        System.out.println(code);
    }
    
    @Test
    public void deveCompararDoisCodigos() {
        SecurityCode code1 = new SecurityCode("email.test@gmail.com");
        SecurityCode code2 = new SecurityCode("email.test@gmail.com");
        
        assertFalse(SecurityCode.equals(code1, code2));
        assertTrue(SecurityCode.equals(code1, code1));
    }
    
    @Test
    public void deveVerificarSeOcodigoEvalido() {
        LocalDateTime meioDia = LocalDateTime.of(2026, 5, 26, 12, 0);

        SecurityCode code;
        try (MockedStatic<LocalDateTime> oRelogioDoJava = Mockito.mockStatic(LocalDateTime.class)) {
            oRelogioDoJava.when(LocalDateTime::now).thenReturn(meioDia);
            
            code = new SecurityCode("email.test@gmail.com", 20);
            assertTrue(code.isValid());
        }
        LocalDateTime meioDiaEVinteEUm = LocalDateTime.of(2026, 5, 26, 12, 21);
        try (MockedStatic<LocalDateTime> oRelogioDoJava = Mockito.mockStatic(LocalDateTime.class)) {
            oRelogioDoJava.when(LocalDateTime::now).thenReturn(meioDiaEVinteEUm);

            assertFalse(code.isValid()); 
        }
    }
}
