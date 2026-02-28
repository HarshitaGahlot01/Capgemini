package com.stream;

import java.util.HashMap;

public class User extends HashMap<String,String> {

    public User(String username, String password) {
        this.put(username, password);
    }

    @Override
    public String put(String username, String password) {

        if (containsKey(username)) {
            throw new UsernameExistsException(username);
        }

        return super.put(username, password);
    }
}