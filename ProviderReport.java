import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProviderReport {
  
  static Provider provider = new Provider();
  static Member member = new Member();
  
  static FileOutputStream outStream = null;
  static PrintStream pStream = null;
  int i;
  char c;
  static double feeTotal = 0;
  static int membersConsulted = 0;
  static File outFile;
  static double tempFee = 0;
  
  public static void printReport(int id) {
    try {
      provider.load(id);
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//exclude hhmmss?
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      outFile = new File("./MemberReports/" + provider.getName() + "_" + date + ".txt");

      if (outFile.exists()) {
        outFile.delete();
      } else {
        outFile.createNewFile();
      }
      
      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      /* Message to print to file */
      pStream.print(provider.getName() + "\n");
      pStream.print(provider.getID() + "\n");
      pStream.print(provider.getStreetAddress() + "\n");
      pStream.print(provider.getCity() + "\n");
      pStream.print(provider.getState() + "\n");
      pStream.print(provider.getZipCode() + "\n");
      
      Iterator services = provider.getServices();
      while (services.hasNext()) {
        Bill service = (Bill)(services.next());
        pStream.print(service.getDateCreated() + "\n"); 
        pStream.print(service.getDateServiceProvided() + "\n"); 
        
        member.load(service.getMemberID());
    
        pStream.print(member.getName() + "\n"); 
        pStream.print(member.getID() + "\n"); 
    
        tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
    
        pStream.print(tempFee + "\n"); 
        membersConsulted += 1;
        feeTotal += tempFee;
      }
      
      pStream.print(membersConsulted + "\n"); 
      pStream.print(feeTotal + "\n"); 
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
  
}