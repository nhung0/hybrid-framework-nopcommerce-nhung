package phoneFactory;

public abstract class PHONEfactory {
	protected String phoneName;
	protected abstract void setPhoneName(String phoneName);
	protected abstract String getPhoneName();
	
	//non-abstract
	protected void touchPhone() {
		
	};
	
	
}
