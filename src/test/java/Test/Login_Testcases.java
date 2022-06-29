package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM.Zerodha_LoginPage;
import POM.Zerodha_Pinpage;
import Utility.Parametarization;
import browser.Open_chrome;
@Listeners(TestListeners.class)
public class Login_Testcases extends listnersBaseTest{
	
	@BeforeMethod
	public void openBrowser() {
	driver=Open_chrome.openB();
		
	}
	@Test
	public void Valid_crediantialsTestcase() throws EncryptedDocumentException, IOException {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver);
		String username=Parametarization.ExcelSheet(0, 1);
		zerodha_loginPage.enterUserId(username);	
	 	String pass=Parametarization.ExcelSheet(1, 1);
		zerodha_loginPage.enterpassword(pass);
		String result=zerodha_loginPage.checkLoginClickAssertion();
		Assert.assertEquals(result,"Login");
		
		zerodha_loginPage.clickonSubmit();
	    Zerodha_Pinpage zerodha_pinpage =new Zerodha_Pinpage(driver);
		String PIN=Parametarization.ExcelSheet(2, 1);
		
		zerodha_pinpage.enterPin(PIN);
		zerodha_pinpage.clickOnContinue();
		
		}
	@Test
	public void CheckAsserionForErrorMsg() {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver) ;
		zerodha_loginPage.clickonSubmit();
		
		String result=zerodha_loginPage.msgisdisplayed();
		//System.out.println(result);
		SoftAssert Assert=new SoftAssert();
		String s="User ID should be minimum 5 characters.";
		Assert.assertEquals(result,s);
		zerodha_loginPage.enterpassword("1234566");
		
		zerodha_loginPage.enterUserId("1234456");
	
		//System.out.println(login);
		
		zerodha_loginPage.clickonlogin();
		Assert.assertAll();
		
	}
	@Test
	public void loginwithoutTestdata() {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver) ;
		zerodha_loginPage.clickonSubmit();
        String status= zerodha_loginPage.clickonlogin();
        System.out.println(status);
	}
	@Test
	public void loginWithoutuseridpass() {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver) ;
          zerodha_loginPage.clickonSubmit();
          String s=zerodha_loginPage.msgisdisplayed();
		String msg="User ID should be minimum 6 character.";
		Assert.assertEquals(s, msg);
	}
	@Test
	public void loginwithonlyuserid() {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver) ;
		zerodha_loginPage.enterUserId("1234");
		zerodha_loginPage.clickonSubmit();
        String status= zerodha_loginPage.clickonlogin();
        System.out.println(status);
	}

	public void loginwTestdata() {
		Zerodha_LoginPage zerodha_loginPage=new Zerodha_LoginPage(driver) ;
		zerodha_loginPage.clickonSubmit();
        String status= zerodha_loginPage.clickonlogin();
        System.out.println(status);
}

}