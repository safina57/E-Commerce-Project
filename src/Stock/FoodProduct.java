package Stock;

import java.util.Scanner;

public class FoodProduct extends Product {
    public float weight;
    public String expirationDate;
    public FoodProduct() {
        super();
    }

    public FoodProduct(int reference, String name, int stock, float price, float weight, String expirationDate) {
        super(reference, name, stock, price, "Food");
        this.weight = weight;
        this.expirationDate = expirationDate;
    }
    public void setProduct() {
        super.setProduct();
        this.category="Food";
        Scanner sc = new Scanner(System.in);
        System.out.print("Weight: ");
        this.weight = sc.nextFloat();
        sc.nextLine();
        System.out.print("Expiration date: ");
        this.expirationDate = sc.nextLine();
    }
    public float getWeight() {
        return weight;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    @Override
    public String toString() {
        return super.toString() + "\nweight=" + weight + "\nexpirationDate='" + expirationDate + "'";
    }
    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.println("4. Weight");
        System.out.println("5. Expiration date");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                sc.nextLine();
                System.out.print("New name: ");
                this.name = sc.nextLine();
                break;
            case 2:
                System.out.print("New price: ");
                this.price = sc.nextFloat();
                break;
            case 3:
                System.out.print("New quantity: ");
                this.quantity = sc.nextInt();
                break;
            case 4:
                System.out.print("New weight: ");
                this.weight = sc.nextFloat();
                break;
            case 5:
                sc.nextLine();
                System.out.print("New expiration date: ");
                this.expirationDate = sc.nextLine();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    @Override
    public Product copy(int Quantity) {
        return new FoodProduct(this.reference, this.name, Quantity, this.price, this.weight, this.expirationDate);
    }
}
