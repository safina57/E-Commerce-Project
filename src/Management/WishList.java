package Management;

import Stock.Product;

import java.util.Map;
import java.util.HashMap;
public class WishList {
    private Map<Integer, Product> products;
    public WishList() {
        products = new HashMap<>();
    }
    public void addProduct(Product product){
        if(products.containsKey(product.getReference())){
            System.out.println("Product already exists in the list");
        }
        else{
            products.put(product.getReference(),product);
            System.out.println("Product added successfully!");
        }
    }
    public void removeProduct(int reference){
        if(products.containsKey(reference)){
            products.remove(reference);
            System.out.println("Product removed successfully!");
        }
        else{
            System.out.println("Product not found in the list");
        }
    }
    public void displayWishList() {
        if (products.isEmpty()) {
            System.out.println("list is empty");
        } else {
            System.out.println("My Favorites List:");
            System.out.println("====================================");
            for (int reference : products.keySet()) {
                Product product = products.get(reference);
                System.out.println("Product Reference: " + product.getReference());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice() + " DT");
                System.out.println("Category: " + product.getCategory());
                System.out.println("Rating: " + product.getRating());
                System.out.println("====================================");
            }
        }
    }
    public boolean containsKey(int reference) {
        return products.containsKey(reference);
    }



}
