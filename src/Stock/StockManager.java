package Stock;
import Management.Search;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class StockManager implements Search {
    private Map<Integer, Product> products;

    public StockManager() {
        products = new HashMap<>();
    }
    public boolean containsKey(int reference) {
        return products.containsKey(reference);
    }
    public Product get(int reference) {
        return products.get(reference);
    }
    public void addProduct(Product product){
        products.put(product.getReference(),product);
    }


    public void addProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the type of product to add:");
        System.out.println("1. Electronic Product");
        System.out.println("2. Clothing Product");
        System.out.println("3. Toy Product");
        System.out.println("4. Food Product");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Product product;

        switch (choice) {
            case 1:
                product = new ElectronicProduct();
                product.setProduct();
                break;
            case 2:
                product = new ClothingProduct();
                product.setProduct();
                break;
            case 3:
                product= new ToyProduct();
                product.setProduct();
                break;
            case 4:
                product= new FoodProduct();
                product.setProduct();
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        products.put(product.getReference(), product);
        System.out.println("Product added successfully!");
    }
    public void removeProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the reference of the product to remove: ");
        int reference = scanner.nextInt();

        if (products.containsKey(reference)) {
            Product removedProduct = products.remove(reference);
            System.out.println("Product removed successfully:");
            System.out.println(removedProduct.toString());
        } else {
            System.out.println("Product with reference " + reference + " not found.");
        }
    }

    public void updateProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the reference of the product to update: ");
        int reference = scanner.nextInt();

        if (products.containsKey(reference)) {
            Product product = products.get(reference);
            product.update();

            System.out.println("Product updated successfully:");
        } else {
            System.out.println("Product with reference " + reference + " not found.");
        }
    }
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Stock is empty.");
        } else {
            System.out.println("All Products Information:");
            System.out.println("====================================");
            for (Product product : products.values()) {
                System.out.println(product.toString());
                System.out.println("====================================");
            }
        }
    }
    public void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product to search: ");
        String name = scanner.nextLine();
        boolean foundProducts = false;
        System.out.println("Search Results:");
        System.out.println("====================================");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product cartProduct = entry.getValue();

            if (cartProduct.getName().equals(name)) {
                System.out.println(cartProduct.toString());
                System.out.println("====================================");
                foundProducts = true;
            }
        }
        if(!foundProducts) {
            System.out.println("Product not found in the cart.");
            System.out.println("====================================");
        }
    }
    public void filterProduct(String category) {
        boolean foundProducts = false;
        System.out.println("Enter the price range to filter products:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Minimum price: ");
        float minPrice = scanner.nextFloat();
        System.out.print("Maximum price: ");
        float maxPrice = scanner.nextFloat();
        System.out.println("Filter Results:");
        System.out.println("====================================");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product cartProduct = entry.getValue();

            if ((cartProduct.getCategory().equals(category))&&(cartProduct.getPrice()>=minPrice)&&(cartProduct.getPrice()<=maxPrice)){
                System.out.println(cartProduct.toString());
                System.out.println("====================================");
                foundProducts = true;
            }
        }

        if (!foundProducts) {
            System.out.println("No products found for the specified category or price range.");
            System.out.println("====================================");
        }
    }
}
