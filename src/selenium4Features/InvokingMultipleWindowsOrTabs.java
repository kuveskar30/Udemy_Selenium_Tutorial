package selenium4Features;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindowsOrTabs {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		d1.get("https://rahulshettyacademy.com/angularpractice/");
		
		//newWindow method available in selenium 4+ versions
//		d1.switchTo().newWindow(WindowType.TAB);
		d1.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> open_windows = d1.getWindowHandles();
		Iterator<String> it = open_windows.iterator();
		
		String parent_window = it.next();
		String child_window = it.next();
		
		d1.switchTo().window(child_window);
		
		d1.get("https://courses.rahulshettyacademy.com/courses");
		
		String course_name = d1.findElement(By.xpath("(//div[@class='course-listing-title'])[1]")).getText();

		d1.switchTo().window(parent_window);
		
		d1.findElement(By.cssSelector("input[name='name']")).sendKeys(course_name);
		
	}

}
