package com.gal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gal.model.Printer;

public class Main{

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.gal");

        Printer printer = context.getBean(Printer.class);

        printer.printResult();

        context.close();
    }
}