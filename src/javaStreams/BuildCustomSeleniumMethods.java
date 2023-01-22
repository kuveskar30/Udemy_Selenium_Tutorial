package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuildCustomSeleniumMethods {

	public static void main(String[] args) {
		// launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		//custom selenium methods and pagination
		List<String> price =null;
		do {
			List<WebElement> table_elements = d1.findElements(By.xpath("//tr/td[1]"));

			price = table_elements.stream().filter(s -> s.getText().contains("Carrot"))
					.map(s -> getVeggiePrice(s)).collect(Collectors.toList());

			if (price.size() < 1) {
				d1.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		
		System.out.println(price);

	}

	public static String getVeggiePrice(WebElement s) {
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}

}
