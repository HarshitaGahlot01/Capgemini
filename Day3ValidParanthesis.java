import java.util.*;
public class Day3ValidParanthesis {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter string");
        String s=sc.nextLine();
        int count=0;
        boolean isValid=true;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='(') {
                count++;
            } else if(c==')'){
                count--;
        if(count<0){
            isValid=false;
            break;
        }

    }
}
        if(count!=0){
            isValid=false;
        }
        if(isValid){
            System.out.println("true");
        } else{
            System.out.println("false");
        }}}
