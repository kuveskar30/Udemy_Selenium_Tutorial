package section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js_d1 = (JavascriptExecutor)d1;
		
		Thread.sleep(2000);
		js_d1.executeScript("window.scrollBy(0,550)");
		Thread.sleep(2000);
		js_d1.executeScript("document.querySelector('.tableFixHead').scrollTop=150");
		
		List<WebElement> amt = d1.findElements(By.cssSelector(".tableFixHead tr td:nth-child(4)"));
		
		int sum=0;
		for(WebElement amt_value:amt) {
			sum = sum + (Integer.parseInt(amt_value.getText()));
			System.out.println(amt_value.getText());
		}
		System.out.println("sum="+sum);
		
		
	}

}
