package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends BaseClass{
	
	@Test
	public void VerifyUserisAbletoCreateAdminUsers() throws IOException {
		
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signin();
		
		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickAdminUsers();
		
		//Assert.assertTrue(adminusers.isNewButtonEnabled());
		adminusers.clickNewOption();
		//Assert.assertTrue(adminusers.isAdminPageSubtitleDisplayed());
		
		String adnusername = ExcelUtility.getStringData(1, 0, "adminpage");
		String adnpassword = ExcelUtility.getStringData(1, 1, "adminpage");
		String usertypedropdown = ExcelUtility.getStringData(1, 2, "adminpage");
		
		adminusers.createnewAdminUser(adnusername, adnpassword, usertypedropdown);
		AssertJUnit.assertTrue(adminusers.getSuccssesAlertText());
	}

}
