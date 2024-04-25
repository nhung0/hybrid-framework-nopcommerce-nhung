package baseObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;

import common.basePage;
import pageUIs.LoginPageUIs;

public class LoginPageObject extends basePage{
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public void enterToPasswordTextbox(String string) {
		sendKeysToElment(driver, LoginPageUIs.PASSWORD_TEXTBOX, "123456");
		
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		sendKeysToElment(driver, LoginPageUIs.EMAIL_TEXTBOX,getEmailAddress());
		
	}

}
