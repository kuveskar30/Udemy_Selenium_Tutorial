package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		d1.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> table_elements= d1.findElements(By.xpath("//tr/td[1]"));
		
		List<String> original_list = table_elements.stream().map(s->s.getText()).collect(Collectors.toList());
		
		List<String> sorted_list = original_list.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(original_list.equals(sorted_list),"List is not sorted");

	}

}
