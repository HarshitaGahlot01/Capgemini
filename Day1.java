import java.lang.reflect.Array;
import java.util.*;
public class Day1 {
    public static void main(String[] args) {
        Collection<String> a=new ArrayList<>();
        a.add("apple");
        a.add("mango");
        a.add("banana");
        a.add("lichi");
        a.add("onion");
        System.out.println(a);
        a.remove("banana");
        System.out.println(a);
        System.out.println(a.contains("banana"));
        System.out.println(a.size());
        System.out.println(a.containsAll(a));
//        a.removeAll(a);
//        System.out.println(a);
//
    }
}

