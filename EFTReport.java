import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EFTReport {

  static Provider provider = new Provider();
  
  static FileOutputStream outStream = null;
  static PrintStream pStream = null;
  static File outFile;
  
  static double providerFeeTotal;
  static double tempFee;
  
  public static void printReport() {
    try {
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//exclude hhmmss?
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      outFile = new File("./EFTReports/" + "Summary" + "_" + date + ".txt");

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
        providerFeeTotal = 0;
        tempFee = 0;
        if (file.isFile() && file.getName().startsWith("p")) {
          provider.load(Person.getFileID(file.getName()));
          Iterator services = provider.getServices();
          
          //check if any services exist
          if (services.hasNext()) {
            pStream.print(provider.getName() + "\n"); 
            pStream.print(provider.getID() + "\n"); 
          }
          
          while (services.hasNext()) {
            Bill service = (Bill)(services.next());
            tempFee = ProviderDirectory.getServiceFee(service.getServiceCode());
            providerFeeTotal += tempFee;
          }
          
          pStream.print(providerFeeTotal + "\n\n");
        }
      }
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
}