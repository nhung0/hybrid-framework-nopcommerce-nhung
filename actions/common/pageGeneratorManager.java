package common;

import org.openqa.selenium.WebDriver;

import baseObject.CustomerPageObject2;
import baseObject.HomePageObject;
import baseObject.LoginPageObject;
import baseObject.RegisterPageObject;
import baseObject.addressPageObject;
import baseObject.orderPageObject2;

public class pageGeneratorManager {
	public  static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	
	public  static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		
	}
	
	public  static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	
	public  static CustomerPageObject2 getCustomerPage(WebDriver driver) {
		return new CustomerPageObject2(driver);
		
	}
	
	public  static addressPageObject getAddressPage(WebDriver driver) {
		return new addressPageObject(driver);
		
	}
	
	public  static orderPageObject2 getOrderPage(WebDriver driver) {
		return new orderPageObject2(driver);
		
	}

	
}
