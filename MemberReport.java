import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MemberReport {

  public MemberReport() {}

  Member member = new Member();
  
  FileOutputStream outStream = null;
  PrintStream pStream = null;
  int i;
  char c;
  
  File outFile;
  
  public void printReport(int id) {
    try {
      member.load(id);
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//exclude hhmmss?
      Date date = new Date();
      System.out.println(dateFormat.format(date));
      outFile = new File("./MemberReports/" + member.getName() + "_" + date + ".txt");

      if (outFile.exists()) {
        outFile.delete();
      } else {
        outFile.createNewFile();
      }

      outStream = new FileOutputStream(outFile);
      pStream = new PrintStream(outStream);
      
      /* Message to print to file */
      pStream.print(member.getName() + "\n");
      pStream.print(member.getID() + "\n");
      pStream.print(member.getStreetAddress() + "\n");
      pStream.print(member.getCity() + "\n");
      pStream.print(member.getState() + "\n");
      pStream.print(member.getZipCode() + "\n");
      
      Iterator services = member.getServices();
      while (services.hasNext()) {
        Service service = (Service)(services.next());
        pStream.print(service.dateServiceProvided() + "\n"); 
        pStream.print(service.getProvider() + "\n"); 
        //might need to find name via service id number in provider directory or something
        pStream.print(service.getServiceName() + "\n"); 
      }
      
      pStream.close();
      
    } catch (Exception e) {
      System.out.print(e);
    }
  }
  
}