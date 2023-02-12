package HandlingMouseActions;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class Summary {

	
	//1. action class methods
	//Actions a = new Actions(d1);
	//.build().perform(); is imp 
	//a.moveToElement(WebElement).click().keyDown(Keys.SHIFT).sendKeys("refrigerator").doubleClick().build().perform();
	//a.dragAndDrop(source_WebElement, target_WebElement).build().perform();

	//2. switch to frames
	//we need to switch frame otherwise selenium will not be able to locate web elements
	//d1.switchTo().frame(WebElement);
	//d1.switchTo().defaultContent(); --switch to parent window
	
	//3. window handles
	//Set<String> windows = d1.getWindowHandles();
	//String window = d1.getWindowHandle();
	//d1.switchTo().window(window_handle_string);
}
