package phuongdongda;

public class caffeeNEO {
	// thuộc tính : variable/property
	public String espresso = "cafe espresso";
	protected String  orangeFruit= "orange fruit";
	String lemon = "lemon Fruit";	
	private String neoCafe = "neo's cafe";
	
			
		
	
	//phương thức: method/function
	public void shipespresso() {
		System.out.println("ship cafe: " + espresso);
	}
	public void shiporange() {
		System.out.println("ship orange: " + orangeFruit);
	}
	 public void shiplemon() {
		System.out.println("ship lemon: " + lemon);
	}
	
	private void shipneo() {
		System.out.println("ship neo cafe: " + neoCafe);
	}
		
	public static void main(String[] args) {
		caffeeNEO neo = new caffeeNEO();
		neo.shipespresso();
		neo.shiporange();
		neo.shipneo();
	}
}
