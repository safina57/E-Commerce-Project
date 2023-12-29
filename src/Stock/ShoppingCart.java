package Stock;

import Management.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart implements Search {
    private Map<Integer, Product> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addToCart(StockManager stock){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product reference: ");
        int productReference = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        if (items.containsKey(productReference)) {
            System.out.println("Product already in the cart.");
            Product cartProduct = items.get(productReference);
            cartProduct.setQuantity(cartProduct.getQuantity() + quantity);
            System.out.println("Quantity updated in the cart.");
        } else {
            if (stock.containsKey(productReference)) {
                Product stockProduct = stock.get(productReference);
                Product cartProduct = stockProduct.copy(quantity);
                items.put(productReference, cartProduct);
                System.out.println("Product added to the cart.");
            } else {
                System.out.println("Product not found in the stock.");
            }
        }
    }
    public void removeFromCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the product reference: ");
        int productReference = scanner.nextInt();
        scanner.nextLine();
        if (items.containsKey(productReference)) {
            items.remove(productReference);
            System.out.println("Product removed from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
    private void updateQuantity(int productReference, int newQuantity) {
        if (newQuantity <= 0) {
            items.remove(productReference);
        } else {
            items.get(productReference).setQuantity(newQuantity);
            System.out.println("Quantity updated in the cart.");
        }
    }
    public void updateQuantity() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the product reference: ");
        int productReference = sc.nextInt();
        sc.nextLine();
        if (items.containsKey(productReference)) {
            Product cartProduct = items.get(productReference);
            System.out.println("Current quantity: " + cartProduct.getQuantity());
            System.out.print("New quantity: ");
            int newQuantity = sc.nextInt();
            updateQuantity(productReference, newQuantity);
        } else {
            System.out.println("Product not found in the cart.");
        }
    }
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (int productReference : items.keySet()) {
            Product cartProduct = items.get(productReference);
            totalPrice += cartProduct.getPrice() * cartProduct.getQuantity();
        }
        return totalPrice;
    }
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("Cart:");
        System.out.println("====================================");
        for (int productReference : items.keySet()) {
            Product cartProduct = items.get(productReference);
            System.out.println("Product: " + cartProduct.getName() + "\nQuantity: " + cartProduct.getQuantity());
            System.out.println("====================================");
        }
    }

    public Map<Integer, Product> getProducts() {
        return items;
    }
    public void clearCart(Customer customer, StockManager stock, Order order) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        float totalPrice = calculateTotalPrice();

        System.out.println("Total Price: " + totalPrice + " DT");
        System.out.println("Do you want to confirm the transaction?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        Scanner sc = new Scanner(System.in);
        int confirmationChoice;
        confirmationChoice = sc.nextInt();
        sc.nextLine();
        if (confirmationChoice == 1) {
            processTransaction(customer, stock, totalPrice,order);
        } else {
            System.out.println("Transaction canceled by the user.");
            System.out.println();
            System.out.println("Order not confirmed!");
        }
    }
    private void processTransaction(Customer customer, StockManager stock, float totalPrice, Order order) {
        CreditCard creditCard = customer.getCreditCard();

        if (!creditCard.checkCreditCard()) {
            System.out.println("Transaction canceled due to mismatch.");
            System.out.println();
            System.out.println("Order not confirmed!");
            return;
        }
        if (creditCard.getBalance() < totalPrice) {
            System.out.println("Not enough balance in the credit card. Transaction canceled.");
            System.out.println();
            System.out.println("Order not confirmed!");
            return;
        }
        if (!hasEnoughStock(stock)) {
            System.out.println("Cart not cleared due to insufficient stock.");
            System.out.println();
            System.out.println("Order not confirmed!");
            return;
        }

        performTransaction(stock,customer,order);
        System.out.println();
        System.out.println("Cart cleared successfully.");
        System.out.println();
        System.out.println("Order confirmed!");
        System.out.println();
        creditCard.pay(totalPrice);
        System.out.println("Transaction completed. Remaining balance: " + creditCard.getBalance() + " DT");
    }

    private boolean hasEnoughStock(StockManager stock) {
        for (int productReference : items.keySet()) {
            Product cartProduct = items.get(productReference);
            Product stockProduct = stock.get(productReference);

            if (stockProduct == null || stockProduct.getQuantity() < cartProduct.getQuantity()) {
                System.out.println("Not enough stock for product: " + cartProduct.getName());
                return false;
            }
        }
        return true;
    }

    private void performTransaction(StockManager stock,Customer customer,Order order) {
        for (int productReference : items.keySet()) {
            Product cartProduct = items.get(productReference);
            Product stockProduct = stock.get(productReference);
            stockProduct.decrementQuantity(cartProduct.getQuantity());
            System.out.println("Product: " + cartProduct.getName());
            stockProduct.rate();
        }
        customer.addOrder(order);
        items.clear();
    }


    @Override
    public void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product to search: ");
        String name = scanner.nextLine();
        boolean foundProducts = false;
        System.out.println("Search Results:");
        System.out.println("====================================");
        for (Map.Entry<Integer, Product> entry : items.entrySet()) {
            Product cartProduct = entry.getValue();

            if (cartProduct.getName().equalsIgnoreCase(name)) {
                System.out.println("Product found in the cart:");
                System.out.println(cartProduct.toString());
                System.out.println("====================================");
                foundProducts = true;
            }
        }
        if (!foundProducts){
            System.out.println("Product not found in the cart.");
            System.out.println("====================================");
        }
    }
    @Override
    public void filterProduct(String category) {
        boolean foundProducts = false;

        System.out.println("Filter Results:");
        System.out.println("====================================");
        for (Map.Entry<Integer, Product> entry : items.entrySet()) {
            Product cartProduct = entry.getValue();

            if (cartProduct.getCategory().equals(category)) {
                System.out.println(cartProduct.toString());
                System.out.println("====================================");
                foundProducts = true;
            }
        }

        if (!foundProducts) {
            System.out.println("No products found in the cart for the specified category.");
            System.out.println("====================================");
        }
    }

}
