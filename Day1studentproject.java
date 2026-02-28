import java.lang.reflect.Array;
import java.util.*;
public class Day1studentproject {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> student=new ArrayList<>();
        System.out.println("enter the no of students");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter name");
            student.add(sc.next());
        }
        System.out.println("after add  printing");
        for(String s:student){
            System.out.println(s);
        }
        System.out.println("enter name to delete");
        String name= sc.next();
        student.remove(name);
        System.out.println("print after delete");
        for (String s : student) {
            System.out.println(s);
        }
        System.out.println("enter to update");
        int i= sc.nextInt();
        System.out.println("enter name");
        String s1=sc.next();
        student.set(i, s1);

        System.out.println("After Updating Student:");
        for (String s : student) {
            System.out.println(s);
        }



    }
}
