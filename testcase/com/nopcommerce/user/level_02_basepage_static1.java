package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.basePage;
import common.basePage;

public class level_02_basepage_static1 {
	private WebDriver driver;
	private  String projectPath = System.getProperty("user.dir");
	String emailAdd;
	//khai báo và khởi tạo nó lên 
	
	private basePage BasePage = basePage.getBasePage();

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		emailAdd = "nhun" + randomEmail() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
			
	}

	@Test
	public void tc_01_register_empty_data() {
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//@a[class='ico-register']");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		
		
		


		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='FirstName-error']"),"First name is required.");
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='LastName-error']"),"Last name is required.");
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='Email-error']"),"Email is required.");
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='Password-error']"),"Password is required.");
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
		
		
		


	}

	@Test
	public void tc_02_register_invalid_email() {
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//a[@class='ico-register']");
		
		BasePage.sendKeysToElment(driver, "//input[@id='FirstName']", "nhun");
		BasePage.sendKeysToElment(driver, "//input[@id='LastName']", "phan");
		BasePage.sendKeysToElment(driver, "//input[@id='Email']", "@@");
		BasePage.sendKeysToElment(driver, "//input[@id='Password']", "123456");
		BasePage.sendKeysToElment(driver, "//input[@id='ConfirmPassword']", "123456");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test
	public void tc_03_register_success() {
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//a[@class='ico-register']");
		
		BasePage.sendKeysToElment(driver, "//input[@id='FirstName']", "nhun");
		BasePage.sendKeysToElment(driver, "//input[@id='LastName']", "phan");
		BasePage.sendKeysToElment(driver, "//input[@id='Email']", emailAdd);
		BasePage.sendKeysToElment(driver, "//input[@id='Password']", "123456");
		BasePage.sendKeysToElment(driver, "//input[@id='ConfirmPassword']", "123456");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(BasePage.getElmentText(driver, "//div[@class='result']"), "Your registration completed");
		
	}

	@Test
	public void tc_04_register_existing_email() {
		
		
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//a[@class='ico-register']");
		
		BasePage.sendKeysToElment(driver, "//input[@id='FirstName']", "nhun");
		BasePage.sendKeysToElment(driver, "//input[@id='LastName']", "phan");
		BasePage.sendKeysToElment(driver, "//input[@id='Email']", emailAdd);
		BasePage.sendKeysToElment(driver, "//input[@id='Password']", "123456");
		BasePage.sendKeysToElment(driver, "//input[@id='ConfirmPassword']", "123456");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(BasePage.getElmentText(driver, "//div[@class='validation-summary-errors']/li"), "The specified email already exists");

	}

	@Test
	public void tc_05_register_pass_lessthan_6() {
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//a[@class='ico-register']");
		
		BasePage.sendKeysToElment(driver, "//input[@id='FirstName']", "nhun");
		BasePage.sendKeysToElment(driver, "//input[@id='LastName']", "phan");
		BasePage.sendKeysToElment(driver, "//input[@id='Email']", emailAdd);
		BasePage.sendKeysToElment(driver, "//input[@id='Password']", "123");
		BasePage.sendKeysToElment(driver, "//input[@id='ConfirmPassword']", "123");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		
		Assert.assertEquals(BasePage.getElmentText(driver, "//div[@class='Password-error']"), "Password must meet the following rules: must have at least 6 characters");


	}

	@Test
	public void tc_06_register_comfirm_pass() {
		BasePage.openPageUrl(driver, "https://demo.nopcommerce.com/");
		BasePage.clickToElement(driver, "//a[@class='ico-register']");
		
		BasePage.sendKeysToElment(driver, "//input[@id='FirstName']", "nhun");
		BasePage.sendKeysToElment(driver, "//input[@id='LastName']", "phan");
		BasePage.sendKeysToElment(driver, "//input[@id='Email']", emailAdd);
		BasePage.sendKeysToElment(driver, "//input[@id='Password']", "123");
		BasePage.sendKeysToElment(driver, "//input[@id='ConfirmPassword']", "123456");
		BasePage.clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(BasePage.getElmentText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
		

	}

	@AfterClass
	public void afterClass() {
	}

	public static int randomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}
}
