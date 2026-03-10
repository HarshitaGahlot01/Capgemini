import java.util.*;
public class PassWordGeneration {
    public static void main(String[] args) {
        String s="Harshita";
        String regex="^[A-Z]{4}@(10[1-9]|11[0-5])$";
        if(!s.matches(regex)){
            System.out.println("invalid username");
        } else {
            s=s.toLowerCase();
            String s2="TECH_";
            String w[]=s.split("@");
            String dept=w[0];
            String course=w[1];
            int sum=0;
            char ch[]=dept.toCharArray();
            for(char c:ch){
                sum=sum+(int)c;
            }
            String cc=course.substring(1);
            System.out.println("generated password is"+ s2 + sum + cc);
        }

    }
}
