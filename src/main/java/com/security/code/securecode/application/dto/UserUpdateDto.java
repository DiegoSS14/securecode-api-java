package com.security.code.securecode.application.dto;

import com.security.code.securecode.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateDto {
    private String name;
    private String email;
    private String password;

    public UserUpdateDto(User user) {
        this(
            user.getName().getValue(), 
            user.getEmail().getValue(), 
            user.getPassword().getValue()
        );
    }
}
