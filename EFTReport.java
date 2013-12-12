import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EFTReport {
  private static final String directoryName = "EFTReports";
  
  public static void printReport() {
  
    Provider provider = new Provider();
  
    FileOutputStream outStream = null;
    PrintStream pStream = null;
    File outFile;
  
    double providerFeeTotal;
    double tempFee;
  
    try {
      File directory = new File(directoryName);
      directory.mkdirs();
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
    //  System.out.println(dateFormat.format(date));
      outFile = new File("./" + directoryName + "/" + "EFT" + " " + dateFormat.format(date) + ".txt");
      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      File folder = new File("./");
      File[] listOfFiles = folder.listFiles();

      for (File file : listOfFiles) {
        providerFeeTotal = 0;
        tempFee = 0;
        if (file.isFile() && file.getName().startsWith("p")) {
          provider.load(Person.getFileID(file.getName()));
          Iterator services = provider.getServices();
          
          //check if any services exist
          if (services.hasNext()) {
            pStream.println("Provider Name: " + provider.getName()); 
            pStream.println("Provider ID: " + provider.getID()); 
          }
          
          while (services.hasNext()) {
            Bill service = (Bill)(services.next());
            tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
            providerFeeTotal += tempFee;
          }
          
          pStream.println("Provider Fee Total: " + providerFeeTotal);
          pStream.println();
        }
      }
      
      pStream.close();
      
      System.out.println("\nSaved new EFT Report");
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}