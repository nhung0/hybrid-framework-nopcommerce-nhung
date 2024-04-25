package phoneFactory;

public class endUser {
	 public static void main(String [] args) {
		 PHONEfactory phone;
		 phone = getPhone("iphone");
		 phone.setPhoneName("iphone 14");
		 System.out.println(phone.getPhoneName());;
		 
	 }
	
	public static PHONEfactory getPhone(String phoneType) {
		
		PHONEfactory phoneFactory = null;
		if(phoneType.equals("iphone")) {
			phoneFactory = new iphone();
		} else if (phoneType.equals("samsung")) {
			phoneFactory = new samsung ();
		} else {
			phoneFactory = new reno();
			
		}
		return phoneFactory;
		
	}
	
}
