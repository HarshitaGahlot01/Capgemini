import java.util.*;
public class LoweCase {
    public static void main(String[] args) {
        String s="This is java lang";
         String res="";
         String w[]=s.split(" ");
         for(int i=0;i<w.length;i++){
        res=res+Character.toUpperCase(w[i].charAt(0)) + w[i].substring(1) + "";
       }
        System.out.println(res);
       }}
