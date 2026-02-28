public class oddmaxvalue {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i%2!=0){
                if(max<arr[i]){
                    max=arr[i];
                }
            }
        }
        System.out.println(max);
    }
}
