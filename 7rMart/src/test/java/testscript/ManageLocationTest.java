package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends BaseClass{
	
	@Test
	public void verifyUserisAbletoCreateLocationSuccessfully() throws IOException {
		
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.signin();
		
		ManageLocationPage managelocation = new ManageLocationPage(driver);
		managelocation.clickmanageLocation();
		managelocation.clickNewButton();
		managelocation.selectCountry();
		managelocation.selectState();
		
		String loc = ExcelUtility.getStringData(1, 0, "locationpage");
		managelocation.selectLocation(loc);
		
		Integer del_charge = ExcelUtility.getIntegerData(1, 1, "locationpage");
		managelocation.enterdeliverycharge(del_charge);
		
		managelocation.saveaction();
		AssertJUnit.assertTrue(managelocation.successmsgisDisplayed());
	}

}
