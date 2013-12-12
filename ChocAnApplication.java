import java.io.*;
import java.util.*;
import java.text.*;

public class ChocAnApplication {
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  
  public static void verifyMember() {
    Member member = new Member();
    int ID = getNumber("Enter the member ID: ", 1, 9999999);
    
    member.load(ID);
    int status = member.getStatus();	
    if(status != 0){
      System.out.println("Not valid.");
    }
    else if(status == 1) {
      System.out.println("Valid.");
    }
    else if(status == 2) {
      System.out.println("Suspended.");
    }
  }
  
/*  
  public static void initializeApplication() {
  
  }
*/

  public static String getToken(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    }
  }

  public static int getNumber(String prompt, int MIN, int MAX) {
    while (true) {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        if ((num.intValue() >= MIN) && (num.intValue() <= MAX)) {
          return num.intValue();
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    }
  }
  
  public static void main(String[] args) {
  //  UserInterface userInterface = new UserInterface();
    UserInterface.displayMainMenu();
  }
}