import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		//manage() used to manage all window related activities
		//maximize screen
		d1.manage().window().maximize();
		d1.manage().deleteAllCookies();
//		d1.manage().deleteCookieNamed("sessionCookie");
		
		//when using get method selenium internally waits till page load
		d1.get("https://www.google.co.in/");
		//when using navigate selenium will not wait till page load, synchronization issue
		//we have to use implicit wait and explicit wait
		d1.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		d1.navigate().back();
		Thread.sleep(1000);
		d1.navigate().forward();
		
		
		Thread.sleep(10000);
		d1.quit();

	}

}
