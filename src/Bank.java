public class Bank {
  private String name;
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  Bank(String name) {
    this.setName(name);
  }
}
