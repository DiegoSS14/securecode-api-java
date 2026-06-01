package com.security.code.securecode.domain.valueObjects;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Getter
public class Name {
    private String value;

    public Name(String value) {
        this.value = value;
    }
}
