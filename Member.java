import java.util.*;

public class Member {
  static final int SUSPENDED = 0;
  static final int ACTIVE = 1;
  private String name;
  private int id;
  private String streetAddress;
  private String city;
  private String state;
  private int zipCode;
  private int active;
  private List<Service> services;
  
  public String getName()
This method returns the name of a member
{
  return name;
}

public void setName(String name)
This method sets the name of a member
{
  this.name = name;
}

public int getID()
This method returns the id of a member
{
  return id;
}

public void setID(int id)
This method sets the id of a member
{
  this.id = id;
}

public String getStreetAddress()
This method returns the street address of a member
{
  return streetAddress;
}

public void setStreetAddress(String streetAddress)
This method sets the street address of a member
{
  this.streetAddress = streetAddress;
}

public String getCity()
This method returns the city of a member
{
  return city;
}

public void setCity(String city)
This method sets the city of a member
{
  this.city = city;
}

public String getState()
This method returns the state of a member
{
  return state;
}

public void setState(String state)
This method sets the state of a member
{
 this.state = state;
}

public int getZipCode()
This method returns the zipcode of a member
{
  return zipCode;
}

public void setZipCode(int zipCode)
This method sets the zipcode of a member
{
  this.zipCode = zipCode;
}

public int getStatus()
This method gets the status of a member
{
  return active;
}

public void setStatus(int active)
This method sets the status of a member
{
  this.active = active;
}

public void addService(Bill service)
This method adds a service to a member
{
   services.add(service);
}

public Iterator getServices()
This method returns services of a member
{
   return services;
}

public void save()
This method writes member data to a file.
{
  create a file (“id.txt”) if it doesn’t exist;
  otherwise write member data to a file.
}

public void load(int id)
This method reads member file.
{
  Member member.
  open a file (“id.txt”).
  read name and setName(name);
  setID(id);
  read street_address and setStreetAddress(street_address);
  read city and setCity(city);
  read state and setSate(state);
  read zip_code and setZipCode(zip_code);
  read status and setStatus(status);
  read services and for each service addService(services);
}

public void addMember()
This method adds a member.
{ 
  Member member = new Member();
  Get member info from the user;
  set all the member info data;
  save the member to a file (“id.txt”)
}

public int removeMember(int id)
This method removes a member.
{
  open a file (“id.txt”). 
  If found delete the file and print a “Deleted” message.
  Else print “No such member”.
}
