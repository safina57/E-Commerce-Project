package Management;

import Management.Customer;
import Stock.Product;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    private static int orderCount = 0;
    private int orderID;
    private Customer customer;
    private LocalDate date;
    private String status;
    private Map<Integer, Product> products;
    private float totalPrice;

    public Order(Customer customer) {
        this.orderID = orderCount++;
        this.customer = customer;
        this.date = LocalDate.now();
        this.status = "Pending";
        this.products = new HashMap<>(customer.getProducts());
        this.totalPrice = customer.calculateTotalPrice();
    }

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void updateStatus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Update Order Status:");
        System.out.println("1. Shipping");
        System.out.println("2. Delivered");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                status = "Shipping";
                System.out.println("Order status updated to Shipping.");
                break;
            case 2:
                status = "Delivered";
                System.out.println("Order status updated to Delivered.");
                break;
            default:
                System.out.println("Invalid choice. Order status remains " + status + ".");
        }
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Date: " + date);
        System.out.println("Status: " + status);

        System.out.println("Products:");
        System.out.println("====================================");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Product: " + product.getName() + "\nQuantity: " + product.getQuantity());
            System.out.println("====================================");
        }

        System.out.println("Total Price: " + totalPrice + " DT");
    }


}
