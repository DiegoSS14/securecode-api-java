package com.security.code.securecode.model;

import java.util.Random;
import java.util.stream.Collectors;

public class Code {

    public static String generateCode() {
        Random generator = new Random();
        String code = "";

        code += generator.ints(5, 0, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return code;
    }
}
