package com.security.code.securecode.domain.model;

import java.util.Random;
import java.util.stream.Collectors;

import lombok.Getter;

@Getter
public class Code {
    private String value;

    public Code() {
        this.value = Code.generateCode();
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
