package com.stream;

public class UsernameExistsException extends RuntimeException{
	 public UsernameExistsException(String username) {
	        super("Username already exists: " + username);
	    }
	}


