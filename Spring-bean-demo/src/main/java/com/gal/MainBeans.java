package com.gal;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gal.algo.Calc;
import com.gal.algo.PassWordHasher;
import com.gal.algo.UserVerifier;

public class MainBeans {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.gal");
        context.refresh();

        PassWordHasher bean = context.getBean(PassWordHasher.class);
        PassWordHasher bean1 = context.getBean(PassWordHasher.class);

        System.out.println(bean);
        System.out.println(bean1);
        System.out.println(bean.hash("hello"));

        StringBuilder bean3 = context.getBean(StringBuilder.class);
        System.out.println(bean3);

        Calc bean4n = context.getBean(Calc.class);
        int sum = bean4n.add(10, 20);
        System.out.println(sum);

        String[] bean5 = context.getBeanDefinitionNames();
        for (String name : bean5) {
            System.out.println(name);
        }

        DataSource ds = context.getBean(DataSource.class);
        System.out.println(ds);
     // ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("beans.xml");
        // xml.refresh(); 
        // StringBuilder bean6 = xml.getBean(StringBuilder.class); 
        // System.out.println(bean6); // // //create an object of Datasource and inject into the string context } }
        // close container at the end
        UserVerifier verifier = context.getBean(UserVerifier.class);
        verifier.verifyUser();
       
        context.close();
    }
}