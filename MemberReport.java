import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MemberReport {
  
  
  public static void printReport(int id) {
  
    Member member = new Member();
  
    FileOutputStream outStream = null;
    PrintStream pStream = null;
    File outFile;
  
    try {
      member.load(id);
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      outFile = new File("./MemberReports/" + member.getName() + " " + dateFormat.format(date) + ".txt");
      outFile.createNewFile();
      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      /* Message to print to file */
      pStream.println("Name: " + member.getName());
      pStream.println("ID: " + member.getID());
      pStream.println("Address: " + member.getStreetAddress());
      pStream.println("City: " + member.getCity());
      pStream.println("State: " + member.getState());
      pStream.println("Zip: " + member.getZipCode());
      pStream.println();
      Iterator services = member.getServices();
      while (services.hasNext()) {
        Bill service = (Bill)(services.next());
        pStream.println("Date Service Provided: " + service.getDateServiceProvided()); 
        pStream.println("Provider ID: " + service.getProviderID()); 
        pStream.println();
        //might need to find name via service id number in provider directory or something
  //      pStream.print(service.getServiceName() + "\n"); 
      }
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
  
}