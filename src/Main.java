public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    SavingsAccount s1 = new SavingsAccount(123f, 0.001f, 3.94f, 10);
    s1.checkBalance();
    s1.withdraw(12312412f);
    s1.deposit(10000f);
    s1.withdraw(8000f);
  }
}