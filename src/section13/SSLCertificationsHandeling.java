package section13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCertificationsHandeling {

	public static void main(String[] args) throws InterruptedException {
		//below are ways to modify browse behavior by Using ChromeOptions
		//by Using ChromeOptions most commonly used things are
		// 1. handling ssl certifications
		// 2. setting proxy
		// 3. blocking pop-ups like allow access location etc.
		// 4. change default directory for download
		// 5. addExtensions
		// below mentioned website has code for all above things
		// https://chromedriver.chromium.org/capabilities
		
		
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		// 1. chrome browser launching
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver(options);

//		FirefoxOptions options1 = new FirefoxOptions();
//		options1.setAcceptInsecureCerts(true);
		// 2.FireFox Browser
//		System.setProperty("webdriver.gecko.driver",
//				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_gecko_driver\\geckodriver.exe");
//		WebDriver d1 = new FirefoxDriver();

		//EdgeOptions options2 = new EdgeOptions()
		//options2.setAcceptInsecureCerts(true);
		// 3.Edge Browser
//		System.setProperty("webdriver.edge.driver",
//				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_edge_driver\\msedgedriver.exe");
//		WebDriver d1 = new EdgeDriver();

		

		d1.get("https://expired.badssl.com/");

		Thread.sleep(15000);
		d1.quit();

	}

}
