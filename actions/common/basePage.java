package common;


import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class basePage {
//	WebDriver driver; // biến toàn cục
// tương tác là kiểu void: click, sendkeys, accept, cancel, select,...
// các hàm để lấy dữ liêu ra là string,int, webelement, list webelement...
	// k cần khởi tao đối tượng mà vẫn vào đươc hàm này
	public static basePage getBasePage() {
		return new basePage();
	}
	
	//web browser
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}
	
	
	public void sendkeyToElement(WebDriver driver, String element, String value) {
		driver.findElement(By.cssSelector(element)).sendKeys(value);
		
	}
	
	

	// mở 1 url
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
		// nếu như biến toàn cục và biến cục bộ cùng tên khi lấy biến toàn cục ta sẽ goi this   vd: this.driver.get...

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getPageSources(WebDriver driver) {
		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();

	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void refeshCurentPage(WebDriver driver) {
		driver.navigate().refresh();

	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		return explicitWait.until(ExpectedConditions.alertIsPresent());

	}
	
	

	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();

	}

	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();

	}

	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	public void sendkeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);

	}

	public void switchToWindowByTitle(WebDriver driver, String expectedId) {

		Set<String> allIDs =   driver.getWindowHandles(); // set string

		for (String id : allIDs) {

			driver.switchTo().window(id);

			String actualTitle = driver.getTitle();
			if (actualTitle.equals(expectedId)) {
				break;

			}
		}

	}

	public void closeAllWindowWithoutParent(WebDriver driver, String expectedParent) {
		Set<String> allIDs =  driver.getWindowHandles();
		for (String id : allIDs) {
			if (!id.equals(expectedParent)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedParent);
	}
	
	
	public Set<Cookie> getBrowserCookie(WebDriver driver) {
		 return driver.manage().getCookies();
	}
	
	
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		  for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
	}
	 public void deleteAllCookies(WebDriver driver) {
		driver.manage().deleteAllCookies();
	}
	
	
	
	
	//web element 
	 // viết một hàm lặp 
	 public By getByXpath(String locator) {
		 return By.xpath(locator);
	 }
	 
	 public WebElement getElement(WebDriver driver, String locator) {
		 return driver.findElement(getByXpath(locator));
		 
		
	}
	 public List<WebElement> getElements(WebDriver driver, String locator) {
		 return driver.findElements(getByXpath(locator));
		 
		
	}
	 
	 public void clickToElment(WebDriver driver, String locator) {
		 getElement(driver, locator).click();
		
	}
	 
	 public void sendKeysToElment(WebDriver driver, String locator, String value) {
		 getElement(driver, locator).clear();
		 getElement(driver, locator).sendKeys(value);
		
	}
	 
	 
	 
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String iTemValue) {
		 new Select(getElement(driver, locator)).selectByVisibleText(iTemValue);
	}
	
	public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator, String iTemValue) {
		 return new Select(getElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getElement(driver, locator)).isMultiple();
	}
	
	 
	public void selectIteminDropdown(WebDriver driver, String parentxPath, String childLocator, String expectedItemText) {
		
			getElement(driver, parentxPath).click();
			
			
			List<WebElement> speedDropdownItems = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
			
	
			for (WebElement tempItem : speedDropdownItems) {
				
				
				if (tempItem.getText().trim().equals(expectedItemText)) {
					tempItem.click();
				
					break;
				}
			}
		}
	
	public String getElmentText(WebDriver driver, String locator) {
		 return getElement(driver, locator).getText();
		 
		
	}
		
	public String getElmentAttribute(WebDriver driver, String locator, String attributeName) {
		 return getElement(driver, locator).getAttribute(attributeName);
		 
		
	}
	
	public String getElmentCssValue(WebDriver driver, String locator, String cssPropertyName) {
		 return getElement(driver, locator).getCssValue(cssPropertyName);
		 
		
	}
	
	public String convertRgbaToHexaColor(WebDriver driver, String locator, String cssPropertyName) {
		
		return Color.fromString(getElmentCssValue(driver, locator, "background-color")).asHex();
		
	}
	
	public int getListElmentSize(WebDriver driver, String locator) {
		  return getElements(driver, locator).size();
		 
		
	}
		
	/** apply for checkbox and radio button
	 * @param driver
	 * @param locator
	 */
	public void checkToElement(WebDriver driver, String locator) {
		 if (!getElement(driver, locator).isSelected()) {
			 getElement(driver, locator).click();
			
		}
		
	}
	
	/** only apply for checkbox 
	 * @param driver
	 * @param locator
	 */
	public void uncheckToElement(WebDriver driver, String locator) {
		 if (getElement(driver, locator).isSelected()) {
			 getElement(driver, locator).click();
			
		}
	 
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
			return getElement(driver, locator).isDisplayed();
	}
	
	
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	
	
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	
	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXpath(locator)));
		
	}
	
	public void switchToDefaultContent(WebDriver driver) {
		 driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getElement(driver, locator)).perform();
	}
	
	public void doubleClickToElement(WebDriver driver, String locator) {
	 new Actions(driver).doubleClick(getElement(driver, locator)).perform();
	}
	
	public void rightClickToElement(WebDriver driver, String locator) {
		 new Actions(driver).contextClick(getElement(driver, locator)).perform();
		}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		 new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)) ;
		}
	
	
	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		 new Actions(driver).sendKeys(getElement(driver, locator),key ).perform();
		}
	
	public Object executeForBrowser(WebDriver driver,String javaScript) {
		return  ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		sleepInSecond(3);
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
		sleepInSecond(3);
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
	}

	public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue +"');", getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute(', " + attributeRemove + "');", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}

	public String getAttributeInDOM(WebDriver driver, String locator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		return (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getElement(driver, locator));
		
	}
	
	public String getEmailAddress () {
		Random rand = new Random();
		return "nhung" + rand.nextInt(99999) + "@gmail.net";
	}
	
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
		
		
	}
	
	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getElements(driver, locator)));
		
		
	}
	
	public void waitForElementInVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
		
		
	}
	
	public void waitForListElementInVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getElements(driver, locator)));
		
		
	}
	
	public void waitForElementInClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getElement(driver, locator)));

		
	}


	
	

}