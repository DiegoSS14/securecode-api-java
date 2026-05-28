package com.security.code.securecode.infra.db.mapper;

import com.security.code.securecode.domain.model.SecurityCode;
import com.security.code.securecode.domain.valueObjects.Email;
import com.security.code.securecode.infra.db.jpa.SecurityCodeEntity;

public class SecurityCodeMapper {
    public SecurityCodeEntity toEntity(SecurityCode model) {
        SecurityCodeEntity entity = SecurityCodeEntity.builder()
            .code(model.getCode())
            .id(model.getId())
            .email(model.getEmail().getValue())
            .createdAt(model.getCreatedAt())
            .expiresIn(model.getExpiresIn())
            .build();
        return entity;
    }

    public SecurityCode toModel(SecurityCodeEntity entity) {
        SecurityCode model = SecurityCode.builder()
            .code(entity.getCode())
            .id(entity.getId())
            .email(new Email(entity.getEmail()))
            .createdAt(entity.getCreatedAt())
            .expiresIn(entity.getExpiresIn())
            .build();
        return model;
    }
}
