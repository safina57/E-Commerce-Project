package Management;

import java.util.Scanner;

public class Admin {
    private static boolean exists = false;
    private int adminID;
    private String password;

    public Admin(){}
    public void signIn(){
        if(exists){
            System.out.println("An admin already exists !");
        }
        else{
            Scanner sc=new Scanner(System.in);
            System.out.print("ID:");
            this.adminID=sc.nextInt();
            sc.nextLine();
            System.out.print("Password:");
            this.password=sc.nextLine();
            exists=true;
            System.out.println("Admin added successfully !");
        }
    }
    public boolean logIn(int ID,String password){
        return (ID == this.adminID) && (password.equals(this.password));
    }

}
