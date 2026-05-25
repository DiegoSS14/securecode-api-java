package com.security.code.securecode.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SendEmailUseCaseTest {
    
    @Test
    public void testExecute() {
        SendEmailUseCase useCase = new SendEmailUseCase("test@example.com");
        assertEquals(5, useCase.execute().length());
    }
}
