import java.util.*;
public class Hackerrank {
    public static void main(String[] args) {
        int pre = 0;
        int cur = 1;
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter s");
        String s = sc.nextLine();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                c = c + Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        c = c + Math.min(pre, cur);

        System.out.println(c);
    }
}
