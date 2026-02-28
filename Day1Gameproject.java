import java.util.*;
public class Day1Gameproject {
    public static void main(String[] args) {
        Scanner sc=new Scanner (System.in);
        System.out.println("enter first player name");
        String s1=sc.nextLine();
        System.out.println("enter second player name");
        String s2=sc.nextLine();
        int player1d=(int)(Math.random()*6)+1;
        int player2d=(int)(Math.random()*6)+1;
        System.out.println("dice rolled from player 1" + s1 + ":" +player1d);
        System.out.println("dice rolled from player 2"  + s2 + ":" +player2d);
        if(player1d>player2d){
            System.out.println(s1 + "wins");
        }
       else if(player2d>player1d){
            System.out.println(s2 + "wins");
        } else{
            System.out.println("draw");
        }

    }
}
