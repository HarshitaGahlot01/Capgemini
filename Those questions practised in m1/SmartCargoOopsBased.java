import java.util.*;
abstract class Shipment{
    protected String shipmentId;
  protected  String shipmentDate;
  protected  int shipmentRating;
    public Shipment(String id, String date, int rating) {
        this.shipmentId = id;
        this.shipmentDate = date;
        this.shipmentRating = rating;
    }
    public String getShipmentId() {
        return shipmentId;
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public int getShipmentRating() {
        return shipmentRating;
    }
    public abstract String vehicleSelection();

    public abstract float calculateTotalCharge();
}
class SteelShipment extends Shipment {
    private float steelWeight;
    private int steelQuantity;
    private float steelPrice;

    public SteelShipment(String id, String date, int rating,
                         float weight, int quantity, float price) {
        super(id, date, rating);
        this.steelWeight = weight;
        this.steelQuantity = quantity;
        this.steelPrice = price;
    }

    public int getSteelQuantity() {
        return steelQuantity;
    }

    public String vehicleSelection() {
        if (steelQuantity < 200) {
            return "MiniTruck";
        } else if (steelQuantity >= 500) {
            return "Truck";
        } else {
            return "HeavyTruck";
        }
    }

    public float calculateTotalCharge() {
        float price = steelPrice * steelQuantity;
        float tax = price * 0.30f;
        float discount = 0;
        if (shipmentRating == 5)
            discount = price * 0.20f;
        else if (shipmentRating >= 3)
            discount = price * 0.10f;
        float vehiclePrice = 0;
        String vehicle = vehicleSelection();

        if (vehicle.equals("MiniTruck"))
            vehiclePrice = 800;
        else if (vehicle.equals("Truck"))
            vehiclePrice = 1500;
        else
            vehiclePrice = 2800;
        return price + vehiclePrice + tax - discount;
    }
}
class FurnitureShipment extends Shipment {
    private float furnitureLength;
    private float furnitureWidth;
    private String furnitureType;
    private float furniturePrice;
    public FurnitureShipment(String id, String date, int rating,
                             float length, float width,
                             String type, float price) {
        super(id, date, rating);
        this.furnitureLength = length;
        this.furnitureWidth = width;
        this.furnitureType = type;
        this.furniturePrice = price;
    }
    public String vehicleSelection() {
        float area = furnitureLength * furnitureWidth;
        if (area < 150)
            return "MiniTruck";
        else if (area <= 300)
            return "Truck";
        else
            return "HeavyTruck";
    }
    public float calculateTotalCharge() {
        float volume = furnitureLength * furnitureWidth;
        float rate =
                furnitureType.equalsIgnoreCase("Premium") ? 0.30f : 0.18f;  // if else

        float price = volume * furniturePrice * rate;
        float tax=price*0.30f;
        float discount = 0;
        if (shipmentRating == 5)
            discount = price * 0.20f;
        else if (shipmentRating >= 3)
            discount = price * 0.10f;
        float vehiclePrice = 0;

        String vehicle = vehicleSelection();

        if (vehicle.equals("MiniTruck"))
            vehiclePrice = 800;
        else if (vehicle.equals("Truck"))
            vehiclePrice = 1500;
        else
            vehiclePrice = 2800;

        return price + vehiclePrice + tax - discount;
    }
}
class Utility{
    public static boolean validateShipmentId(String id){
        return id.matches("^SHP[0-9]{3}[A-Z]$");
    }

    public static Shipment parseDetails(String input){
        String w[]=input.split(":");
        String shipmentId = w[0];
        if(!validateShipmentId(shipmentId)){
            System.out.println("invalid");
            System.out.println("please valid record");
            return null;
        }
        String date=w[1];
        int rating=Integer.parseInt(w[2]);
        String Type=w[3];
        if (Type.equalsIgnoreCase("SteelShipment")) {

            float weight = Float.parseFloat(w[4]);
            int quantity = Integer.parseInt(w[5]);
            float price = Float.parseFloat(w[6]);
            return new SteelShipment(
                    shipmentId, date, rating,
                    weight, quantity, price);
        }

        else {

            float length = Float.parseFloat(w[4]);
            float width = Float.parseFloat(w[5]);
            String fType = w[6];
            float price = Float.parseFloat(w[7]);

            return new FurnitureShipment(
                    shipmentId, date, rating,
                    length, width, fType, price);
        }
    }
}
public class SmartCargoOopsBased {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Shipment shipment = Utility.parseDetails(input);

        if (shipment == null)
            return;

        String vehicle = shipment.vehicleSelection();
        float total = shipment.calculateTotalCharge();

        System.out.println("Shipment id : " + shipment.getShipmentId());
        System.out.println("Date of shipment : " + shipment.getShipmentDate());
        System.out.println("Rating : " + shipment.getShipmentRating());

        if (shipment instanceof SteelShipment) {
            SteelShipment s = (SteelShipment) shipment;
            System.out.println("Steel quantity : " + s.getSteelQuantity());
        }

        System.out.println("Vehicle selected : " + vehicle);
        System.out.println("Total charge : " + total);
    }
}

