

public class Test{
	public static void main(String[] args){

		System.out.println("Test prog!");

		Member m = new Member();
    Bill b = new Bill("gg", "bb", 999, 123, 777, "GOOD DAY SIR");
		m.addMember();
		m.load(123);
		
		
		System.out.println("In member class: \n");
		System.out.println(m.getName());
		System.out.println(m.getID());
		System.out.println(m.getStreetAddress());
		System.out.println(m.getCity());
		System.out.println(m.getState());
		System.out.println(m.getZipCode());
		System.out.println(m.getStatus());

		m.addService(b);
    System.out.println( m.toString());

	}
}