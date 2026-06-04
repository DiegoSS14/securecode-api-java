package com.security.code.securecode.domain.model;

import com.security.code.securecode.application.dto.UserDto;
import com.security.code.securecode.application.dto.UpdateRequestDto;
import com.security.code.securecode.domain.valueObjects.Email;
import com.security.code.securecode.domain.valueObjects.Id;
import com.security.code.securecode.domain.valueObjects.Name;
import com.security.code.securecode.domain.valueObjects.Password;
import com.security.code.securecode.domain.valueObjects.SecurityCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Id id;
    private Name name;
    private Email email;
    private Password password;
    private SecurityCode code;

    public User(UserDto user) {
        this(
            new Id(),
            new Name(user.getName()),
            new Email(user.getEmail()),
            new Password(user.getPassword()),
            null
        );
    }

    public User(UpdateRequestDto user) {
        this(
            new Id(),
            new Name(user.getName()),
            new Email(user.getEmail()),
            new Password(user.getPassword()),
            null
        );
    }
}
