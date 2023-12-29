package Management;

import java.util.Scanner;

public interface Search {
     void searchProduct();
     void filterProduct(String category);
     default void filterProductByCategory() {
          Scanner sc = new Scanner(System.in);

          System.out.println("Filter Products in Cart by Category:");
          System.out.println("1. Electronic");
          System.out.println("2. Food");
          System.out.println("3. Clothing");
          System.out.println("4. Toy");
          System.out.print("Enter the category number: ");

          int choice = sc.nextInt();
          sc.nextLine();
          String category;
          switch (choice) {
               case 1:
                    category = "Electronic";
                    break;
               case 2:
                    category = "Food";
                    break;
               case 3:
                    category = "Clothing";
                    break;
               case 4:
                    category = "Toy";
                    break;
               default:
                    System.out.println("Invalid choice. No filtering applied.");
                    return;
          }

          filterProduct(category);
     }
}
