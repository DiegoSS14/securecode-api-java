package com.security.code.securecode.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.security.code.securecode.application.service.SendEmailUsecase;

public class SendEmailUseCaseTest {
    
    @Test
    public void testExecute() {
        SendEmailUsecase useCase = new SendEmailUsecase("test@example.com");
        assertEquals(5, useCase.execute().length());
    }
}
