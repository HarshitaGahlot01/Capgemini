import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.*;

public class Stringques1 {
    public static void main(String[] args) {
        String s="this is line. line contain few words. line is in Java";
        String regex="line";
        Pattern p= Pattern.compile(regex);
        Matcher m=p.matcher(s);
        while(m.find()){
            System.out.println(m.start());
        }
        }
    }