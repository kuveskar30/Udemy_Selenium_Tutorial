package Section11;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalenderHandeling {
// problem faced in this assignment
	//1. readonly attribute was taking time to apply to element so it was deselecting selection date
	//2. month text dynamically loaded so we need to wait after each click till loading
	//3. css selector vs xpath , xpath solved problem as it matches exactly where css
	//matches partially also
	public static void main(String[] args) throws InterruptedException {

		// 1. chrome browser launching
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		// waits
		WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(10));
		// calender loading taking time hence explicit wait used
		// readonly attribute taking time to load,
		// hence unusual behaviour seen while clicking without explicit wait

		d1.get("https://www.path2usa.com/travel-companion/");

		w.until(ExpectedConditions.attributeToBeNotEmpty(d1.findElement(By.cssSelector("#form-field-travel_comp_date")),
				"readonly"));
//		Thread.sleep(3000);
		d1.findElement(By.cssSelector("#form-field-travel_comp_date")).click();

		String required_month = "August";

		while (!(d1.findElement(By.xpath(
				"//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/span[@class='cur-month']"))
				.getText().contains(required_month))) {
			d1.findElement(By.cssSelector(".flatpickr-next-month")).click();
			// css selector were causing some problem i think it was selection transition
			// element
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/span[@class='cur-month']")));
			//below wait was not working because of cssSelector problem, when used xpath it is working fine
			//xpath try to find exact match, where cssSelector will match with partial class also
			//ie. if there are two class and we give only one, then css will match it but xpath will not
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flatpickr-month .flatpickr-current-month span.cur-month")));
			System.out.println(d1.findElement(By.xpath(
					"//div[@class='flatpickr-month']/div[@class='flatpickr-current-month']/span[@class='cur-month']"))
					.getText());
		}

		List<WebElement> dates = d1.findElements(By.cssSelector(".flatpickr-day "));

		for (int j = 0; j < dates.size(); j++) {
			String date_text = d1.findElements(By.cssSelector(".flatpickr-day ")).get(j).getText();
			if (date_text.equalsIgnoreCase("25")) {
				d1.findElements(By.cssSelector(".flatpickr-day ")).get(j).click();
//				Thread.sleep(1000);
				break;
			}
		}

		Thread.sleep(15000);
		d1.quit();

	}

}
