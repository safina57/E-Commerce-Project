package Stock;

import java.util.Scanner;

public class ToyProduct extends Product {
    private String color;
    private String ageGroup;
    public ToyProduct() {
        super();
    }

    public ToyProduct(int reference, String name, int stock, float price, String color, String ageGroup) {
        super(reference, name, stock, price, "Toy");
        this.color = color;
        this.ageGroup = ageGroup;
    }
    public void setProduct() {
        super.setProduct();
        this.category="Toy";
        Scanner sc = new Scanner(System.in);
        System.out.print("Color: ");
        this.color = sc.nextLine();
        System.out.print("Age group: ");
        this.ageGroup = sc.nextLine();
    }
    public String getColor() {
        return color;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    @Override
    public String toString() {
        return super.toString() + "\ncolor='" + color + "'\nageGroup='" + ageGroup + "'";
    }
    @Override
    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Price");
        System.out.println("3. Quantity");
        System.out.println("4. Color");
        System.out.println("5. Age group");
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
                System.out.print("New color: ");
                this.color = sc.nextLine();
                break;
            case 5:
                sc.nextLine();
                System.out.print("New age group: ");
                this.ageGroup = sc.nextLine();
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    @Override
    public Product copy(int Quantity) {
        return new ToyProduct(this.reference, this.name, Quantity, this.price, this.color, this.ageGroup);
    }
}
