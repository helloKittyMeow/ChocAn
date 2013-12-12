
public class Service {
  private int code;
  private String name;
  private double fee;
  
  public Service(int code, String name, double fee) {
    this.code = code;
    this.name = name;
    this.fee = fee;
  }
  
  // This method returns the code of a service
  public int getCode() {
    return code;
  }

  // This method sets the code of a service
  public void setCode(int code) {
    this.code = code;
  }

  // This method returns the name of a service
  public String getName() {
    return name;
  }

  // This method sets the name of a service
  public void setName(String name) {
    this.name = name;
  }

  // This method returns the fee of a service
  public double getFee() {
    return fee;
  }

  // This method sets the fee of a service
  public void setFee(double fee) {
    this.fee = fee;
  }
  
  public String toString() {
    return "Name: " + name + "\nCode: " + code + "\nFee: $" + String.format("%.2f", fee) + "\n";
  }
}