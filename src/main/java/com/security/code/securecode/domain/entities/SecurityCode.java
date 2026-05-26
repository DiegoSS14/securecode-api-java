package com.security.code.securecode.domain.entities;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class SecurityCode {
    private UUID id;
    private String code;
    private LocalDateTime createdAt;
    private LocalDateTime expiresIn;

    public SecurityCode() {
        this.id = UUID.randomUUID();
        this.code = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(20);
    }

    public static String generateCode() {
        Random generator = new Random();
        String code = "";
        code += generator.ints(5, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return code;
    }

    public static boolean equals(String code1, String code2) {
        return code1.equals(code2);
    }
}
