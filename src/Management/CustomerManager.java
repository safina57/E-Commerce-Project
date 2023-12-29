package Management;

import Management.Customer;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerManager {
    private Map<Integer, Customer> customers;
    public CustomerManager() {
        customers = new HashMap<>();
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (customers.containsKey(userID)) {
            System.out.println("Customer already exists !");
        } else {
            CreditCard creditCard = new CreditCard();
            creditCard.setCreditCard();
            Customer customer = new Customer(name, userID, password, creditCard);
            customers.put(userID, customer);
            System.out.println("Customer added successfully !");
        }
    }
    public Customer logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        int userID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (customers.containsKey(userID)) {
            Customer customer = customers.get(userID);
            if (customer.getPassword().equals(password)) {
                System.out.println("Customer logged in successfully !");
                return customer;
            } else {
                System.out.println("Wrong password !");
            }
        } else {
            System.out.println("Customer not found !");
        }
        return null;
    }
    public static void logOut(Customer customer) {
        System.out.println("Customer " + customer.getName() + " logged out successfully !");
    }
    public void displayCustomers() {
        for (Map.Entry<Integer, Customer> entry : customers.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getName());
        }
    }
    public void updateStatus(){
        if(customers.isEmpty()){
            System.out.println("No customers !");
            return;
        }
        displayCustomers();
        Scanner sc=new Scanner(System.in);
        System.out.print("User ID:");
        int userID=sc.nextInt();
        sc.nextLine();
        if(customers.containsKey(userID)){
            Customer customer=customers.get(userID);
            if(customer.ordersIsEmpty()){
                System.out.println("No orders to display.");
                return;
            }
            customer.displayOrders();
            System.out.print("Enter the order ID:");
            int orderID=sc.nextInt();
            sc.nextLine();
            if(!customer.containsKey(orderID)){
                System.out.println("Order not found !");
                return;
            }
            Order order=customer.get(orderID);
            order.updateStatus();
            System.out.println("Status updated successfully !");
        }
        else{
            System.out.println("Customer not found !");
        }
    }


}
