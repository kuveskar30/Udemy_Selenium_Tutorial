package FunctionalTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "E:\\pratik30\\Software testing\\Udemy_selenium_course\\Selenium_drivers_for_browsers\\chromedriver.exe");
		WebDriver d1 = new ChromeDriver();
//		d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//explicit wait (it targets specific element)
		WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(5));

		d1.get("https://rahulshettyacademy.com/seleniumPractise/");

//		String[] required_products = {"cucumber","beetroot ","brocolli"};

		List<String> required_products = new ArrayList<String>(
				Arrays.asList("Cucumber", "Beetroot", "Brocolli","bRinjal", "Tomato"));

		addItemsToCart(d1,required_products);
		
		d1.findElement(By.cssSelector("img[alt='Cart']")).click();
		d1.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//explicit wait(it targets specific element)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		d1.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		d1.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait(it targets specific element)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(d1.findElement(By.cssSelector("span.promoInfo")).getText());
		
		Thread.sleep(15000);
		d1.quit();

	}

	public static void addItemsToCart(WebDriver d1, List<String> required_products) {
		// this xpath works
		// h4[contains(text(),"Cucumber")]
//		Thread.sleep(2000);
		List<WebElement> product_list = d1.findElements(By.cssSelector("h4.product-name"));

//		int product_count = 0;
//		for (WebElement products : product_list) {
//
//			String current_product = products.getText().split("-")[0].trim().toLowerCase();
//
//			if (required_products.contains(current_product)) {
//				System.out.println(current_product);

		// below line is wrong way
////				products.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
//				products.findElement(By.xpath("//parent::div/div[@class='product-action']/button"));
//				product_count++;
//
//				System.out.println(product_count);
//				if (product_count == required_products.size()) {
//					break;
//				}
//			}
//
//		}

		int product_count = 0;
		for (int i = 0; i < product_list.size(); i++) {

			String current_product = product_list.get(i).getText().split("-")[0].trim().toLowerCase();

			// I have made search case insensitive by converting input and output string
			// data to lowercase
			if (required_products.toString().toLowerCase().contains(current_product)) {

				System.out.println(current_product);

				// this method has issues, because Add to cart text is dynamic
				// so we don't prefer locator based on visible text
//				Thread.sleep(4000);
//				d1.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();

				d1.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				product_count++;
				System.out.println(product_count);

				if (product_count == required_products.size()) {
					break;
				}
			}
		}
	}

}
