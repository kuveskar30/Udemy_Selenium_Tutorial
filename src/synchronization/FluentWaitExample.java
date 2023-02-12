package synchronization;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample {

	public static void main(String[] args) {

		// launching browser
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();

		d1.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		d1.findElement(By.cssSelector("div[id='start'] button")).click();

		Wait<WebDriver> w = new FluentWait<WebDriver>(d1).withTimeout(Duration.ofSeconds(9))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		

		w.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver d1) {

				if (d1.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed()) {
					return d1.findElement(By.cssSelector("div[id='finish'] h4"));
				} else {
					return null;
				}
			}

		});

		System.out.println(d1.findElement(By.cssSelector("div[id='finish'] h4")).getText());

	}

}
