public class avgvalueevenodd {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int sum1=0;
        int sum2=0;
        int evenc=0;
        int oddc=0;
        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                sum1=sum1+arr[i];
                evenc++;
            } else{
                sum2=sum2+arr[i];
                oddc++;
            }
        }
        int avgeven=sum1/evenc;
        int avgodd=sum2/oddc;
        System.out.println(avgeven);
        System.out.println(avgodd);
    }
}
