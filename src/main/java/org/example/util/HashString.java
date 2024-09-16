package org.example.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashString {

    public String getHashString(String input){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b: hashBytes){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorith not found",e);
        }
    }
}
