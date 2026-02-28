import java.util.*;
public class Student {
    public static void change(int x){
        x=7;
        return;
    }

    public static void main(String[] args) {
        int x=5;
        System.out.println(x);
        change(x);
        System.out.println(x);
    }
}
