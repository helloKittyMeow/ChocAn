import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.lang.*;


public class ComputeWeeklyReport {
  Provider provider = new Provider();
  Member member = new Member();
  int totalFee = 0;

  //This method returns an ID of a given file
  public static int getFileID(String fileName){
    int idLength = 0;
    int intID = 0;
     
    idLength = (fileName.length() - 5);
    System.out.println("ID length: " + idLength);
    char [] string = new char[idLength];
    
    for (int i = 1; i <= idLength; i++)
      string[i-1] = fileName.charAt(i);
      
    String ID = new String(string);

    try {
      // the String to int conversion happens here
      intID = Integer.parseInt(ID);
    }
    catch (NumberFormatException nfe){
      System.out.println("NumberFormatException: " + nfe.getMessage());
    }
    return intID;
  }
  
  public static void compute() {
    int memberCount = 0;
    int providerCount = 0;
    int totalFee = 0;
    int id = 0;
    File folder = new File("/export/home/cs311/cs311114/ChocAn");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
        if (file.isFile()) {
            //System.out.println(file.getName());
            if(file.getName().startsWith("m")){
              id = getFileID(file.getName());
              memberCount++;
            }
            if(file.getName().startsWith("p"))
              providerCount++;
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



