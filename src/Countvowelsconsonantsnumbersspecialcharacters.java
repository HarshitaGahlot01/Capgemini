import java.util.*;
public class Countvowelsconsonantsnumbersspecialcharacters {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int cv=0;
        int cc=0;
        int d=0;
        int ss=0;
        System.out.println("Enter String");
        String s=sc.nextLine();
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='a' && c<='z'){
            if(c=='a' || c=='i' || c=='e' || c=='o' || c=='u'){
                cv++;
            }

        else
            cc++;
            }


            else if(c>='0' && c<='9'){
                d++;
            }
            else{
                ss++;
            }
    }
        System.out.println(cv);
        System.out.println(cc);
        System.out.println(d);
        System.out.println(ss);
}}
