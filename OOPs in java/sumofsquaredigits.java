import java.util.*;
public class sumofsquaredigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n");
        int n = sc.nextInt();
        int count = 0;
        int o=n;
        int sum=0;
        int temp = n;
        Set<Integer> s=new HashSet<>();
       while(true) {
           temp = n;
           sum = 0;
           while (temp != 0) {
               int rem = temp % 10;
               sum = sum + rem * rem;
               temp = temp / 10;
           }
           count++;
           if (sum == o) {
               System.out.println(count);
               break;
           }
           if (sum == 1 || s.contains(sum)) {
               System.out.println(-1);
               break;
           }
           s.add(sum);
           n = sum;
       }
}}