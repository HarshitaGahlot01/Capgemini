import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Sumofsquaredigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Set<Integer> s=new HashSet<>();
        System.out.println("enter n");
        int n=sc.nextInt();
        int sum=0;
        int orig=n;
        int temp=n;
        int count=0;
        while(true){
            temp=n;
            sum=0;
            while(temp!=0){
                int rem=temp%10;
                sum=sum+rem*rem;
                temp=temp/10;
            }
            count++;
            if(sum==orig){
                System.out.println(count);
                break;
            }
            if(sum==1 || s.contains(sum)){
                System.out.println(-1);
                break;
            }
            s.add(sum);
            n=sum;

        }
    }
}
