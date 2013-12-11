import java.util.*;
import java.io.*;

public class ManagePerson {
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

  public static void manageMember() { 
    final int ADD_MEMBER = 1;
    final int REMOVE_MEMBER = 2;
    final int ACTIVATE_MEMBER = 3;
    final int SUSPEND_MEMBER = 4;
    final int PRINT_MEMBER_INFO = 5;
    final int EXIT = 6;
    
    int command;
    do {
      System.out.println("\nMEMBER MANAGEMENT TERMINAL");
      System.out.println("Enter a number between 1 and 5 as explained below:");
      System.out.println("  " + ADD_MEMBER + " to add a member");
      System.out.println("  " + REMOVE_MEMBER + " to remove a member");
      System.out.println("  " + ACTIVATE_MEMBER + " to activate a member");
      System.out.println("  " + SUSPEND_MEMBER + " to suspend a member");
      System.out.println("  " + PRINT_MEMBER_INFO + " to print a member info");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);  
      Member m = new Member();
      
      switch (command) {
        case ADD_MEMBER:		    m.addMember();
                                break;
        case REMOVE_MEMBER:		  m.removeMember(getPersonID());
                                break;
        case ACTIVATE_MEMBER:		m.load(getPersonID());
                                m.setStatus(1);
                                System.out.println(m.toString());
                                m.save();
                                break;
        case SUSPEND_MEMBER:		m.load(getPersonID());
                                m.setStatus(2);
                                System.out.println(m.toString());
                                m.save();
                                break;
        case PRINT_MEMBER_INFO:	m.load(getPersonID());
                                System.out.println(m.toString());
                                break;
      }
    } while (command != EXIT);
  }
  
  public static void manageProvider() {
    final int ADD_PROVIDER = 1;
    final int REMOVE_PROVIDER = 2;
    final int EXIT = 3;
    
    int command;
    do {
      System.out.println("\nPROVIDER MANAGEMENT TERMINAL");
      System.out.println("Enter a number between 1 and 3 as explained below:");
      System.out.println("  " + ADD_PROVIDER + " to add a provider");
      System.out.println("  " + REMOVE_PROVIDER + " to remove a provider");
      System.out.println("  " + EXIT + " to exit");
      
      command = getNumber("Enter command: ", 1, EXIT);
      Provider p = new Provider();
      
      switch (command) {
        case ADD_PROVIDER:		p.addProvider();
                              break;
        case REMOVE_PROVIDER: p.removeProvider(getPersonID());
                              break;
      }
    } while (command != EXIT);  
  }
  
  public static int getPersonID() {
    int ID = 0;
    ID = getNumber("Enter the ID: ", 1, 999999);
    return ID;
  }

}