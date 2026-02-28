package com.hh;

public class StringAlgo {

    // shift first 2 characters to end
    String shift2Char(String s) {
        return s.substring(2) + s.substring(0, 2);
    }

    public static void main(String[] args) {
        StringAlgo obj = new StringAlgo();
        System.out.println(obj.shift2Char("Hello"));
    }

    // dummy DB method
    public String getFromDB() {
        return "From db value received";
    }
}