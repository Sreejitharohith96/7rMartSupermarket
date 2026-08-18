package utilities;

import org.openqa.selenium.WebElement;

public class FileuploadUtility {
	
public void fileuploadUsingSendKeys(WebElement element,String filepath) {
		
		element.sendKeys(filepath);
		
		
	}

}
