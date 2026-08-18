package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends BaseClass{
	@Test
	public void verifyUserisAbleToAddDeliveryBotDetails() throws IOException {
	String username = ExcelUtility.getStringData(1, 0, "loginpage");
	String password = ExcelUtility.getStringData(1, 1, "loginpage");

	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signin();
	
	
	ManageDeliveryBoyPage deliverypage = new ManageDeliveryBoyPage(driver);
	deliverypage.clickManageDelivery();
	deliverypage.clickNewButton();
	
	
	ExcelUtility excelutil = new ExcelUtility();
	String name = excelutil.getStringData(1, 0, "deliverypage");
	deliverypage.enterName(name);
	
	String email = excelutil.getStringData(1, 1, "deliverypage");
	deliverypage.enterEmailAddress(email);
	
	int phoneno = excelutil.getIntegerData(1, 2, "deliverypage");
	deliverypage.enterPhoneNo(phoneno);
	
	String address = excelutil.getStringData(1, 3, "deliverypage");
	deliverypage.enteraddress(address);
	
	String delusername = excelutil.getStringData(1, 4, "deliverypage");
	deliverypage.enterusername(delusername);
	
	String delpassword = excelutil.getStringData(1, 5, "deliverypage");
	deliverypage.enterpassword(delpassword);
	
	deliverypage.clicksave();
	AssertJUnit.assertTrue(deliverypage.getSuccssesAlertText());
}
}