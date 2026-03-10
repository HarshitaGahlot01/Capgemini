import java.util.*;
public class Goodnumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n");
        Set<Integer> s=new HashSet<>();
        int n=sc.nextInt();
        int sum=0;
        int temp=n;
        int or=n;
        while(true){
            temp=n;
            sum=0;
            while(temp!=0){
                int rem=temp%10;
                sum=sum+rem*rem;
                temp=temp/10;
            }
            if(sum==1){
                System.out.println("Good number");
                break;
            }
            if(sum==or || s.contains(sum)){
                System.out.println("not good number");
                break;
            }
            s.add(sum);
            n=sum;
        }

    }
}
