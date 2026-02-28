
import java.util.*;
public class transpose {
    public static void main(String[] args) {


    Scanner sc=new Scanner(System.in);
    System.out.println("Enter r");
    int r=sc.nextInt();
        System.out.println("Enter c");
        int c=sc.nextInt();
    int a[][]=new int[r][c];
    for( int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            a[i][j]=sc.nextInt();
        }
    }
        System.out.println("original matrix");
    for(int i=0;i<r;i++){
        for(int j=0;j<c;j++){
            System.out.print(a[i][j]+" ");
        }
        System.out.println();
    }
        System.out.println("Transpose");
    for(int i=0;i<c;i++){
        for(int j=0;j<r;j++){

            System.out.print(a[j][i]+" ");
        }

        System.out.println();
    }


}}
