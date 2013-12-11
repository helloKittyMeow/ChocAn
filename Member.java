import java.io.*;
import java.util.*;
import java.text.*;


public class Member extends Person {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private final static int ACTIVE = 1;
	private final static int SUSPENDED = 2;
	private List services;
	private int active;
	
	public Member() {
		super();
		active = 0;
    services = new LinkedList();
	}

	//This method gets the status of a member
	public int getStatus() {
	  return active;
	}

	//This method sets the status of a member
	public void setStatus(int active) {
	  this.active = active;
	}

	
	//This method adds a service to a member
	public void addService(Bill service){
	  services.add(service);
	}
	
	
	//This method returns services of a member
	public Iterator getServices(){
	 // return services;
    return (services.listIterator());
	}
	
	//This method writes member data to a file.
	public void save() {
		String file_name = getID() + ".txt";
		try {
			File file = new File(file_name);
	
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(getName());
			bw.newLine();
			String ID = getID() + "";
			bw.write(ID);
			bw.newLine();
			bw.write(getStreetAddress());
			bw.newLine();
			bw.write(getCity());
			bw.newLine();
			bw.write(getState());
			bw.newLine();
			String ZIP = getZipCode() + "";
			bw.write(ZIP);
			bw.newLine();
			String ACTIVE = active + "";
			bw.write(ACTIVE);
      bw.newLine();
      
      for (Iterator iterator = services.iterator(); iterator.hasNext(); ) {
			  Bill bill = (Bill) iterator.next();
        bw.write(bill.getDateCreated());
        bw.newLine();
        bw.write(bill.getDateServiceProvided());
        bw.newLine();
        String providerID = bill.getProviderID() + "";
        bw.write(providerID);
        bw.newLine();
        String memberID = bill.getMemberID() + "";
        bw.write(memberID);
        bw.newLine();
        String serviceCode = bill.getServiceCode() + "";
        bw.write(serviceCode);
        bw.newLine();
        bw.write(bill.getComments());
        bw.newLine();
			}
			bw.close();
	 
			System.out.println("Done writing.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//This method reads member file.
	public void load(int id) {
		String file_name = id + ".txt";
		Member member = new Member();
		int count = 0;
    int count2 = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file_name));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null) {
			  // Print the content on the console
        if (count == 0){
          setName(strLine);
          count++;
        }
        else if (count == 1) {
          try{
            // the String to int conversion happens here
            int i = Integer.parseInt(strLine.trim());
            setID(i);
          }
          catch (NumberFormatException nfe){
            System.out.println("NumberFormatException: " + nfe.getMessage());
          }
          count++;
        }
        else if (count == 2) {
          setStreetAddress(strLine);
          count++;
        }
        else if (count == 3) {
          setCity(strLine);
          count++;
        }
        else if (count == 4) {
          setState(strLine);
          count++;
        }
				else if (count == 5) {
				  try{
						// the String to int conversion happens here
						int i = Integer.parseInt(strLine.trim());
						setZipCode(i);
					}
					catch (NumberFormatException nfe){
						System.out.println("NumberFormatException: " + nfe.getMessage());
					}
					count++;
				}
				else if (count == 6) {
				  try{
						// the String to int conversion happens here
						int i = Integer.parseInt(strLine.trim());
						setStatus(i);
					}
					catch (NumberFormatException nfe){
						System.out.println("NumberFormatException: " + nfe.getMessage());
					}
					count++;
				}
        else if (count > 6) {
          Bill tempBill = new Bill();
          if(count2 == 0){
            tempBill.setDateCreated(strLine);
            count2++;
          }
          if(count2 == 1){
            tempBill.setDateServiceProvided(strLine);
            count2++;
          }
          if(count2 == 2){
            try {
              // the String to int conversion happens here
              int i = Integer.parseInt(strLine.trim());
              tempBill.setProviderID(i);
              count2++;
            }
            catch (NumberFormatException nfe){
              System.out.println("NumberFormatException: " + nfe.getMessage());
            }
          }
          if(count2 == 3){
            try {
              // the String to int conversion happens here
              int i = Integer.parseInt(strLine.trim());
              tempBill.setMemberID(i);
              count2++;
            }
            catch (NumberFormatException nfe){
              System.out.println("NumberFormatException: " + nfe.getMessage());
            }
          }
          if(count2 == 4){
            try {
              // the String to int conversion happens here
              int i = Integer.parseInt(strLine.trim());
              tempBill.setServiceCode(i);
              count2++;
            }
            catch (NumberFormatException nfe){
              System.out.println("NumberFormatException: " + nfe.getMessage());
            }
          }
          if(count2 == 5){
            tempBill.setComments(strLine);
            count2 = 0;
          }
          
          services.add(tempBill);
        }
      }
      
      //Close the input stream
      br.close();
		} catch (Exception e) {//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		}
	}

	public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
          System.exit(0);
      }
    } while (true);
	}
	
	public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
	}
	

	//This method adds a member.
	public void addMember(){ 
		setName(getToken("Enter the member name: "));
		setID(getNumber("Enter the member id: "));
		setStreetAddress(getToken("Enter the member streetAddress: "));
		setCity(getToken("Enter the member city: "));
		setState(getToken("Enter the member state: "));
		setZipCode(getNumber("Enter the member zipCode: "));
		active = ACTIVE;
		
		save();
	}

	//This method removes a member.
	public int removeMember(int id){
		String file_name = id + ".txt";
		File f = new File(file_name);
		if (f.exists()) {
			boolean success = f.delete();
			if (success) {
				System.out.println("Deleted: " + file_name);
			}
			return 0;
		} else {
			System.out.println("No such member: " + file_name);
			return 1;
		}
	}
  
  public String toString() {
    String string = "Member name: " + getName() + "\nid: " + getID() + "\naddress: " + getStreetAddress() + "\ncity: " + getCity() + "\nstate: " + getState() + "\nzipCode: " + getZipCode() + "\nstatus: " + getStatus();
    string += "\nBILLS: [";
    for (Iterator iterator = services.iterator(); iterator.hasNext(); ) {
      Bill bill = (Bill) iterator.next();
      string += " " + bill.getDateCreated();
      string += " " + bill.getDateServiceProvided();
      string += " " + bill.getProviderID();
      string += " " + bill.getMemberID();
      string += " " + bill.getServiceCode();
      string += " " + bill.getComments() + "\n";
    }
    string += "]";
    return string;
  }
}

