package Stock;

import java.util.Scanner;

abstract public class Product {
    protected int reference;
    protected String name;
    protected int quantity;
    protected float price;
    protected String category;
    protected float rating;
    protected int ratingCount;
    public Product() {}

    public Product(int reference, String name, int quantity, float price,String category) {
        this.reference = reference;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category=category;
        rating=0;
        ratingCount=0;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public String getCategory() {
        return category;
    }

    public void decrementQuantity(int quantity) {
    if (this.quantity - quantity >= 0) {
            this.quantity -= quantity;
        } else {
            System.out.println("Not enough stock");
        }
    }
    public void setProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Reference: ");
        this.reference = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        this.name = sc.nextLine();
        System.out.print("Quantity: ");
        this.quantity = sc.nextInt();
        sc.nextLine();
        System.out.print("Price: ");
        this.price = sc.nextFloat();
        sc.nextLine();
    }
    public int getReference() {
        return reference;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public float getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product: reference=" + reference + "\nname='" + name + "'\nquantity=" + quantity + "\nprice=" + price+"DT"+"\ncategory="+category+"\nrating="+rating;
    }
    abstract void update();

    public void setQuantity(int i) {
        quantity=i;
    }
    abstract Product copy(int Quantity);
    public void rate(){
        System.out.println("Do you want to rate this product?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        int rating;
        if(choice==1) {
            System.out.println("Please rate this product from 1 to 5");
            rating = sc.nextInt();
        }
        else
            return;
        System.out.println("Thank you for rating this product");
        this.rating=(this.rating*ratingCount+rating)/(float)(ratingCount+1);
        ratingCount++;
    }
}