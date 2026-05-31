package com.security.code.securecode.domain.valueObjects;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

import com.security.code.securecode.infra.exception.PatternException;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Password {
    @EqualsAndHashCode.Include
    private String value;

    public Password(String value) {
        try {
            hash(value);
        } catch (Exception e) {
            throw new PatternException("Invalid hash password");
        }
        this.value = value;
    }

    public String hash(String value) throws NoSuchAlgorithmException  {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(value.getBytes()); 
        return HexFormat.of().formatHex(hashBytes);
    }

    public boolean compare(String password, String hashDB) {
        try{
            String passwordDigit = hash(password);
            return passwordDigit.equals(hashDB);
        } catch(Exception e) {
            throw new PatternException("Invalid email or password");
        }
    }
}
