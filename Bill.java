import java.util.*;
import java.io.*;

public class Bill{
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private String dateCreated;
  private String dateServiceProvided;
  private int providerID;
  private int memberID;
  private int serviceCode;
  private String comments;
  
    public Bill () {
    this.dateCreated = null;
    this.dateServiceProvided = null;
    this.providerID = 0;
    this.memberID = 0;
    this.serviceCode = 0;
    this.comments = null;
  }
  
  public Bill (String dateCreated, String dateServiceProvided, int providerID, int memberID, int serviceCode, String comments) {
    this.dateCreated = dateCreated;
    this.dateServiceProvided = dateServiceProvided;
    this.providerID = providerID;
    this.memberID = memberID;
    this.serviceCode = serviceCode;
    this.comments = comments;
  }
  
  public void createBill(){
  	dateCreated = getToken("Enter the date that service was created: ");
    dateServiceProvided = getToken("Enter the date that service was provided: ");
		providerID = getNumber("Enter the provider id: ");
    memberID = getNumber("Enter the member id: ");
    serviceCode = getNumber("Enter the service code: ");
    comments = getToken("Enter comments: ");
  }

  public String getDateCreated() {
    return dateCreated;
  }
  public String getDateServiceProvided() {
    return dateServiceProvided;
  }
  public int getProviderID() {
    return providerID;
  }
  public int getMemberID() {
    return memberID;
  }
  public int getServiceCode() {
    return serviceCode;
  }
  public String getComments() {
    return comments;
  }  
  
  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
          System.exit(0);
      }
    } while (true);
	}
	
	public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
	}

}




 




 




 

