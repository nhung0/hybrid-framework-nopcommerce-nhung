package baseObject;

import org.openqa.selenium.WebDriver;

import common.basePage;
import pageUIs.CustomerPageUIs;
import pageUIs.HomePageUIs;
import pageUIs.LoginPageUIs;

public class HomePageObject extends basePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterLink() {
		waitForElementInClickable(driver, HomePageUIs.REGISTER_LINK);
		clickToElement(driver, HomePageUIs.REGISTER_LINK);
		
	}

	public void clickToLoginLink() {
		waitForElementInClickable(driver, LoginPageUIs.LOGIN_LINK);
		clickToElement(driver, LoginPageUIs.LOGIN_LINK);
		
	}

	public void clickToMyAccountLink() {
		waitForElementInClickable(driver, CustomerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, CustomerPageUIs.MY_ACCOUNT_LINK);
		
	}

}
