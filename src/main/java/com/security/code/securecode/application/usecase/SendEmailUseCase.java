package com.security.code.securecode.application.usecase;

import com.security.code.securecode.domain.entities.SecurityCode;
import com.security.code.securecode.domain.valueObjects.Email;

public class SendEmailUseCase {
    private Email email;
    private SecurityCode code;

    public SendEmailUseCase(String email) {
        this.email = new Email(email);
        this.code = new SecurityCode();
    }

    public String execute() {
        return this.code.getCode();
    }
}
