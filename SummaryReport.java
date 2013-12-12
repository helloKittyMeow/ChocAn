import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SummaryReport {

  Provider provider = new Provider();
  Member member = new Member();
  
  FileOutputStream outStream = null;
  PrintStream pStream = null;
  int i;
  char c;  
  int membersConsulted = 0;
  double feeTotal = 0;
  File outFile;
  double tempFee = 0;
  
  public void printReport(int id) {
    try {
      provider.load(id);
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//exclude hhmmss?
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      outFile = new File("./SummaryReports/" + "Summary" + "_" + date + ".txt");

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
        Bill bill = (Bill)(services.next());
        pStream.print(bill.getDateCreated() + "\n"); 
        pStream.print(bill.getDateServiceProvided() + "\n");
        
        member.load(provider.getID());
        
        pStream.print(member.getName() + "\n"); 
        pStream.print(member.getID() + "\n"); 
        pStream.print(bill.getServiceCode() + "\n"); 
        
        //load service then get fee associated with it.
        tempFee = ProviderDirectory.getServiceFee(provider.getID());
        
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