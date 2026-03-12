package com.gal.algo;

import org.springframework.stereotype.Component;

@Component
public class PassWordHasher {

    public String hash(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    public PassWordHasher() {
System.out.println("PassWord Hashed");
    }
    
}
