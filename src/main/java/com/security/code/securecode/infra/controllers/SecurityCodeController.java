package com.security.code.securecode.infra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SecurityCodeController {
    
    @GetMapping("/")
    public String getMethodName() {
        return "Hello World";
    }
}
