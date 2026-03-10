import java.util.*;
public class LanguageModel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String s=sc.nextLine().trim();
        String regex="^[a-zA-Z ]+$";
        if(!s.matches(regex)){
            System.out.println("Invalid sentence");
            return ;
        }
        String words[]=s.split(" ");
        String res="";
        int count=words.length;
        System.out.println(" count:"+count);
        if(count%2==0){
            for(int i=count-1;i>=0;i--){
                res=res+words[i]+" ";
            } } else
             {
               for(int i=0;i<count;i++){
                   String rev="";
                   for(int j=words[i].length()-1;j>=0;j--){
                       rev=rev+words[i].charAt(j);
                   }
                   res=res+rev+" ";
               }
                }
            System.out.println(res);
            }
        }


