package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot- interface by selenium to take failure tc screenshot.
															//convert screenshot to webdriver mode
														//sel webdriver canno take screenshots directly. so we typecase into take  SS.
		
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture the screenshot.Store it temperory as a file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//create date and time.Date class used to get current date
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); 
		if (!f1.exists()) {
			f1.mkdirs(); // if dir not exists,make it
		}
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
				+ ".png";
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);  //FileHandler.copy - use to copy from one loc to another loc.So decide final ss path
	}

}
