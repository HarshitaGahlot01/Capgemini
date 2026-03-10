import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class EchoWeaveEncryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Character, Integer> h = new LinkedHashMap<>();
        String eveng = "";
        String oddg = "";
        String res="";
        System.out.println("enter the string");
        String s = sc.nextLine();
        String regex = "^[a-zA-Z]+$";
        if (!s.matches(regex)) {
            System.out.println("invalid input");
        } else {
            s = s.toUpperCase();
            for (char ch : s.toCharArray()) {
                if (h.containsKey(ch)) {
                    h.put(ch, h.get(ch) + 1);
                } else {
                    h.put(ch, 1);
                }
            }
            for (Map.Entry<Character, Integer> e : h.entrySet()) {
                char ch = e.getKey();
                int freq = e.getValue();
                if (freq % 2 == 0) {
                    eveng = eveng + ch;
                } else {
                    oddg = oddg + ch;
                }


            }
            res=res+eveng+oddg;
           for(char ch:h.keySet()){
               int remfre=h.get(ch)-1;
               for(int i=0;i<remfre;i++){
                   res=res+ch;
               }
            }
           int scount=0;
           int len=res.length();
           for(char ch:h.keySet()){
               if(h.get(ch)==1){
                   scount++;
               }
           }
           if(scount<=0){
               System.out.println(res);
           } else if(len%2==0){
               int ind=(len/2)-1;
               res=res.substring(0,ind+1) + scount + res.substring(ind+1);
               System.out.println(res);
           } else {
               int ind = len / 2;
               res = res.substring(0, ind + 1) + scount + res.substring(ind + 1);
               System.out.println(res);
           }

        }
    }}
