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
      System.out.println("Enter a number between 1 and " + EXIT + " as explained below:");
      System.out.println("  " + PROVIDER + " to Use the Provider Terminal");
      System.out.println("  " + MANAGER + " to Use the Manager Terminal");
      System.out.println("  " + OPERATOR + " to Use the Operator Terminal");
      System.out.println("  " + EXIT + " to Exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      switch (command) {
        case PROVIDER:    displayProviderTerminal();
                          break;
        case MANAGER:     displayManagerTerminal();
                          break;
        case OPERATOR:    displayOperatorTerminal();
                          break;
      }
    } while (command != EXIT);
  }
  
  public static void displayProviderTerminal() {
	final int VERIFY_MEMBER = 1;
    final int BILL_CHOCAN = 2;
    final int VIEW_DIRECTORY = 3;
    final int EXIT = 4;
    
    int command;
    do {
      System.out.println("\nPROVIDER TERMINAL");
      System.out.println("Enter a number between 1 and " + EXIT + " as explained below:");
	  System.out.println("  " + VERIFY_MEMBER + " to verify a member");
      System.out.println("  " + BILL_CHOCAN + " to Bill ChocAn");
      System.out.println("  " + VIEW_DIRECTORY + " to View the Provider Directory");
      System.out.println("  " + EXIT + " to Exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      switch (command) {
        case VERIFY_MEMBER:		  ChocAnApplication.verifyMember();
                                break;
        case BILL_CHOCAN:       Bill b = new Bill();
                                b.createBill();
                                Member member = new Member();
                                member.load(b.getMemberID());
                                member.addService(b);
                                member.save();
                                Provider provider = new Provider();
                                provider.load(b.getProviderID());
                                provider.addService(b);
                                provider.save();
                                break;
        case VIEW_DIRECTORY:    ProviderDirectory.printServices();
                                break;
      }
    } while (command != EXIT);
  }

  public static void displayManagerTerminal() {
    final int MEMBER_REPORT = 1;
    final int PROVIDER_REPORT = 2;
    final int SUMMARY_REPORT = 3;
    final int COMPUTE_WEEKLY_REPORT = 4;
    final int EXIT = 5;
    
    int command;
    do {
      System.out.println("\nMANAGER TERMINAL");
      System.out.println("Enter a number between 1 and " + EXIT + " as explained below:");
      System.out.println("  " + MEMBER_REPORT + " to create a Member Report");
      System.out.println("  " + PROVIDER_REPORT + " to create a Provider Report");
      System.out.println("  " + SUMMARY_REPORT + " to create a Summary Report");
      System.out.println("  " + COMPUTE_WEEKLY_REPORT + " to create and compute a Weekly Report");
      System.out.println("  " + EXIT + " to Exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      int id;
      switch (command) {
        case MEMBER_REPORT:     id = getNumber("Enter member ID: ", 0, 999999999);
                                MemberReport.printReport(id);
                                break;
        case PROVIDER_REPORT:   id = getNumber("Enter provider ID: ", 0, 999999999);
                                ProviderReport.printReport(id);
                                break;
        case SUMMARY_REPORT:    //displayOperatorTerminal();
                                break;
        case COMPUTE_WEEKLY_REPORT:    ComputeWeeklyReport.compute();
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
      System.out.println("Enter a number between 1 and " + EXIT + " as explained below:");
      System.out.println("  " + MANAGE_MEMBER + " to Manage a Member");
      System.out.println("  " + MANAGE_PROVIDER + " to Manage a Provider");
      System.out.println("  " + MANAGE_DIRECTORY + " to Manage the Provider Directory");
      System.out.println("  " + EXIT + " to Exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      
      switch (command) {
        case MANAGE_MEMBER:     ManagePerson.manageMember();
                                break;
        case MANAGE_PROVIDER:   ManagePerson.manageProvider();
                                break;
        case MANAGE_DIRECTORY:  ProviderDirectory.manage();
                                break;
      }
    } while (command != EXIT);
  }
}