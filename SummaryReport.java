import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SummaryReport {

  static Provider provider = new Provider();
  
  static FileOutputStream outStream = null;
  static PrintStream pStream = null;
  static File outFile;
  
  static int membersConsulted = 0;
  static double feeTotal = 0;
  static int providersWithServices = 0;
  
  static double providerConsultations;
  static double providerFeeTotal;
  static double tempFee;
  
  public static void printReport() {
    try {
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
      
      File folder = new File("/Users/you/folder/");
      File[] listOfFiles = folder.listFiles();

      for (File file : listOfFiles) {
        providerConsultations = 0;
        providerFeeTotal = 0;
        tempFee = 0;
        if (file.isFile() && file.getName().startsWith("p")) {
          provider.load(Person.getFileID());
          Iterator services = provider.getServices();
          
          //check if any services exist
          if (services.hasNext()) {
            providersWithServices++;
            pStream.print(provider.getName() + "\n"); 
          }
          
          while (services.hasNext()) {
            Bill service = (Bill)(services.next());
            tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
            providerConsultations += 1;
            providerFeeTotal += tempFee;
          }
          
          pStream.print(providerConsultations + "\n");
          pStream.print(providerFeeTotal + "\n\n");
        }
        
        membersConsulted += providerConsultations;
        feeTotal += providerFeeTotal;
      }
      
      pStream.print(providersWithServices + "\n"); 
      pStream.print(membersConsulted + "\n"); 
      pStream.print(feeTotal + "\n"); 
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}