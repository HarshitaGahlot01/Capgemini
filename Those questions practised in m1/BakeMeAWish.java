import java.util.*;

class CakeOrder{

    private Map<String,Double> orderMap = new HashMap<>();

    public Map<String,Double> getOrderMap(){
        return orderMap;
    }

    public void setOrderMap(Map<String,Double> orderMap){
        this.orderMap = orderMap;
    }

    public void addOrderDetails(String orderId, Double cakeCost){
        orderMap.put(orderId, cakeCost);
    }

    public Map<String, Double> findOrdersAboveSpecifiedCost(double cakeCost) {

        Map<String,Double> h = new HashMap<>();

        for(Map.Entry<String ,Double> e : orderMap.entrySet()){
            if(e.getValue() > cakeCost){
                h.put(e.getKey(), e.getValue());
            }
        }

        return h;
    }
}

public class BakeMeAWish {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CakeOrder obj = new CakeOrder();

        System.out.println("Enter number of cake orders to be added");
        int n = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the cake order details (Order Id: CakeCost)");

        for(int i = 0; i < n; i++){

            String input = sc.nextLine();
            String[] arr = input.split(":");

            String orderId = arr[0];
            double cost = Double.parseDouble(arr[1]);

            obj.addOrderDetails(orderId, cost);
        }

        System.out.println("Enter the cost to search the cake orders");
        double searchCost = sc.nextDouble();

        Map<String, Double> h = obj.findOrdersAboveSpecifiedCost(searchCost);

        if(h.isEmpty()){
            System.out.println("No cake orders found");
        }
        else{
            System.out.println("Cake Orders above the specified cost");

            for(Map.Entry<String, Double> e : h.entrySet()){
                System.out.println("Order ID: " + e.getKey() + ", Cake Cost: " + e.getValue());
            }
        }

    }
}