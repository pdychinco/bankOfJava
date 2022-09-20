import java.util.ArrayList;
import java.util.Scanner;
public class ATM {
  private String name;
  private ArrayList<Users> user = new ArrayList<>();
  private Users currentUser;
  private final Scanner scan = new Scanner(System.in);
  private boolean loggedIn = false;
  public boolean isLoggedIn() {
    return loggedIn;
  }
  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Users getCurrentUser() {
    return currentUser;
  }
  public void setCurrentUser(Users currentUser) {
    this.currentUser = currentUser;
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
    while (runTime) {
      if (this.isLoggedIn()) {
        this.accountPage();
      } else {
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
  }
  
  public void login() {
    int counter = 0;
    do {
      if (user.isEmpty()) {
        System.out.println("No current accounts in ATM!\n");
        break;
      } else if (counter == 3) {
        break;
      } else if (this.isLoggedIn()) {
        this.accountPage();
      }
      System.out.println("Please enter the pin associated with your account.");
      String enteredPin = scan.next();
  
      for (Users user : user) {
        if (enteredPin.equalsIgnoreCase(user.getPin())) {
          this.setLoggedIn(true);
          this.setCurrentUser(user);
          System.out.println("Login Successful!");
          this.accountPage();
        } else {
          counter += 1;
          System.out.printf("Incorrect Pin (%d, 3)%n", counter);
        }
      }
    } while (!this.isLoggedIn());
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
    System.out.println("Please enter a 4 character pin for your account.");
    String pinInput = scan.next();
    if (pinInput.length() == 4) {
      switch (choice) {
        case "1":
          this.user.add(new Users(new CheckingAccount(0f, 0f, 4.95f, 999999999), pinInput));
          break;
        case "2":
          this.user.add(new Users(new SavingsAccount(0f, 0.01f, 0f, 1), pinInput));
        case "3":
          this.user.add(new Users(new CheckingAccount(0f, 0f, 4.95f, 999999999), new SavingsAccount(0f, 0.01f, 0f, 1),
              pinInput));
      }
    }
  }
  
  public void accountPage() {
    System.out.println("Welcome to your account page");
    System.out.println("Please choose from an option below.");
    System.out.println("1. Account Balance");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    String userInput = scan.next();
    System.out.println(userInput);
    switch (userInput) {
      case "1" -> this.chooseAccount();
      case "2" -> this.createUser();
      case "q" -> {
        System.out.println("Thanks for banking at Bank of Java! See you soon.");
      }
    }
  }
  
  public String chooseAccount() {
    if(this.getCurrentUser().getcAccount() != null && this.getCurrentUser().getsAccount() != null) {
      System.out.println("Please pick between your two accounts");
      System.out.println("1. Saving Account");
      System.out.println("2. Checking Account");
      return scan.next();
    } else if (this.getCurrentUser().getcAccount() != null) {
      System.out.println("You only have a Checking Account currently.");
    } else {
      System.out.println("You only have a Saving Account currently.");
    }
    return null;
  }
  
  public void accountBalance() {
    String userInput = this.chooseAccount();
  }
}
