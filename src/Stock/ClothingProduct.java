package Stock;

import java.util.Scanner;

public class ClothingProduct extends Product {
    private String brand;
    private String size;
    private String color;
    public ClothingProduct() {
        super();
    }
    public ClothingProduct(int reference, String name, int stock, float price, String brand, String size, String color) {
        super(reference, name, stock, price, "Clothing");
        this.brand = brand;
        this.size = size;
        this.color = color;
    }
    public void setProduct() {
        super.setProduct();
        this.category="Clothing";
        Scanner sc = new Scanner(System.in);
        System.out.print("Brand: ");
        this.brand = sc.nextLine();
        System.out.print("Size: ");
        this.size = sc.nextLine();
        System.out.print("Color: ");
        this.color = sc.nextLine();
    }
    public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return super.toString() + "\nbrand='" + brand + "'\nsize='" + size + "'\ncolor='" + color + "'";
    }
    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.println("4. Brand");
        System.out.println("5. Size");
        System.out.println("6. Color");
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
                System.out.print("New size: ");
                this.size = sc.nextLine();
                break;
            case 6:
                sc.nextLine();
                System.out.print("New color: ");
                this.color = sc.nextLine();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    @Override
    public Product copy(int Quantity) {
        return new ClothingProduct(this.reference, this.name, Quantity, this.price, this.brand, this.size, this.color);
    }
}
