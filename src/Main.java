import Management.Admin;
import Management.Customer;
import Management.CustomerManager;
import Stock.StockManager;
import Stock.*;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        StockManager stockManager = initializeStock();
        Admin admin = new Admin();
        CustomerManager customerManager = new CustomerManager();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------------------Welcome to MAH Store--------------------");
            System.out.println("1. Sign Up");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.println("------------------------------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    signUpMenu(admin, customerManager);
                    break;
                case 2:
                    logInMenu(admin, customerManager, stockManager);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static StockManager initializeStock() {
        StockManager stockManager = new StockManager();
        Product p1,p2,p3,p4;
        p1=new ElectronicProduct(1,"Laptop",10,2000,"MSI", "Intel Core i7 and Nvidia RTX 2060");
        stockManager.addProduct(p1);
        p2=new ClothingProduct(2,"T-Shirt",20,100,"Nike","M","Black");
        stockManager.addProduct(p2);
        p3=new ToyProduct(3,"Mario Car",30,50,"Red","+3");
        stockManager.addProduct(p3);
        p4=new FoodProduct(4,"Chocolate",40,10,25,"10/10/2021");
        stockManager.addProduct(p4);
        return stockManager;
    }

    private static void signUpMenu(Admin admin, CustomerManager customerManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------Sign Up Menu----------");
        System.out.println("1. Sign Up as Admin");
        System.out.println("2. Sign Up as User");
        System.out.println("3. Back");
        System.out.println("--------------------------------");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                admin.signIn();
                break;
            case 2:
                customerManager.signUp();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void logInMenu(Admin admin, CustomerManager customerManager, StockManager stockManager) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----------Log In Menu----------");
        System.out.println("1. Log In as Admin");
        System.out.println("2. Log In as User");
        System.out.println("3. Back");
        System.out.println("-------------------------------");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                Scanner sc=new Scanner(System.in);
                System.out.print("ID:");
                int adminID=sc.nextInt();
                sc.nextLine();
                System.out.print("Password:");
                String password=sc.nextLine();
                if(admin.logIn(adminID,password)) {
                    System.out.println("Admin logged in successfully !");
                    adminMenu(stockManager,customerManager);
                }
                else {
                    System.out.println("Invalid ID or password!");
                }
                break;
            case 2:
                Customer customer = customerManager.logIn();
                if (customer != null) {
                    customerMenu(stockManager, customer);
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void adminMenu(StockManager stockManager,CustomerManager customerManager) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------Admin Menu----------");
            System.out.println("1. Add Product to Stock");
            System.out.println("2. Remove Product from Stock");
            System.out.println("3. Update Product Details");
            System.out.println("4. View All Products");
            System.out.println("5. Update Status of Order");
            System.out.println("6. Log Out");
            System.out.println("------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    stockManager.addProduct();
                    break;
                case 2:
                    stockManager.removeProduct();
                    break;
                case 3:
                    stockManager.updateProduct();
                    break;
                case 4:
                    stockManager.displayAllProducts();
                    break;
                case 5:
                    customerManager.updateStatus();
                    break;
                case 6:
                    System.out.println("Logging out as admin.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void customerMenu(StockManager stockManager, Customer customer) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("-------------Customer Menu-------------");
            System.out.println("1. Add Product to Shopping Cart");
            System.out.println("2. Remove Product from Shopping Cart");
            System.out.println("3. View Shopping Cart");
            System.out.println("4. Update Product Quantity in Shopping Cart");
            System.out.println("5. Search Products by Name");
            System.out.println("6. Filter Products");
            System.out.println("7. Search Products by Name in Shopping Cart");
            System.out.println("8. Filter Products in Shopping Cart");
            System.out.println("9. Add Product to my Favorites");
            System.out.println("10. Remove Product from my Favorites");
            System.out.println("11. View My Favorites");
            System.out.println("12. Checkout");
            System.out.println("13. View Orders");
            System.out.println("14. Log Out");
            System.out.println("----------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    customer.addProductToCart(stockManager);
                    break;
                case 2:
                    customer.removeProductFromCart();
                    break;
                case 3:
                    customer.viewCart();
                    break;
                case 4:
                    customer.updateQuantityInCart();
                    break;
                case 5:
                    stockManager.searchProduct();
                    break;
                case 6:
                    stockManager.filterProductByCategory();
                    break;
                case 7:
                    customer.searchProductInCart();
                    break;
                case 8:
                    customer.filterProductInCart();
                    break;
                case 9:
                    customer.addProductToWishList(stockManager);
                    break;
                case 10:
                    customer.removeProductFromWishList();
                    break;
                case 11:
                    customer.displayWishList();
                    break;
                case 12:
                    customer.clearCart(stockManager);
                    break;
                case 13:
                    customer.displayOrders();
                    break;
                case 14:
                    CustomerManager.logOut(customer);
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
