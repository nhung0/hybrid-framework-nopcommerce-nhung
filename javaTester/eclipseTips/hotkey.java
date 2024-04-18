package eclipseTips;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class hotkey {
	WebDriver driver; // ctrl+d để xóa dòng
	String projectPath;
	String emailAdd;

	@BeforeClass
	public void beforeClass() {
		System.getProperty("webdriver.gecko.driver", projectPath + ("\\browserdriver\\geckodriver.exe"));
		driver = new FirefoxDriver();
		emailAdd = "nhun" + randomEmail() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	public static void main(String[] args) {

		// sau mỗi thao tác thì save lại luôn => ctrl+s
		// format dòng và khối lệnh ctrl+shift+f
		// import/ và remove thư viện ctr +shift+0 
		// đi vào xem code của hàm hay thư viện => f3

	}

}
