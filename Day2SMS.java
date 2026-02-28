import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Student {
    String username;
    String password;
    int totalsemmarks;
    boolean pdfopenendornot;
    boolean marksGenerated;
    public Student(String username, String password) {
        this.username = username;
        this.password = password;
        this.totalsemmarks = 0;
        this.pdfopenendornot = false;
        this.marksGenerated = false;
    }
}
public class Day2SMS {
    static ArrayList<Student> a = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    public static void main(String[] args) {
        while (true) {
            System.out.println("menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. PDF Open");
            System.out.println("4. Get Marks");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    pdfopen();
                    break;
                case 4:
                    getmarks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    static void register() {
        System.out.print("Enter username: ");
        String u = sc.next();
        System.out.print("Enter password: ");
        String p = sc.next();

        a.add(new Student(u, p));
        System.out.println("Registration done");
    }
    static void login() {
        System.out.print("Enter username: ");
        String name = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();
        for (Student s : a) {
            if (s.username.equals(name) && s.password.equals(pass)) {
                System.out.println("Login done");
                return;
            }
        }
        System.out.println("Invalid login");
    }
    static void pdfopen() {
        System.out.print("Enter username: ");
        String name = sc.next();
        for (Student s : a) {
            if (s.username.equals(name)) {
                s.pdfopenendornot = true;
                System.out.println("PDF marked as opened");
                return;
            }
        }
        System.out.println("Student not found");
    }
    static void getmarks() {
        System.out.print("Enter username: ");
        String name = sc.next();
        for (Student s : a) {
            if (s.username.equals(name)) {
                if (s.marksGenerated) {
                    System.out.println("Marks already generated: " + s.totalsemmarks);
                    return;
                }
                System.out.print("Enter number of semesters: ");
                int sem = sc.nextInt();
                int total = 0;
                for (int i = 1; i <= sem; i++) {
                    int m = ran.nextInt(101);
                    System.out.println("Semester " + i + " marks: " + m);
                    total += m;
                }
                s.totalsemmarks = total;
                s.marksGenerated = true;
                System.out.println("Total marks: " + total);
                return;
            }
        }
        System.out.println("Student not found");
    }
}
