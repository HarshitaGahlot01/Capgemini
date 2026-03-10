import java.util.Scanner;
//public class MappedDigitSubstring {
//    public static int map(char ch){
//        if(ch=='a'||ch=='b') return 1;
//        if(ch=='c'||ch=='d'||ch=='e') return 2;
//        if(ch=='f'||ch=='g'||ch=='h') return 3;
//        if(ch=='i'||ch=='j'||ch=='k') return 4;
//        if(ch=='l'||ch=='m'||ch=='n') return 5;
//        if(ch=='o'||ch=='p'||ch=='q') return 6;
//        if(ch=='r'||ch=='s'||ch=='t') return 7;
//        if(ch=='u'||ch=='v'||ch=='w') return 8;
//
//        return 9; // x y z
//    }
//    public static int countSubstring(String s){
//        int c=0;
//        for(int i=0;i<s.length();i++){
//            int sum=0;
//            for(int j=i;j<s.length();j++){
//                sum=sum+map(s.charAt(j));
//                int l=j-i+1;
//                if(sum%l==0){
//                    c++;
//                }
//            }
//        }
//        return c;}
//            public static void main(String[] args) {
//                Scanner sc=new Scanner(System.in);
//                String s=sc.nextLine();
//                System.out.println(countSubstring(s));
//            }}
//



// next method





public class MappedDigitSubstring{
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String s = sc.next();
                int[] map = new int[26];
                String[] groups = {
                        "ab","cde","fgh","ijk","lmn","opq","rst","uvw","xyz"
                };
                for(int i = 0; i < groups.length; i++){
                    for(char c : groups[i].toCharArray()){
                        map[c - 'a'] = i + 1;
                    }
                }
                int n = s.length();
                int count = 0;
                for(int i = 0; i < n; i++){
                    int sum = 0;
                    for(int j = i; j < n; j++){
                        sum += map[s.charAt(j) - 'a'];
                        int len = j - i + 1;

                        if(sum % len == 0){
                            count++;
                        }
                    }
                }
                System.out.println(count);

                sc.close();
            }}



