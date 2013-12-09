import java.util.*;
import java.io.*;
public class UserInterface {
//  private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*
  // Ask the user for their choice of commands
  private static int getCommand() {
    while (true) {
      System.out.print("Enter command: ");
      int value = scanner.nextInt();
      if (value >= EXIT) {// && value <= HELP) {
        return value;
      }
    }
  }
  
  // Asks the user a yes or no question.
  // Returns true if the answer was yes and false if the answer was no
  private boolean yesOrNo(String prompt) {
    System.out.println(prompt + " y/n");
    String more = scanner.next();
    if (more.contentEquals("y") || more.contentEquals("Y"))
      return true;
    else if (more.contentEquals("n") || more.contentEquals("N"))
      return false;
    else
      return yesOrNo(prompt);
  }
*/
  private static String getToken(String prompt) {
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
  
  private static int getNumber(String prompt, int MIN, int MAX) {
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
  
  public static void displayMainMenu() {
    final int PROVIDER = 1;
    final int MANAGER = 2;
    final int OPERATOR = 3;
    final int EXIT = 4;
    
    int command;
    do {
      System.out.println("\nMAIN MENU");
      System.out.println("Enter a number between " + PROVIDER + " and " + EXIT + " as explained below:");
      System.out.println(PROVIDER + " to test the provider terminal");
      System.out.println(MANAGER + " to test the manager terminal");
      System.out.println(OPERATOR + " to test the operator terminal");
      System.out.println(EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, 4);
    
      switch (command) {
        case PROVIDER:		displayProviderTerminal();
                          break;
        case MANAGER:		  displayManagerTerminal();
                          break;
        case OPERATOR:		displayOperatorTerminal();
                          break;
      }
    } while (command != EXIT);
  }
  
  public static void displayProviderTerminal() {
  
  }

  public static void displayManagerTerminal() {
    final int MEMBER_REPORT = 1;
    final int PROVIDER_REPORT = 2;
    final int SUMMARY_REPORT = 3;
    final int EXIT = 4;
    
    int command;
    do {
      System.out.println("\nMANAGER TERMINAL");
      System.out.println("Enter a number between " + MEMBER_REPORT + " and " + EXIT + " as explained below:");
      System.out.println(MEMBER_REPORT + " to create a member report");
      System.out.println(PROVIDER_REPORT + " to create a provider report");
      System.out.println(SUMMARY_REPORT + " to create a summary report");
      System.out.println(EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, 4);
    
      switch (command) {
        case MEMBER_REPORT:		  //displayProviderTerminal();
                                break;
        case PROVIDER_REPORT:	  //displayManagerTerminal();
                                break;
        case SUMMARY_REPORT:	  //displayOperatorTerminal();
                                break;
      }
    } while (command != EXIT);
  }

  public static void displayOperatorTerminal() {
    final int MANAGE_MEMBER = 1;
    final int MANAGE_PROVIDER = 2;
    final int EXIT = 3;
    
    int command;
    do {
      System.out.println("\nOPERATOR TERMINAL");
      System.out.println("Enter a number between " + MANAGE_MEMBER + " and " + EXIT + " as explained below:");
      System.out.println(MANAGE_MEMBER + " to manage a member");
      System.out.println(MANAGE_PROVIDER + " to manage a provider");
      System.out.println(EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, 3);
    
      switch (command) {
        case MANAGE_MEMBER:		  ManagePerson.manageMember();
                                break;
        case MANAGE_PROVIDER:	  ManagePerson.manageProvider();
                                break;
      }
    } while (command != EXIT);
  }
}
  