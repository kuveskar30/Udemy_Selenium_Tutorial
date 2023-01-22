import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) throws InterruptedException {

		// Invoking Browser
		// Chrome -- ChromeDriver -> has Methods to automate Chrome browser

//		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
//		WebDriver d1 = new ChromeDriver();

		// FireFox launch
		// geckodriver
//		System.setProperty("webdriver.gecko.driver",
//				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_gecko_driver\\geckodriver.exe");
//		WebDriver d1 = new FirefoxDriver();

		// Microsoft edge launch
		// edgedriver
		System.setProperty("webdriver.edge.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_edge_driver\\msedgedriver.exe");
		WebDriver d1 = new EdgeDriver();

		d1.get("https://rahulshettyacademy.com");
		System.out.println(d1.getTitle());// returns title of page

		// helps to ensure that we have visited expected URL or not
		System.out.println(d1.getCurrentUrl());

		Thread.sleep(10000);
		d1.close();// only current window is closed
//		d1.quit();//every associated window closed

	}

}
