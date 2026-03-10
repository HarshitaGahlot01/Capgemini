import java.util.*;
public class MagicArry{
    public static void main(String[] args) {
        int arr[]={2,3,4,5,6,7,8,9};
        int sumev=0;
        int sumod=0;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                sumev=sumev+arr[i];
            } else{
                sumod=sumod+arr[i];
            }
        }
        if(sumev==sumod){
            System.out.println("Magic Array");
        }
        else{
            System.out.println("not magic Array");
        }
    }
}
