import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
  private String name;
  private ArrayList<Users> user = new ArrayList<>();
  private Scanner scan = new Scanner(System.in);
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  ATM(String name) {
    this.setName(name);
  }
  
  /*
  *do stuff here to control all the atm menu functions
  * also make a ATM.start()
   */
  public void start() {
    System.out.println("Start of ATM Script");
    System.out.println("-------------------------------------------");
    System.out.println("Welcome to Bank of Java.");
    boolean runTime = true;
    while(runTime) {
      String userChoice = this.startMenu();
      switch (userChoice) {
        case "1" -> this.login();
        case "2" -> this.createUser();
        case "q" -> {
          System.out.println("Thanks for banking at Bank of Java! See you soon.");
          runTime = false;
        }
      }
    }
    
  }
  public void login() {
    int counter = 0;
    do {
      System.out.println("Please enter the pin associated with your account.");
      String enteredPin = scan.next();
      for (Users user : user) {
        if (enteredPin.equalsIgnoreCase(user.getPin())) {
          System.out.println("Login Successful!");
          counter = 3;
        }
      }
      if(counter >= 3) {
        break;
      } else {
        System.out.println("Incorrect Pin");
        counter += 1;
      }
    }while(counter <= 2);
  }
  public String startMenu() {
    System.out.println("Please choose an option below.");
    System.out.println("1. Login with your pin.");
    System.out.println("2. Create new account with Bank Of Java.");
    System.out.println("Q. Quit the ATM.");
    return scan.next();
  }
  public void createUser() {
    System.out.println("Please select one option below for bank accounts.");
    System.out.println("1. Checking Account ONLY");
    System.out.println("2. Saving Account ONLY");
    System.out.println("3. Checking & Saving Accounts");
    String choice = scan.next();
    switch (choice) {
      case "1":
         this.user.add(new Users(new CheckingAccount(0f,0f,4.95f,999999999),"1111"));
        break;
      case "2":
         this.user.add(new Users(new SavingsAccount(0f, 0.01f, 0f, 1),"1111"));
      case "3":
        this.user.add(new Users(new CheckingAccount(0f, 0f, 4.95f, 999999999),new SavingsAccount(0f, 0.01f, 0f, 1),
            "1111"));
    }
  }
  
}
