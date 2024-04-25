package phoneWithoutFactory;

public class endUser {
  public static void main(String[] args) {
	  //iphone
	  iphone ip = new iphone();
	  ip.setPhoneName("iphone 14");
	  System.out.println(ip.getPhoneName());
	  
	  
//samsung 
	  
	  samsung sam = new samsung();
	  ip.setPhoneName("samsung 14");
	  System.out.println(sam.getPhoneName());
	  
//reno
	  
	  reno re = new reno();
	  ip.setPhoneName("reno 14");
	  System.out.println(re.getPhoneName());
	  
	  }
}