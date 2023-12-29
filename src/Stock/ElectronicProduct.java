package Stock;

import java.util.Scanner;

public class ElectronicProduct extends Product {
    private String brand;
    private String description;
    public ElectronicProduct() {
        super();
    }

    public ElectronicProduct(int reference, String name, int stock, float price, String brand, String description) {
        super(reference, name, stock, price, "Electronic");
        this.brand = brand;
        this.description = description;
    }
    public void setProduct() {
        super.setProduct();
        this.category="Electronic";
        Scanner sc = new Scanner(System.in);
        System.out.print("Brand: ");
        this.brand = sc.nextLine();
        System.out.print("Description: ");
        this.description = sc.nextLine();
    }
    public String getBrand() {
        return brand;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return super.toString() + "\nbrand='" + brand + "'\ndescription='" + description + "'";
    }
    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.println("4. Brand");
        System.out.println("5. Description");
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
                sc.nextLine();
                System.out.print("New brand: ");
                this.brand = sc.nextLine();
                break;
            case 5:
                sc.nextLine();
                System.out.print("New description: ");
                this.description = sc.nextLine();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
    @Override
    public Product copy(int Quantity) {
        return new ElectronicProduct(this.reference, this.name, Quantity, this.price, this.brand, this.description);
    }

}
