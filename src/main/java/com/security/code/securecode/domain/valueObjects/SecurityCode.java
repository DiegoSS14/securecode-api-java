package com.security.code.securecode.domain.valueObjects;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@Builder
public class SecurityCode {
    @EqualsAndHashCode.Include
    private String value;
    private LocalDateTime createdAt;
    private LocalDateTime expiresIn;
    private int attempt;
    private int maxAttempt;

    public SecurityCode(int expiresInMinutes) {
        this.value = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(expiresInMinutes);
        this.maxAttempt = 3;
    }
    
    public SecurityCode(int expiresInMinutes, int maxAttempt) {
        this.value = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(expiresInMinutes);
        this.maxAttempt = maxAttempt;
    }
    
    public SecurityCode() {
        this.value = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(10);
        this.maxAttempt = 3;
    }

    public boolean isValid() {
        LocalDateTime now = LocalDateTime.now();
        return now.isBefore(this.expiresIn) && attempt < maxAttempt;
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

    public static boolean equals(SecurityCode code1, SecurityCode code2) {
        return code1.equals(code2);
    }
}
