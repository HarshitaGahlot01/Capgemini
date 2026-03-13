package com.gal.model;
import org.springframework.stereotype.Component;

@Component
public class DirectoryPath {

    private String dir = "C:/Users/harsh/eclipse-workspace";

    public String getDir() {
        return dir;
    }
}