import java.util.*;
import java.io.*;
public class UserInterface {
  private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
      System.out.println("  " + PROVIDER + " to test the provider terminal");
      System.out.println("  " + MANAGER + " to test the manager terminal");
      System.out.println("  " + OPERATOR + " to test the operator terminal");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
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
    final int BILL_CHOCAN = 1;
    final int VIEW_DIRECTORY = 2;
    final int EXIT = 3;
    
    int command;
    do {
      System.out.println("\nMANAGER TERMINAL");
      System.out.println("Enter a number between " + BILL_CHOCAN + " and " + EXIT + " as explained below:");
      System.out.println("  " + BILL_CHOCAN + " to bill ChocAn");
      System.out.println("  " + VIEW_DIRECTORY + " to view the Provider Directory");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      switch (command) {
        case BILL_CHOCAN:		    //displayProviderTerminal();
                                break;
        case VIEW_DIRECTORY:	  ProviderDirectory.printServices();
                                break;
      }
    } while (command != EXIT);
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
      System.out.println("  " + MEMBER_REPORT + " to create a member report");
      System.out.println("  " + PROVIDER_REPORT + " to create a provider report");
      System.out.println("  " + SUMMARY_REPORT + " to create a summary report");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
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
    final int MANAGE_DIRECTORY = 3;
    final int EXIT = 4;
    
    int command;
    do {
      System.out.println("\nOPERATOR TERMINAL");
      System.out.println("Enter a number between " + MANAGE_MEMBER + " and " + EXIT + " as explained below:");
      System.out.println("  " + MANAGE_MEMBER + " to manage a member");
      System.out.println("  " + MANAGE_PROVIDER + " to manage a provider");
      System.out.println("  " + MANAGE_DIRECTORY + " to manage the Provider Directory");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      switch (command) {
        case MANAGE_MEMBER:		  ManagePerson.manageMember();
                                break;
        case MANAGE_PROVIDER:	  ManagePerson.manageProvider();
                                break;
        case MANAGE_DIRECTORY:	ProviderDirectory.manage();
                                break;
      }
    } while (command != EXIT);
  }
}