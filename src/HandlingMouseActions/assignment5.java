package HandlingMouseActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment5 {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://the-internet.herokuapp.com/");

		d1.findElement(By.linkText("Nested Frames")).click();

		d1.switchTo().frame(d1.findElement(By.cssSelector("frame[name='frame-top']")));

		d1.switchTo().frame(d1.findElement(By.cssSelector("frame[name='frame-middle']")));
		System.out.println(d1.findElement(By.id("content")).getText());

	}

}
