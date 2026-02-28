import java.util.*;
public class Task2 {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>();
        l.add(12);
        l.add(45);
        l.add(3);
        l.add(89);
        l.add(23);
        System.out.println(l);
        Collections.sort(l);
        System.out.println(l);
    }
}
