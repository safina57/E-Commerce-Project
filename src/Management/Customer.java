package Management;

import Stock.*;


import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Customer{
    private String name;
    private int userID;
    private String password;
    private ShoppingCart cart;
    private Map<Integer, Order> orders;
    private CreditCard creditCard;
    private WishList wishList;
    private ShoppingCart shoppingCart;

    public Customer(String name, int userID, String password, CreditCard creditCard) {
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.creditCard = creditCard;
        this.cart = new ShoppingCart();
        this.orders = new HashMap<>();
        this.wishList = new WishList();
        this.shoppingCart = new ShoppingCart();
    }
    public void addProductToWishList(StockManager stock){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the product reference: ");
        int productReference = sc.nextInt();
        sc.nextLine();
        if (wishList.containsKey(productReference)) {
            System.out.println("Product already in My Favorites list.");
        } else {;
            wishList.addProduct(stock.get(productReference));
            System.out.println("Product added to My Favorites list.");
        }
    }
    public void removeProductFromWishList(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the product reference: ");
        int reference = sc.nextInt();
        sc.nextLine();
        wishList.removeProduct(reference);
    }
    public void displayWishList(){
        wishList.displayWishList();
    }

    public void addProductToCart(StockManager stock){
        shoppingCart.addToCart(stock);
    }
    public void removeProductFromCart(){
        shoppingCart.removeFromCart();
    }
    public void viewCart(){
        shoppingCart.viewCart();
    }
    public void updateQuantityInCart(){
        shoppingCart.updateQuantity();
    }
    public void searchProductInCart(){
        shoppingCart.searchProduct();
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void filterProductInCart(){
        shoppingCart.filterProductByCategory();
    }

    public String getPassword() {
        return password;
    }

    public void addOrder(Order order){
        orders.put(order.getOrderID(),order);
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }
    public void displayOrders(){
        if(orders.isEmpty()){
            System.out.println("No orders to display.");
            return;
        }
        for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
            Order order = entry.getValue();
            order.displayOrderDetails();
        }
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }
    public void clearCart(StockManager stock) {
        Order order = new Order(this);
        shoppingCart.clearCart(this, stock,order);
    }
    public float calculateTotalPrice(){
        return shoppingCart.calculateTotalPrice();
    }
    public Map<Integer, Product> getProducts(){
        return shoppingCart.getProducts();
    }

    public boolean containsKey(int orderID) {
        return orders.containsKey(orderID);
    }

    public Order get(int orderID) {
        return orders.get(orderID);
    }
    public boolean ordersIsEmpty() {
        return orders.isEmpty();
    }
}
