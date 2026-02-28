package com.hh;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Sumofsquaredigits {
    public static int findCount(int n) {

        Set<Integer> visited = new HashSet<>();
        int original = n;
        int count = 0;
        while (true) {
            int sum = 0;
            int temp = n;
            while (temp != 0) {
                int rem = temp % 10;
                sum += rem * rem;
                temp /= 10;
            }

            count++;
            if (sum == original) {
                return count;
            }
            if (sum == 1 || visited.contains(sum)) {
                return -1;
            }

            visited.add(sum);
            n = sum;
        }
    }

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number:");
        int n = sc.nextInt();

        int result = Sumofsquaredigits.findCount(n);

        System.out.println(result);
    }
}
}
	

