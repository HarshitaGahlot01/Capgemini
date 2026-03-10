import java.util.*;
class Apartment{
    private Map<String,Double> apartmentDetailsMap =new HashMap<>();

    public Map<String, Double> getApartmentDetailsMap() {
        return apartmentDetailsMap;
    }

    public void setApartmentDetailsMap(Map<String, Double> apartmentDetailsMap) {
        this.apartmentDetailsMap = apartmentDetailsMap;
    }
    public void addApartmentDetails(String apartmentNumber , Double rent){
        apartmentDetailsMap.put(apartmentNumber,rent);
    }
    public double findTotalRentOfApartmentsInTheGivenRange(double minimumRent, double maximumRent) {
        double total=0;
        for(double rent:apartmentDetailsMap.values()){
            if(rent>=minimumRent && rent<=maximumRent){
                total=total+rent;
            }
        }
        return total;
    }
}
public class HeavenHomes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Apartment obj = new Apartment();

        System.out.println("Enter number of details to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the details (Apartment number: Rent)");

        for(int i = 0; i < n; i++) {

            String input = sc.nextLine();

            String arr[] = input.split(":");

            String apartmentNumber = arr[0];
            double rent = Double.parseDouble(arr[1]);

            obj.addApartmentDetails(apartmentNumber, rent);
        }

        System.out.println("Enter the range to filter the details");

        double min = sc.nextDouble();
        double max = sc.nextDouble();

        double result = obj.findTotalRentOfApartmentsInTheGivenRange(min, max);

        if(result == 0)
            System.out.println("No apartments found in this range");
        else
            System.out.println("Total Rent in the range " + min + " to " + max + " USD:" + result);

    }
}

