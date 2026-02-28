public class minvalueevenindex {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                if(min>arr[i]){
                    min=arr[i];
                }
            }}
            System.out.println(min);
        }
    }

