package com.security.code.securecode.domain.valueObjects;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
public class Name {
    private String value;

    public Name(String value) {
        this.value = value;
    }
}
