package synchronization;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Summary {

	public static void main(String[] args) {
		
		//WeDriverWait extends FluentWait class
		//FluentWait implements Wait interface
		//it means both WeDriverWait and FluentWait implement Wait interface
		
		//Function<TypeofInput,TypeofOutput>
		//Function is an functional interface
		//we can create instance of functional interface
		//functional programming is also one topic but I don't know much about it
		
		//WebDriverWait w = new WebDriverWait(d1, Duration.ofSeconds(durationInSeconds));
		//w.until(ExpectedConditions.elementToBeClickable(element));
		
		//d1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
