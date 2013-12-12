import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.lang.*;

public class ComputeWeeklyReport {
  //Provider provider = new Provider();
 // Member member = new Member();
  
  public static void compute() {
    int memberCount = 0;
    int providerCount = 0;
    int totalFee = 0;
    int id = 0;
    File folder = new File("X:/Desktop/ChocAn");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            //System.out.println(file.getName());
            if(file.getName().startsWith("m")){
              id = Person.getFileID(file.getName());
              ProviderReport.printReport(id);
              memberCount++;
            }
            if(file.getName().startsWith("p")){
              id = Person.getFileID(file.getName());
              MemberReport.printReport(id);
              providerCount++;
            }
        }
    } 
    System.out.println(memberCount + " members in the directory.");
    System.out.println(providerCount + " providers in the directory.");
 
 
 /* 
    //open directory with providers (holds services provided)
    while (more providers exist) {
      provider = next provider in file
      printProviderReport(provider.id) 
   } 
   

    while (more members exist) {
      members = next members in file
      printManagerReport(members.id)
    }

    while (more EFT reports exist) {
      eft = next eft in file
      printEFTReport(eft.name)
      fee += amount to be transferred
    }

    print number of members
    print fee
    */
  }
  
}



