import java.util.*;
public class NonDecreasingel {
    public static void main(String[] args) {
        int arr[]={7,3,5,2};
        int x=0;
        for(int i=0;i<arr.length-1;i++) {
            if (arr[i] > arr[i + 1]) {
                int d = arr[i] - arr[i + 1];
                x = Math.max(d, x);
            }
        }
            System.out.println("minimum count"+x);
        }
    }

