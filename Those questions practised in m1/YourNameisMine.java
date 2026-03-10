import java.util.*;
public class YourNameisMine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter man name");
        String s1 = sc.nextLine().trim();
        System.out.println("enter woman name");
        String s2 = sc.nextLine().trim();
        int compatibility = 0;
        String regex = "^[a-zA-Z ]+$";
        if (!s1.matches(regex) && !s2.matches(regex)) {
            System.out.println("Both are invalid");
            return;
        } else if (!s1.matches(regex)) {
            System.out.println("man is invalid");
            return;
        } else if (!s2.matches(regex)) {
            System.out.println("woman is invalid");
            return;
        }
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("Both are Made for each other" + " " + "Compatibilty value" + " " + compatibility);
            return;
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        boolean made = false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
            }
            j++;
        }
        if (i == s1.length()) {
            made = true;
        }
        int k = 0, l = 0;
        while (k < s2.length() && l < s1.length()) {
            if (s2.charAt(k) == s1.charAt(l)) {
                k++;
            }
            l++;
        }
        if (k == s2.length()) {
            made = true;
        }
        if (made) {
            System.out.println(s1 + " and " + s2 + " are made for each other");
        } else {
            System.out.println(s1 + " and " + s2 + " are not made for each other");
            return;
        }
        String small;
        String big;

        if (s1.length() <= s2.length()) {
            small = s1;
            big = s2;
        } else {
            small = s2;
            big = s1;
        }
        int p = 0;
        int q = 0;
        int operations = 0;
        while (p < small.length() && q < big.length()) {
            char c1 = Character.toLowerCase(small.charAt(p));
            char c2 = Character.toLowerCase(big.charAt(q));

            if (c1 == c2) {
                p++;
            } else {
                operations++;
            }
            q++;
        }
        operations += (big.length() - q);
        System.out.println("Compatibility Value is " + operations);
    }
    }