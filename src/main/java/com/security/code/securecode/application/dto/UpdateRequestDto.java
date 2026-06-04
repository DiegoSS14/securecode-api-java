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
public class UpdateRequestDto {
    private String name;
    private String email;
    private String password;
    private String code;

    public UpdateRequestDto(User user) {
        this(
            user.getName().getValue(),
            user.getEmail().getValue(),
            user.getPassword().getValue(),
            user.getCode().getValue()
        );
    }
}
