import java.util.Scanner;

public class Readinfo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter Roll no ");
        int roll=sc.nextInt();
        sc.nextLine();
        System.out.println("enter Name");
        String name=sc.next();
        System.out.println("Information:");
        System.out.println("Roll:" + roll);
        System.out.println("Name:"+name);
        sc.close();
    }
}
