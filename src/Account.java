abstract public class Account {
  private float balance;
  private float interest;
  private float monthlyFee;
  private int transactionAmount;
  
  public float getBalance() {
    return balance;
  }
  
  public void setBalance(float balance) {
    this.balance = balance;
  }
  
  public float getInterest() {
    return interest;
  }
  
  public void setInterest(float interest) {
    this.interest = interest;
  }
  
  public float getMonthlyFee() {
    return monthlyFee;
  }
  
  public void setMonthlyFee(float monthlyFee) {
    this.monthlyFee = monthlyFee;
  }
  
  public int getTransactionAmount() {
    return transactionAmount;
  }
  
  public void setTransactionAmount(int transactionAmount) {
    this.transactionAmount = transactionAmount;
  }
  
  Account(float balance, float interest, float monthlyFee, int transactionAmount) {
    this.setBalance(balance);
    this.setInterest(interest);
    this.setMonthlyFee(monthlyFee);
    this.setTransactionAmount(transactionAmount);
  }
  
  public void checkBalance() {
    System.out.println("Your current balance is $" + this.getBalance());
  }
  
  public void checkInterest() {
    System.out.println("Your current interest rate is " + this.getInterest() + "%");
  }
  
  public void deposit(float cash) {
    this.setBalance(this.getBalance() + cash);
    System.out.println("Deposit successful!");
    this.checkBalance();
  }
  
  public void withdraw(float cash) {
    if(cash > this.getBalance()) {
      System.out.println("Sorry you do not have sufficient funds!");
    } else {
      this.setBalance(this.getBalance() - cash);
      System.out.println("Withdraw successful");
      this.checkBalance();
    }
  }
}
