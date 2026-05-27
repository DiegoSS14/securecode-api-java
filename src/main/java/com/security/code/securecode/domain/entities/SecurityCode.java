package com.security.code.securecode.domain.entities;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import com.security.code.securecode.domain.valueObjects.Email;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "security_code")
public class SecurityCode {
    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String code;
    private Email email;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "expires_in")
    private LocalDateTime expiresIn;

    public SecurityCode(String email, int expiresInMinutes) {
        this.email = new Email(email);
        this.id = UUID.randomUUID();
        this.code = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(expiresInMinutes);
    }

    public SecurityCode(String email) {
        this.email = new Email(email);
        this.id = UUID.randomUUID();
        this.code = SecurityCode.generateCode();
        this.createdAt = LocalDateTime.now();
        this.expiresIn = this.createdAt.plusMinutes(15);
    }

    public boolean isValid() {
        LocalDateTime now = LocalDateTime.now();
        return now.isBefore(this.expiresIn);
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
