public class Average {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int sum=0;
        int avg=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            avg=sum/arr.length;
        }
        System.out.println(avg);
    }
}
