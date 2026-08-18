package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseClass{
	
	@Test
	public void logout() {

	String username = "admin";
	String password = "admin";
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signin();
	
	LogoutPage logout = new LogoutPage(driver);
	logout.clickadminButton();
	logout.clicklogout();
	Assert.assertTrue(logout.successfulLogout());
	
}

}
