package HandlingMouseActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://the-internet.herokuapp.com/");
		
		d1.findElement(By.linkText("Multiple Windows")).click();
		
		d1.findElement(By.linkText("Click Here")).click();
		
		Set<String> windows = d1.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parent_window = it.next();
		String child_window = it.next();
		
		d1.switchTo().window(child_window);
		
		System.out.println(d1.findElement(By.cssSelector(".example h3")).getText());
		
		d1.switchTo().window(parent_window);
		
		System.out.println(d1.findElement(By.cssSelector(".example h3")).getText());

		
		Thread.sleep(15000);
		d1.quit();
	}

}
