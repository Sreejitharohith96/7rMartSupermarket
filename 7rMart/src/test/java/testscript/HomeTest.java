package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.HomePage;

public class HomeTest extends BaseClass{
	
	@Test
	public void logout() {

	String username = "admin";
	String password = "admin";
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signin();
	
	HomePage logout = new HomePage(driver);
	logout.clickadminButton();
	logout.clicklogout();
	Assert.assertTrue(logout.successfulLogout());
	
}

}
