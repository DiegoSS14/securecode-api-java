package com.security.code.securecode.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserUpdateDto {
    String name;
    String email;
    String password;
}
