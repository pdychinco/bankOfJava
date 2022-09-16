public class Users {
  private CheckingAccount cAccount;
  private SavingsAccount sAccount;
  private String pin;
  
  public CheckingAccount getcAccount() {
    return cAccount;
  }
  
  public void setcAccount(CheckingAccount cAccount) {
    this.cAccount = cAccount;
  }
  
  public SavingsAccount getsAccount() {
    return sAccount;
  }
  
  public void setsAccount(SavingsAccount sAccount) {
    this.sAccount = sAccount;
  }
  
  public String getPin() {
    return pin;
  }
  
  public void setPin(String pin)  {
    if(pin.length() != 4) {
      throw new ArithmeticException("This is an invalid pin length");
    } else {
      this.pin = pin;
    }
  }
  
  Users(CheckingAccount cAccount, String pin) {
    this.setcAccount(cAccount);
    this.setPin(pin);
  }
  
  Users(SavingsAccount sAccount, String pin) {
    this.setsAccount(sAccount);
    this.setPin(pin);
  }
  
  Users(CheckingAccount cAccount, SavingsAccount sAccount, String pin) {
    this.setcAccount(cAccount);
    this.setsAccount(sAccount);
    this.setPin(pin);
  }
}
