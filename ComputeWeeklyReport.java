import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.lang.*;

public class ComputeWeeklyReport {
  
  public static void compute() {
    int memberCount = 0;
    int providerCount = 0;
    double providerFeeTotal = 0;
    int id = 0;
    File folder = new File("./");
    File[] listOfFiles = folder.listFiles();
    File folder2 = new File("./EFTReports");
    File[] listOfFiles2 = folder2.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            if(file.getName().startsWith("m")){           
              id = Person.getFileID(file.getName());
              MemberReport.printReport(id); 
              memberCount++;
            }
            if(file.getName().startsWith("p")){
              id = Person.getFileID(file.getName());
              ProviderReport.printReport(id);
              providerCount++;
            }           
            EFTReport.printReport();
        }
    } 
    System.out.println(memberCount + " members in the directory.");
    System.out.println(providerCount + " providers in the directory.");
    System.out.println("Provider Fee Total: " + providerFeeTotal);
  }
}



