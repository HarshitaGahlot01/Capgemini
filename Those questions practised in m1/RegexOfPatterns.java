import java.util.Scanner;

public class RegexOfPatterns {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter String");
        String s=sc.nextLine();
        String regex="^(?=.*[aeiouAEIOU])(?=.*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])[a-zA-Z0-9]{3,}$";
     String w[]=s.split("\\s+");
     int count=0;
     for(String wo:w){
         if(wo.matches(regex)){
             count++;
         }
     }
        System.out.println(count);
      }}
