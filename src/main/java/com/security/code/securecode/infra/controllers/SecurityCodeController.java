package com.security.code.securecode.infra.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("code")
public class SecurityCodeController {
    
    @GetMapping
    public String getMethodName() {
        return "Hello World";
    }

    // @GetMapping("/sendcode")
    // public String getMethodName(@RequestBody @Valid UserDto userDto) {
        
    // }
    
}
