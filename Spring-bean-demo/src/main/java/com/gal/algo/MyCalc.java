package com.gal.algo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;



public class MyCalc implements Calc {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @PostConstruct
    public void onInit() {
        System.out.println("MyCalc is initializing...");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("MyCalc is being destroyed...");
    }
}