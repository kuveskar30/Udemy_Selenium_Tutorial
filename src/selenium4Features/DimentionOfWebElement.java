package selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DimentionOfWebElement {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		d1.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement name_editbox = d1.findElement(By.cssSelector("input[name='name']"));
		
		System.out.println(name_editbox.getRect().getDimension());
		
		System.out.println(name_editbox.getRect().getDimension().getHeight());
		System.out.println(name_editbox.getRect().getDimension().getWidth());

	}

}
