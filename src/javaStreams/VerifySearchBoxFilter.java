package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifySearchBoxFilter {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		d1.findElement(By.id("search-field")).sendKeys("Rice");
		
		List<WebElement> original_list = d1.findElements(By.xpath("//tr/td[1]"));
		
		List<String> expected_list = original_list.stream().filter(s->s.getText().contains("Rice"))
				.map(s->s.getText()).collect(Collectors.toList());
		
		Assert.assertEquals(original_list.size(), expected_list.size());

	}

}
