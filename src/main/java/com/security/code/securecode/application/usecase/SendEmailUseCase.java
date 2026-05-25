package com.security.code.securecode.application.usecase;

import com.security.code.securecode.domain.model.Code;
import com.security.code.securecode.domain.model.Email;

public class SendEmailUseCase {
    private Email email;
    private Code code;

    public SendEmailUseCase(String email) {
        this.email = new Email(email);
        this.code = new Code();
    }

    public String execute() {
        return this.code.getValue();
    }
}
