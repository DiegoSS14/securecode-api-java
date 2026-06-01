package com.security.code.securecode.domain.valueObjects;

import java.util.UUID;

import com.security.code.securecode.infra.exception.PatternException;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class Id {
    @EqualsAndHashCode.Include
    private String value;

    public Id() {
        this.value = UUID.randomUUID().toString();
    }

    public Id(UUID id) {
        this.value = id.toString();
    }
    
    public Id(String value) {
        try{
            UUID id = UUID.fromString(value);
            this.value = id.toString();
        } catch(Exception e) {
            throw new PatternException("Invalid id");
        }
    }
    
    public static String generate() {
        return UUID.randomUUID().toString();
    }
    
    public static boolean equals(String id1, String id2) {
        return id1.equals(id2);
    }
}
