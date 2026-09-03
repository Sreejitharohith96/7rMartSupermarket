package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.invoke.ConstantBootstraps;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.ConstantClass;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class BaseClass {

	WebDriver driver;
	public Properties prop;
	public FileInputStream fileip;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void browserInitialiser(String browser) throws Exception {
		try {
			prop = new Properties();
			fileip = new FileInputStream(ConstantClass.CONFIG_FILE);
			prop.load(fileip);

		} catch (Exception e) {
			System.out.println(e);
		}

		if(browser.equalsIgnoreCase("chrome")) {
			
		driver = new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("edge")) {
			
				driver = new EdgeDriver();
			
		}
		else {
			
			throw new Exception("Invalid");
		}
		driver.get(prop.getProperty("url")); // key from config.pro
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}

	}

}
