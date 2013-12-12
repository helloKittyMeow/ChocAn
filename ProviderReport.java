import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProviderReport {
  private static final String directoryName = "ProviderReports";
  
  public static void printReport(int id) {
    
    Provider provider = new Provider();
    Member member = new Member();
    
    FileOutputStream outStream = null;
    PrintStream pStream = null;
    
    double feeTotal = 0;
    int membersConsulted = 0;
    File outFile;
    double tempFee = 0;
  
    try {
      provider.load(id);
    //  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //  Date date = new Date();
    //  System.out.println(dateFormat.format(date));
    //  outFile = new File("./ProviderReports/" + provider.getName() + " " + dateFormat.format(date) + ".txt");
      File directory = new File(directoryName);
      directory.mkdirs();
      String fileName = provider.getName() + " " + (new SimpleDateFormat("MM.dd.yyyy-HH.mm.ss").format(Calendar.getInstance().getTime())) + ".txt";
      
      outFile = new File("./" + directoryName + "/" + fileName);
      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      /* Message to print to file */
      pStream.println("Provider Name: " + provider.getName());
      pStream.println("Provider ID: " + provider.getID());
      pStream.println("Address: " + provider.getStreetAddress());
      pStream.println("City: " + provider.getCity());
      pStream.println("State: " + provider.getState());
      pStream.println("Zip: " + provider.getZipCode());
      pStream.println();
      
      Iterator services = provider.getServices();
      while (services.hasNext()) {
        Bill service = (Bill)(services.next());
        pStream.println("Date Service Provided: " + service.getDateServiceProvided());
        pStream.println("Date Bill Submitted: " + service.getDateCreated());
        
        member.load(service.getMemberID());
        pStream.println("Member Name: " + member.getName());
        pStream.println("Member ID: " + member.getID());
        pStream.println("Service Code: " + service.getServiceCode());
        tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
        pStream.println("Fee For Service: $" + tempFee);
        pStream.println();
        membersConsulted += 1;
        feeTotal += tempFee;
      }
      
      pStream.println("Members Consulted: " + membersConsulted); 
      pStream.println("Fee Total: $" + feeTotal); 
      pStream.println();
      
      pStream.close();
      
      System.out.println("\nSaved report for Provider " + id + " as " + fileName);
    } catch (Exception e) {
      System.out.print(e);
    }
  }
  
}