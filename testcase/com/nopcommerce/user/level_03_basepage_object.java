package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.ImageInputStreamImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.constructor.CustomClassLoaderConstructor;

import baseObject.CustomerPageObject2;
import baseObject.HomePageObject;
import baseObject.LoginPageObject;
import baseObject.RegisterPageObject;
import common.basePage;

public class level_03_basepage_object {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAdd;
	//khai bÃ¡o vÃ  khá»Ÿi táº¡o nÃ³ lÃªn 
	private basePage basePage = new basePage();
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject2 customerPage;
	private String emailAddress = randomEmail();
	


	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdriver\\geckodriver.exe");
		driver = new FirefoxDriver();	
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		homePage = new HomePageObject(driver);

		
			
	}

	@Test
	public void tc_01_register_empty_data() {
		homePage.clickToRegisterLink();
		registerPage= new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getFistNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");
	}

	@Test
	public void tc_02_register_invalid_email() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage =  new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("nhun");
		registerPage.enterToLastNameTextbox("phan");
		registerPage.enterToEmailTextbox("nhun@gmail@@@.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Wrong email");
		

	}

	@Test
	public void tc_03_register_success() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage =  new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("nhun");
		registerPage.enterToLastNameTextbox("phan");
		registerPage.enterToEmailTextbox(emailAddress);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getSuccessMessageText(), "Your registration completed");
		
	}

	@Test
	public void tc_04_register_existing_email() {
		
		
		
	}

	@Test
	public void tc_05_register_pass_lessthan_6() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("nhun");
		registerPage.enterToLastNameTextbox("phan");
		registerPage.enterToEmailTextbox("nhun@gmail.com");
		registerPage.enterToPasswordTextbox("123");
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password must meet the following rules:\n"
						+ "must have at least 6 characters");
	}

	@Test
	public void tc_06_register_comfirm_pass() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage =  new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextbox("nhun");
		registerPage.enterToLastNameTextbox("phan");
		registerPage.enterToEmailTextbox("nhun@gmail.com");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "The password and confirmation password do not match.");
	}
	
	@Test
	public void tc_07_login() {
		registerPage.clickToNopCommerceLogo();
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		// qay lại trang home
		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();
		customerPage = new CustomerPageObject2(driver);
		
		Assert.assertEquals(customerPage.getFirstNameTextboxAttributeValue(), "nhun");
		Assert.assertEquals(customerPage.getLastNameTextboxAttributeValue(), "phan");
		Assert.assertEquals(customerPage.getEmailTextboxAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
	}

	public  String randomEmail() {
		Random rand = new Random();
		return "nhun" + rand.nextInt(99999) + "@gmail.com";

	}
}
