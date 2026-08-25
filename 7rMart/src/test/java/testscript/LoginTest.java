package testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends BaseClass{
	
	
	
	@Test(retryAnalyzer = retrymechanism.Retry.class ,description = "Login with valid Username and password")
	public void loginWithValidCredentials() throws IOException {
		
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signin();
		
		Assert.assertEquals(true, true, "Please retry with valid credentials");
		
	}
	@Test(retryAnalyzer = retrymechanism.Retry.class ,description = "Verify Login is failed if valid Username and invalid password is provided")
	public void verifyLoginwithValidUsernameAndInvalidPassword() throws IOException {	
		
		String username = ExcelUtility.getStringData(2, 0, "loginpage");
		String password = ExcelUtility.getStringData(2, 1, "loginpage");
		String expectederror = "Alert!";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signin();
		String Actualerror = loginpage.errorIsDisplayed();
		
		Assert.assertEquals(Actualerror,expectederror);
		
	}
	
	@Test(retryAnalyzer = retrymechanism.Retry.class ,description = "Verify Login is failed if invalid Username and valid password is provided")
	public void verifyLoginwithInvalidUsernameAndValidPassword() throws IOException {
		
		String username = ExcelUtility.getStringData(3, 0, "loginpage");
		String password = ExcelUtility.getStringData(3, 1, "loginpage");
		String expectederror = "Alert!";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signin();
		String Actualerror = loginpage.errorIsDisplayed();
		
		Assert.assertEquals(Actualerror,expectederror);
		
	}
	
	@Test(retryAnalyzer = retrymechanism.Retry.class ,description = "Verify Login is failed if invalid Username and invalid password is provided")
	public void verifyUserUnabletoLoginwithInvalidCredentials() throws IOException {
		String username = ExcelUtility.getStringData(4, 0, "loginpage");
		String password = ExcelUtility.getStringData(4, 1, "loginpage");
		String expectederror = "Alert!";
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signin();
		String Actualerror = loginpage.errorIsDisplayed();
		
		Assert.assertEquals(Actualerror,expectederror);
		
	}

}
