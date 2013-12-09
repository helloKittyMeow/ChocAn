import java.io.BufferedWriter; 
import java.io.BufferedReader; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.IOException;
import java.io.DataInputStream;


class Member {
	
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
		try{
			File file = new File(file_name);
	 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(name);
			bw.newLine();
			bw.write(id);
			bw.newLine();
			bw.write(streetAddress);
			bw.newLine();
			bw.write(city);
			bw.newLine();
			bw.write(state);
			bw.newLine();
			bw.write(zipCode);
			bw.newLine();
			bw.write(active);
			bw.close();
	 
			System.out.println("Done writing.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//This method reads member file.
	public void load(int id){
		String file_name = id + ".txt";
		Member member = new Member();
		try{

			BufferedReader br = new BufferedReader(new FileReader(file_name));
			String strLine;
			//Read File Line By Line
			while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  System.out.println (strLine);
		}
		//Close the input stream
		br.close();
		}catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		}
	}

	

	//This method adds a member.
	public void addMember(){ 
		int i = 0;
		Member member = new Member();
		DataInputStream input = new DataInputStream(System.in);
		String temp;
	
		System.out.print("Enter the member name: ");
		this.name = input.readLine();
		System.out.print("Enter the member id: ");
		temp = input.readLine();
		try{
			i = Integer.parseInt(temp.trim());
		}
		catch (NumberFormatException nfe)
		{
		  System.out.println("NumberFormatException: " + nfe.getMessage());
		}

		this.id = i;
		System.out.print("Enter the member streetAddress: ");
		this.streetAddress = input.readLine();
		System.out.print("Enter the member city: ");
		this.city = input.readLine();
		System.out.print("Enter the member state: ");
		this.state = input.readLine();
		System.out.print("Enter the member zipCode: ");
		temp = input.readLine();
		try{
			i = Integer.parseInt(temp.trim());
		}
		catch (NumberFormatException nfe)
		{
		  System.out.println("NumberFormatException: " + nfe.getMessage());
		}
		this.zipCode = i;
		System.out.print("Enter the member active: ");
		temp = input.readLine();
		try{
			i = Integer.parseInt(temp.trim());
		}
		catch (NumberFormatException nfe)
		{
		  System.out.println("NumberFormatException: " + nfe.getMessage());
		}
		this.active = i;
	/*	
		Get member info from the user;

		set all the member info data;

		save the member to a file (“id.txt”)
		*/

	}

/*
	public int removeMember(int id)

	This method removes a member.

	{

	  open a file (“id.txt”). 

	 If found delete the file and print a “Deleted” message.

	  Else print “No such member”.

	}
*/





}