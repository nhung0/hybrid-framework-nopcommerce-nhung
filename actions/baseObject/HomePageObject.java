package baseObject;

import org.openqa.selenium.WebDriver;

import common.basePage;
import common.pageGeneratorManager;
import pageUIs.CustomerPageUIs;
import pageUIs.HomePageUIs;
import pageUIs.LoginPageUIs;

public class HomePageObject extends basePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementInClickable(driver, HomePageUIs.REGISTER_LINK);
		clickToElement(driver, HomePageUIs.REGISTER_LINK);
		return pageGeneratorManager.getRegisterPage(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementInClickable(driver, LoginPageUIs.LOGIN_LINK);
		clickToElement(driver, LoginPageUIs.LOGIN_LINK);
		return pageGeneratorManager.getLoginPage(driver);
		
	}

	public CustomerPageObject2 clickToMyAccountLink() {
		waitForElementInClickable(driver, CustomerPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, CustomerPageUIs.MY_ACCOUNT_LINK);
		return pageGeneratorManager.getCustomerPage(driver);
		
	}

}
