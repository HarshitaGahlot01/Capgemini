import java.util.*;
public class List1 {
    public static void main(String[] args) {
       List<String> s=new ArrayList<>();
       s.add("row");
       s.add("column");
       for(String s1:s){
           System.out.println(s1);

       }
       List<List<String>> t=new ArrayList<>();
       t.add(s);
        System.out.println(t.get(0).get(1));
        System.out.println(s.get(0));
    }
}
