package com.security.code.securecode.application.service;

import com.security.code.securecode.domain.model.SecurityCode;

public class SendEmailUsecase {
    private SecurityCode code;

    public SendEmailUsecase(String email) {
        this.code = new SecurityCode("email.test@gmail.com");
    }

    public String execute() {
        return this.code.getCode();
    }
}
