import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ProviderReport {

  public ProviderReport() {}

  Provider provider = new Provider();
  
  FileOutputStream outStream = null;
  PrintStream pStream = null;
  int i;
  char c;
  double feeTotal = 0;
  int membersConsulted = 0;
  File outFile;
  
  public void printReport(int id) {
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
        Service service = (Service)(services.next());
        pStream.print(service.getDateOfService() + "\n"); 
        pStream.print(service.getDateReceived() + "\n"); 
        pStream.print(service.getMemberName() + "\n"); 
        pStream.print(service.getMemberCode() + "\n"); 
        pStream.print(service.getCode() + "\n"); 
        pStream.print(service.getFee() + "\n"); 
        membersConsulted += 1;
        feeTotal += service.getFee();
      }
      
      pStream.print(membersConsulted + "\n"); 
      pStream.print(feeTotal + "\n"); 
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
  
}