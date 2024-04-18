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

public class level_01_DRY {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAdd;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		emailAdd = "nhun" + randomEmail() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void tc_01_register_empty_data() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(),
				"First name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(),
				"Last name is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
				"Password is required.");
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"Password is required.");

	}

	@Test
	public void tc_02_register_invalid_email() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("nhun");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("phan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys("@@");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");

	}

	@Test
	public void tc_03_register_success() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("nhun");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("phan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdd);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

	}

	@Test
	public void tc_04_register_existing_email() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("nhun");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("phan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdd);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-summary-errors li")).getText(),
				"The specified email already exists");

	}

	@Test
	public void tc_05_register_pass_lessthan_6() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("nhun");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("phan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdd);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("div#Password-error")).getText(),
				"Password must meet the following rules: must have at least 6 characters");

	}

	@Test
	public void tc_016_register_comfirm_pass() {
		driver.findElement(By.cssSelector("a.ico-register")).click();
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("nhun");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("phan");
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAdd);
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#register-button")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
				"The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
	}

	public static int randomEmail() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}
}
