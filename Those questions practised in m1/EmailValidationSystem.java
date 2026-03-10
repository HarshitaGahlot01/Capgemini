import java.util.*;
public class EmailValidationSystem {
    public static String validateEmail(String email) {
        String regex =
                "^[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}@(hr|it|finance|admin)\\.company\\.com$";
        if (email.matches(regex))
            return "VALID";
        else
            return "INVALID";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        for(int i = 0; i < n; i++) {
            System.out.println("Enter email:");
            String email = sc.nextLine().trim();
            System.out.println(validateEmail(email));
        }
        sc.close();
    }
}