package Management;

import java.util.Scanner;

public class CreditCard {
    private int cardNumber;
    private int code;
    private String type;
    private float balance;
    public CreditCard(int cardNumber, int code, String type, float balance) {
        this.cardNumber = cardNumber;
        this.code = code;
        this.type = type;
        this.balance = balance;
    }
    public CreditCard() {}

    public float getBalance() {
        return balance;
    }

    public int getCardNumber() {
        return cardNumber;
    }
    public int getCode() {
        return code;
    }
    public String getType() {
        return type;
    }
    public void setCreditCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card number: ");
        cardNumber = scanner.nextInt();
        System.out.print("Enter code: ");
        code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Card type: ");
        type = scanner.nextLine();
        System.out.print("Enter balance: ");
        balance = scanner.nextFloat();
    }
    public boolean checkCreditCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card number: ");
        int cardNumber = scanner.nextInt();
        System.out.print("Enter code: ");
        int code = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Card type: ");
        String type = scanner.nextLine();
        if(cardNumber == this.cardNumber && code == this.code && type.equals(this.type)){
            System.out.println("Credit card is valid!");
            return true;
        }
        else{
            System.out.println("Credit card is not valid!");
            return false;
        }
    }
    public void pay(float price){
        if(price <= balance){
            balance -= price;
            System.out.println("Payment successful!");
            System.out.println();
        }
        else{
            System.out.println("Payment failed!");
        }
    }




}
