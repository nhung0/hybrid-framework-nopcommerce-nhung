package baseObject;

import org.openqa.selenium.WebDriver;

import common.basePage;
import pageUIs.RegisterPageUIs;

public class RegisterPageObject extends basePage{
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		waitForElementVisible(driver, RegisterPageUIs.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUIs.REGISTER_BUTTON);
		
	}

	public String getFistNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUIs.FIRSTNAME_ERROR_MSG);
		return getElmentText(driver, RegisterPageUIs.FIRSTNAME_ERROR_MSG);

	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUIs.EMAIL_ERROR_MSG);
		return getElmentText(driver, RegisterPageUIs.EMAIL_ERROR_MSG);
	}

	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUIs.LASTNAME_ERROR_MSG);
		return getElmentText(driver, RegisterPageUIs.LASTNAME_ERROR_MSG);
	}

	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUIs.PASSWORD_ERROR_MSG);
		return getElmentText(driver, RegisterPageUIs.PASSWORD_ERROR_MSG);
	}

	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUIs.COMFIRMPASSWORD_ERROR_MSG);
		return getElmentText(driver, RegisterPageUIs.COMFIRMPASSWORD_ERROR_MSG);
	}

	public HomePageObject clickToNopCommerceLogo() {
		waitForElementVisible(driver, RegisterPageUIs.NOP_COMMERCE_LOGO);
		clickToElement(driver, RegisterPageUIs.NOP_COMMERCE_LOGO);
		return new HomePageObject(driver);
	}

	public void enterToFirstNameTextbox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUIs.FIRSTNAME_TEXTBOX);
		sendKeysToElment(driver, RegisterPageUIs.FIRSTNAME_TEXTBOX, firstNameValue);
		
	}

	public void enterToLastNameTextbox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUIs.LASTTNAME_TEXTBOX);
		sendKeysToElment(driver, RegisterPageUIs.LASTTNAME_TEXTBOX, lastNameValue);
		
	}

	public void enterToEmailTextbox(String emailAddredss) {
		waitForElementVisible(driver, RegisterPageUIs.EMAIL_TEXTBOX);
		sendKeysToElment(driver, RegisterPageUIs.EMAIL_TEXTBOX,emailAddredss);
		
	}

	public void enterToPasswordTextbox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUIs.PASSWORD_TEXTBOX);
		sendKeysToElment(driver, RegisterPageUIs.PASSWORD_TEXTBOX, passwordValue);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitForElementVisible(driver, RegisterPageUIs.COMFIMPASSWORD_TEXTBOX);
		sendKeysToElment(driver, RegisterPageUIs.COMFIMPASSWORD_TEXTBOX, confirmPasswordValue);
		
	}

	public String getSuccessMessageText() {
		waitForElementVisible(driver,RegisterPageUIs.REGISTRATION_COMPLETED_MSG );
		return getElmentText(driver, RegisterPageUIs.REGISTRATION_COMPLETED_MSG);
		
	}
	
	
	
	
	
}
