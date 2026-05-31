package com.security.code.securecode.application.dto;

import com.security.code.securecode.infra.db.jpa.UserEntity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    public UserDto(UserEntity user) {
        this(user.getName(), user.getEmail(), user.getPassword());
    }

    @NotNull
    @NotBlank
    @Size(min = 4, max = 120)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 60)
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
