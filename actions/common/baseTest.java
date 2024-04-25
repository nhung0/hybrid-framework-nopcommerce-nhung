package common;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class baseTest {
	private WebDriver driver;
	
	protected WebDriver getBrowserDriver(String browserName) {
		browserList browser = browserList.valueOf(browserName.toUpperCase());
		if (browser == browserList.FIREFOX) {
			// webdriverManagerVersion4.x_5.x
//			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdriver\\geckodriver.exe");
			// webdriverManagerVersion5.x
//			driver = WebDriverManager.firefoxdriver().create(); // tự động tải về browser và setting biến môi trường
			// selenium manager 
			driver = new FirefoxDriver();
			
		} else if (browser == browserList.CHROME) {
//			driver = WebDriverManager.chromedriver().driverVersion("124.3456.000").create();
			driver = new ChromeDriver();

		}else if (browser == browserList.OPERA) {
			
//			driver = WebDriverManager.operadriver().create();
			
		} else if (browser == browserList.EDGE) {
//			
//			driver = WebDriverManager.edgedriver().create();
			driver = new EdgeDriver();
			
		} else if (browser == browserList.IE) { // không chạy đc
//			driver = WebDriverManager.iedriver().arch32().create();
			
		}else if (browser == browserList.SAFARI) { // không chạy đc
//			driver = WebDriverManager.safaridriver().create();
		}
		else {
			throw new RuntimeException("browser name is not correct");
			
		}
		
//		switch (browser) {
//		case FIREFOX: 
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserdriver\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		case CHROME: 
//			ystem.setProperty("webdriver.chrome.driver", projectPath + "\\browserdriver\\chromedriver.exe");
//			driver = new ChromeDriver();
//		case OPERA: 
//			System.setProperty("webdriver.opera.driver", projectPath + "\\browserdriver\\operadriver.exe");
//			driver = new OperaDriver();
//		case EDGE: 
//			System.setProperty("webdriver.edge.driver", projectPath + "\\browserdriver\\msedgedriver.exe");
//			driver = new EdgeDriver();
//			break;
//
//		default:
//			throw new RuntimeException("browser name is not correct");
//			break; 
//		}
		
		driver.manage().window().setPosition(new Point(0, 0));
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(15));
		return driver;
	}
	
	public  String randomEmail() {
		Random rand = new Random();
		return "nhun" + rand.nextInt(99999) + "@gmail.com";

	}
	
	protected void closeBrowser() {
		if (driver == null) {
			System.out.print("browser is closed");
			
		}else {
			driver.quit();
		}
	}
}
