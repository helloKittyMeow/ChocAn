import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SummaryReport {
  private static final String directoryName = "SummaryReports";
  
  public static void printReport() {
  
    Provider provider = new Provider();
    int membersConsulted = 0;
    double feeTotal = 0;
    int providersWithServices = 0;
  
    int providerConsultations = 0;
    double providerFeeTotal = 0;
    double tempFee = 0;
    
    FileOutputStream outStream = null;
    PrintStream pStream = null;
    File outFile = null;
    
    try {
      File directory = new File(directoryName);
      directory.mkdirs();
      DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
      Date date = new Date();
  //    System.out.println(dateFormat.format(date));
      outFile = new File("./" + directoryName + "/" + "Summary" + " " + dateFormat.format(date) + ".txt");
      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      File folder = new File("./");
      File[] listOfFiles = folder.listFiles();

      for (File file : listOfFiles) {
        providerConsultations = 0;
        providerFeeTotal = 0;
        tempFee = 0;
        
        if (file.isFile() && file.getName().startsWith("p")) {
          provider.load(Person.getFileID(file.getName()));
          Iterator services = provider.getServices();
          
          //check if any services exist
          if (services.hasNext()) {
            providersWithServices++;
            pStream.println("Provider Name: " + provider.getName()); 
          }
          
          while (services.hasNext()) {
            Bill service = (Bill)(services.next());
            tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
    //        System.out.println("tempFee is " + tempFee);
            providerConsultations += 1;
            providerFeeTotal += tempFee;
          }
          
          pStream.println("Number of Consultations: " + providerConsultations);
          pStream.println("Provider Fee Total: " + String.format("$%.2f", providerFeeTotal));
          pStream.println();
        }
        
        membersConsulted += providerConsultations;
        feeTotal += providerFeeTotal;
      }
      
      pStream.println("Providers With Services: " + providersWithServices); 
      pStream.println("Total Members Consulted: " + membersConsulted); 
      pStream.println("Total Fee: " + String.format("$%.2f", feeTotal)); 
      
      pStream.close();
      System.out.println("\nSaved Summary Report");
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}