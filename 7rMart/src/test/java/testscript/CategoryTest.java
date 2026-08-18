package testscript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoryTest extends BaseClass{
	
	ExcelUtility excelutil = new ExcelUtility();
	
	@Test
	public void verifyUserisAbleToChooseCategory() throws IOException {
		
		String username = ExcelUtility.getStringData(1, 0, "loginpage");
		String password = ExcelUtility.getStringData(1, 1, "loginpage");
	
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signin();
	
	CategoryPage categorypage = new CategoryPage(driver);
	categorypage.clickcategory();
	categorypage.clicknewbutton();
		
	String entercategory = ExcelUtility.getStringData(1, 1, "categorypage");
	categorypage.entercategory(entercategory);
	
	String choosecategory = ExcelUtility.getStringData(3, 0, "categorypage");
	categorypage.selectgroup(choosecategory);	
	categorypage.verifyGroupselected();
	
	categorypage.choosephoto();
	categorypage.selectshowOnTopNoOption();
	categorypage.selectshowOnLeftNoOption();
	categorypage.clickSave();
	AssertJUnit.assertTrue(categorypage.getSuccssesAlertText());
		
	}
	
	
}
