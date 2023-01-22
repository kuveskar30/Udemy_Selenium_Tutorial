package section12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {

		// 1. chrome browser launching
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/AutomationPractice/");

		int rows_count = d1.findElements(By.cssSelector("table[name='courses'] tbody tr")).size();
		System.out.println("no of rows=" + rows_count);
		
		int column_count = d1.findElements(By.cssSelector("table[name='courses'] tbody tr:nth-child(1) th")).size();
		System.out.println("no of columns=" + column_count);
		
		List<WebElement> heading_row_data = d1.findElements(By.cssSelector("table[name='courses'] tbody tr:nth-child(1) th"));
		List<WebElement> second_row_data = d1.findElements(By.cssSelector("table[name='courses'] tbody tr:nth-child(3) td"));
		for(int i=0;i<heading_row_data.size();i++) {
			System.out.println(heading_row_data.get(i).getText() + ": " + second_row_data.get(i).getText());
		}
		
		Thread.sleep(15000);
		d1.quit();
	
	}

}
