//import java.util.*;
//public class Day3Reversepolishnotation {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("enter no of time");
//        int n=sc.nextInt();
//        sc.nextLine();
//        for(int i=0;i<n;i++){
//            System.out.println("enter string");
//            String infix=sc.nextLine();
//        Stack<Character> st = new Stack<>();
//        String postfix = "";
//        for (char ch : infix.toCharArray()) {
//            if (ch >= 'a' && ch <= 'z') {
//                postfix += ch;
//            }
//            else if (ch == '(') {
//                st.push(ch);
//            }
//            else if (ch == ')') {
//                while (st.peek() != '(') {
//                    postfix += st.pop();
//                }
//                st.pop();
//            }
//            else {
//                while (!st.isEmpty() && st.peek() != '(') {
//                    postfix += st.pop();
//                }
//                st.push(ch);
//            }
//        }
//        while (!st.isEmpty()) {
//            postfix += st.pop();
//        }
//        System.out.println(postfix);
//    }
//}}
