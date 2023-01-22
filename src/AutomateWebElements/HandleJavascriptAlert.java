package AutomateWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleJavascriptAlert {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Thread.sleep(2000);
		d1.findElement(By.id("name")).sendKeys("kiran shetty");
		Thread.sleep(1000);
		d1.findElement(By.id("alertbtn")).click();
		//handling javascript alert
		//accepting alert
		System.out.println(d1.switchTo().alert().getText());
		Thread.sleep(1000);
		d1.switchTo().alert().accept();
		//cancelling alert
		Thread.sleep(1000);
		d1.findElement(By.id("confirmbtn")).click();
		Thread.sleep(1000);
		System.out.println(d1.switchTo().alert().getText());
		d1.switchTo().alert().dismiss();
		
		Thread.sleep(10000);
		d1.quit();

	}

}
