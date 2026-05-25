package com.security.code.securecode.domain.model;

import com.security.code.securecode.domain.exception.DomainException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String value = null;

    public Email(String value) {
        if (value == null) throw new DomainException("Email address cannot be null");
        if (value.isEmpty()) throw new DomainException("Email address cannot be empty");
        if (!Email.isValid(value)) throw new DomainException("Invalid email address");
        this.value = value;
    }

    public static boolean isValid(String value) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return value.matches(regex);
    }
}
