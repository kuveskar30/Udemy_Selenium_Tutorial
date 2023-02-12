package HandlingMouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionClassExample {

	public static void main(String[] args) {

		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://www.amazon.in/");
		//Actions Class
		//biuid().perform() is imp step to implement this
		Actions a = new Actions(d1);
//		String ab = Keys.chord(Keys.SHIFT,Keys.DOWN,"refrigerator");//not working
		a.moveToElement(d1.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("refrigerator").doubleClick().build().perform();
//		a.moveToElement(d1.findElement(By.id("twotabsearchtextbox"))).click().sendKeys(ab).doubleClick().build().perform();
		a.moveToElement(d1.findElement(By.id("nav-link-accountList-nav-line-1"))).contextClick().build().perform();

		
		
		
	}

}
