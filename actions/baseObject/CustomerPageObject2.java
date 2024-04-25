package baseObject;

import org.openqa.selenium.WebDriver;

import common.basePage;
import pageUIs.CustomerPageUIs;

public class CustomerPageObject2 extends basePage{
	WebDriver driver;
	public CustomerPageObject2(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUIs.FIRSTNAME_TEXTBOX);
		return getElmentAttribute(driver, CustomerPageUIs.FIRSTNAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUIs.LASTTNAME_TEXTBOX);
		return getElmentAttribute(driver, CustomerPageUIs.LASTTNAME_TEXTBOX, "value");
	}

	public String getEmailTextboxAttributeValue() {
		waitForElementVisible(driver, CustomerPageUIs.EMAIL_TEXTBOX);
		return getElmentAttribute(driver, CustomerPageUIs.EMAIL_TEXTBOX, "value");
	}

}
