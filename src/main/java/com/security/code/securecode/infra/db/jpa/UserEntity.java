package com.security.code.securecode.infra.db.jpa;

import com.security.code.securecode.domain.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    public UserEntity(User user) {
        this(
            user.getId().getValue(), 
            user.getName().getValue(), 
            user.getEmail().getValue(), 
            user.getPassword().getValue()
        );
    }
}
