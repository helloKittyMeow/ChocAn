
public abstract class Person {
  private String name;
  private int id;
  private String streetAddress;
  private String city;
  private String state;
  private int zipCode;
  
  public Person() {
    name = null;
    id = 0;
    streetAddress = null;
    city = null;
    state = null;
    zipCode = 0;
  }
  
  public abstract void save();
  public abstract void load(int id);
  
  //This method returns the name of a member
  public String getName() {
    return name;
  }

  //This method sets the name of a member
  public void setName(String name) {
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
    }catch (NumberFormatException nfe){
      System.out.println("NumberFormatException: " + nfe.getMessage());
    }
    
    return intID;
  }
}