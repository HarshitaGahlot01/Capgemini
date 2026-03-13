package com.gal.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Printer {

    @Autowired
    private WordCounter wordCounter;

    public void printResult() {

        Map<String, Integer> result = wordCounter.countSystemWord();

        for (String file : result.keySet()) {
            System.out.println(file + " -> " + result.get(file));
        }
    }
}
