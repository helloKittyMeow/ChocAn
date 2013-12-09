import java.io.BufferedWriter; 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.*;
import java.util.*;
import java.text.*;


class Member {
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private final static int ACTIVE = 1;
	private final static int SUSPENDED = 2;
	private String name;
	private int id;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private int active;
	
	public Member(){
		name = null;
		id = 0;
		streetAddress = null;
		city = null;
		state = null;
		zipCode = 0;
		active = 0;
	}
	
	//This method returns the name of a member
	public String getName(){
	  return name;
	}

	//This method sets the name of a member
	public void setName(String name){
	  this.name = name;
	}

	//This method returns the id of a member
	public int getID(){
	  return id;
	}

	//This method sets the id of a member
	public void setID(int id){
	  this.id = id;
	}

	//This method returns the street address of a member
	public String getStreetAddress(){
	  return streetAddress;
	}

	//This method sets the street address of a member
	public void setStreetAddress(String streetAddress){
	  this.streetAddress = streetAddress;
	}

	//This method returns the city of a member
	public String getCity(){
	  return city;
	}

	//This method sets the city of a member
	public void setCity(String city){
	  this.city = city;
	}

	//This method returns the state of a member
	public String getState(){
	  return state;
	}

	//This method sets the state of a member
	public void setState(String state){
	 this.state = state;
	}

	//This method returns the zipcode of a member
	public int getZipCode(){
	  return zipCode;
	}

	//This method sets the zipcode of a member
	public void setZipCode(int zipCode){
	  this.zipCode = zipCode;
	}

	//This method gets the status of a member
	public int getStatus(){
	  return active;
	}

	//This method sets the status of a member
	public void setStatus(int active){
	  this.active = active;
	}

	/*
	//This method adds a service to a member
	public void addService(Bill service){
	   services.add(service);
	}
	
	
	//This method returns services of a member
	public Iterator getServices(){
	   return services;
	}
	*/
	
	//This method writes member data to a file.
	public void save(){
		String file_name = id + ".txt";
		try {
			File file = new File(file_name);
	
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name);
			bw.newLine();
			String ID = id + "";
			bw.write(ID);
			bw.newLine();
			bw.write(streetAddress);
			bw.newLine();
			bw.write(city);
			bw.newLine();
			bw.write(state);
			bw.newLine();
			String ZIP = zipCode + "";
			bw.write(ZIP);
			bw.newLine();
			String ACTIVE = active + "";
			bw.write(ACTIVE);
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
				else if (count == 2){
				    setStreetAddress(strLine);
					count++;
				}
				else if (count == 3){
				    setCity(strLine);
					count++;
				}
				else if (count == 4){
				    setState(strLine);
					count++;
				}
				else if (count == 5){
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
				else if (count == 6){
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
		}
		//Close the input stream
		br.close();
		}catch (Exception e){//Catch exception if any
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
		int i = 0;
		Member member = new Member();
		DataInputStream input = new DataInputStream(System.in);
		String temp;
		
		name = getToken("Enter the member name: ");
		id = getNumber("Enter the member id: ");
		streetAddress = getToken("Enter the member streetAddress: ");
		city = getToken("Enter the member city: ");
		state = getToken("Enter the member state: ");
		zipCode = getNumber("Enter the member zipCode: ");
		active = getNumber("Enter the member active: ");
		
		save();
	}

	//This method removes a member.
	public int removeMember(int id){
		String file_name = id + ".txt";
		Member member = new Member();
		File f = new File(file_name);
		if (f.exists()){
			boolean success = f.delete();
			if (success){
				System.out.println("Deleted: " + file_name);
			}
			return 0;
		}
		if (!f.exists()){
			System.out.println("No such member: " + file_name);
			return 1;
		}
		return 0;
	}






}