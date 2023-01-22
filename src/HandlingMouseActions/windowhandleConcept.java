package HandlingMouseActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandleConcept {

	public static void main(String[] args) {

		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		d1.findElement(By.className("blinkingText")).click();
		
		Set<String> windows = d1.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parent_window = it.next();
		String child_window = it.next();
		
		d1.switchTo().window(child_window);
		
		System.out.println(d1.findElement(By.cssSelector(".im-para.red")).getText());
		
		String email_id = d1.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
//		System.out.println(email_id);
		
		d1.switchTo().window(parent_window);
		
		d1.findElement(By.id("username")).sendKeys(email_id);
	}

}
