package AutomateWebElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
		
		d1.get("https://rahulshettyacademy.com/angularpractice/");
		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d1.findElement(By.cssSelector("form input[name='name']")).sendKeys("kiran");
		d1.findElement(By.cssSelector("form input[name='email']")).sendKeys("kiran321@gmail.com");
		d1.findElement(By.id("exampleInputPassword1")).sendKeys("1234");
		d1.findElement(By.id("exampleCheck1")).click();
		
		WebElement gender_WebElement = d1.findElement(By.id("exampleFormControlSelect1"));
		Select gender_option = new Select(gender_WebElement);
		gender_option.selectByVisibleText("Female");
		
		d1.findElement(By.id("inlineRadio2")).click();
		
//		here date is mm-dd-yyyy
		//WebElement is of type <inpuy type='date' />
//		d1.findElement(By.cssSelector("input[type='date']")).sendKeys("05-01-1996");
		d1.findElement(By.cssSelector("input[type='date']")).sendKeys("01/05/1996");
		d1.findElement(By.cssSelector("input[type='submit']")).click();
		
		System.out.println(d1.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		
		Thread.sleep(10000);
		
	}

}
