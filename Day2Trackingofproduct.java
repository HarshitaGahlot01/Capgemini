import java.util.*;

class Customer {
    String name;
    int customerid;
    Customer(String name, int customerid) {
        this.customerid = customerid;
        this.name = name;
    }
}
class Product {
    int productid;
    String productname;
    double productprice;
    Product(int productid, String productname, double productprice) {
        this.productid = productid;
        this.productname = productname;
        this.productprice = productprice;
    }
}
class Order {
    int orderid;
    int customerid;
    int productid;
    String location;
    String deliverypartner;
}
public class Day2Trackingofproduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Order> o = new ArrayList<>();
        HashMap<Integer, Customer> customers = new HashMap<>();
        HashMap<Integer, Product> products = new HashMap<>();
        HashMap<Integer, String> orderStatus = new HashMap<>();
        System.out.println("enter customer name");
        String name = sc.nextLine();
        System.out.println("enter customer id");
        int id = sc.nextInt();
        sc.nextLine();
        customers.put(id, new Customer(name, id));
        System.out.println("enter product id");
        int pid = sc.nextInt();
        sc.nextLine();
        System.out.println("enter product name");
        String pname = sc.nextLine();
        System.out.println("enter product price");
        double price = sc.nextDouble();
        sc.nextLine();
        products.put(pid, new Product(pid, pname, price));
        Order or = new Order();
        System.out.print("enter order iD: ");
        or.orderid = sc.nextInt();
        sc.nextLine();
        or.customerid = id;
        or.productid = pid;
        System.out.print("enter delivery location: ");
        or.location = sc.nextLine();
        System.out.print("enter delivery partner name: ");
        or.deliverypartner = sc.nextLine();
        o.add(or);
        if (or.location != null && !or.location.isEmpty()) {
            orderStatus.put(or.orderid, "product is placed");
        } else {
            orderStatus.put(or.orderid, "product is not placed");
        }
        System.out.println("tracking details");
        Customer c = customers.get(or.customerid);
        Product p = products.get(or.productid);
        System.out.println("Customer ID: " + c.customerid);
        System.out.println("Customer Name: " + c.name);
        System.out.println("Product Name: " + p.productname);
        System.out.println("Location: " + or.location);
        System.out.println("Delivery Partner: " + or.deliverypartner);
        System.out.println("Status: " + orderStatus.get(or.orderid));
    }
}
