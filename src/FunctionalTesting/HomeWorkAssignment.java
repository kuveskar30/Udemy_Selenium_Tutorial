package FunctionalTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWorkAssignment {

	public static void main(String[] args) throws InterruptedException {
		//launching browser
		System.setProperty("webdriver.chrome.driver",
				"E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\Selenium_chrome_driver\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
//		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//explicit wait
		WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(5));
		//visit URL
		d1.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		System.out.println(d1.findElement(By.xpath("//*[text()='rahulshettyacademy']")).getText());
		//Enter login credentials
		d1.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		d1.findElement(By.id("password")).sendKeys("learning");
//		Thread.sleep(2000);
		d1.findElement(By.cssSelector("input[value='user']")).click();
		Thread.sleep(2000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		d1.findElement(By.id("okayBtn")).click();
		
		WebElement option = d1.findElement(By.cssSelector("select.form-control"));
		Select options = new Select(option);
		options.selectByValue("consult");
//		Thread.sleep(2000);
		d1.findElement(By.id("terms")).click();
		
		d1.findElement(By.id("signInBtn")).click();
		
//		d1.findElement(By.xpath("(//div[@class='card-footer']/button[@class='btn btn-info'])[2]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-footer .btn.btn-info")));
		List<WebElement> add_buttons = d1.findElements(By.cssSelector(".card-footer .btn.btn-info"));
		
		for(WebElement add_button:add_buttons) {
			add_button.click();
		}
		
		d1.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
		
		
		Thread.sleep(15000);
		d1.quit();

	}

}
