package Section11;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class scopeOfWebDriver {

	public static void main(String[] args) throws InterruptedException {

		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1. count no of links on page

		System.out.println(d1.findElements(By.tagName("a")).size());

		// 2. no of links in footer section
		System.out.println(d1.findElements(By.cssSelector("#gf-BIG a")).size());

		// Alternate way
		// By limiting scope of WebDriver to certain section

		WebElement footer_driver = d1.findElement(By.id("gf-BIG"));

		System.out.println(footer_driver.findElements(By.tagName("a")).size());

		// 3. no of links in footer section, in 1st column
		System.out.println(d1.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li //a")).size());

		// below both 2 xpaths are different:
		// 1. below line will search all 'a' tags under li tag
		// "//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul/li //a"
		// 2. below line will search all 'a' tags just under li tag
		// "(//div[@id='gf-BIG']/table/tbody/tr/td)[2]/ul/li/a"

		// Alternate way
		// By limiting scope of WebDriver to certain section

		WebElement footer_column1 = footer_driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(footer_column1.findElements(By.tagName("a")).size());

		// 4. click on each link and check if pages opening or not

		List<WebElement> column1_links = footer_column1.findElements(By.tagName("a"));

//		//method 1
//		//It is through mouse plus keyboard actions
//		Actions a = new Actions(d1);
//		
//		for (int i=1; i<column1_links.size();i++) {
////			Thread.sleep(1000);
////			a.moveToElement(column1_links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
//		}

		// method 2
		// It is through keyboard action
		String click_on_link = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 1; i < column1_links.size(); i++) {
			column1_links.get(i).sendKeys(click_on_link);
		}

		Set<String> windows = d1.getWindowHandles();

		Iterator<String> it = windows.iterator();

		String first_window = d1.getWindowHandle();

		while (it.hasNext()) {
//			Thread.sleep(1000);
			String window_id = it.next(); 
			d1.switchTo().window(window_id);
			System.out.println(d1.getTitle());
			
		}
		
		System.out.println("****");
//		System.out.println(first_window);
		d1.switchTo().window(first_window);

	}

}
