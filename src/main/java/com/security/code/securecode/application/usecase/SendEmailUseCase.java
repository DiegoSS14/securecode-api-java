package com.security.code.securecode.application.usecase;

import com.security.code.securecode.domain.model.SecurityCode;

public class SendEmailUseCase {
    private SecurityCode code;

    public SendEmailUseCase(String email) {
        this.code = new SecurityCode("email.test@gmail.com");
    }

    public String execute() {
        return this.code.getCode();
    }
}
