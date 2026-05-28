package com.security.code.securecode.infra.db.jpa;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "security_code")
public class SecurityCodeEntity {
    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private String code;
    private String email;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "expires_in")
    private LocalDateTime expiresIn;
}
