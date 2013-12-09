import java.util.*;
import java.io.*;
public class UserInterface {
  private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");
  private static final int PROVIDER = 1;
  private static final int MANAGER = 2;
  private static final int OPERATOR = 3;
  private static final int EXIT = 4;

  /* Ask the user for their choice of commands */
  private static int getCommand() {
    while (true) {
      System.out.print("Enter command: ");
      int value = scanner.nextInt();
      if (value >= EXIT) {// && value <= HELP) {
        return value;
      }
    }
  }
  
  /* Asks the user a yes or no question.
   * Returns true if the answer was yes and false if the answer was no */
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
  
  public static void displayMainMenu() {
    System.out.println("\nEnter a number between " + PROVIDER + " and " + EXIT + " as explained below:");
    
    System.out.println(PROVIDER + " to test the provider terminal");
    System.out.println(MANAGER + " to test the manager terminal");
    System.out.println(OPERATOR + " to test the operator terminal");
    System.out.println(EXIT + " to exit");
    
    int command;
    while ((command = getCommand()) != EXIT) {
      switch (command) {
        case PROVIDER:		System.out.println("Provider");
                                break;
        case MANAGER:		System.out.println("Provider");
                                break;
        case OPERATOR:		System.out.println("Provider");
                                break;
        case EXIT:      System.out.println("Exit");
                                break;
      }
    }
  }
}
  