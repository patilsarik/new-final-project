package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.Zerodha_HomePage;
import POM.Zerodha_LoginPage;
import POM.Zerodha_Pinpage;
import POM.Zerodha_SignUp_Page;
import Utility.Parametarization;
import browser.Open_chrome;

public class Zerodha_SignupPageTest {
WebDriver driver;
Zerodha_Pinpage ZerodhaPinpage;
Zerodha_LoginPage ZerodhaLoginPage;
Zerodha_HomePage ZerodhaHomePage;

	@BeforeMethod
	public void openBrowser() {
		driver=Open_chrome.openB();
	}
	@Test
	public void clickOnsignUp() throws EncryptedDocumentException, IOException {
		ZerodhaLoginPage=new Zerodha_LoginPage(driver);
		ZerodhaLoginPage.clickonSignup();
		Zerodha_SignUp_Page Zerodha_SignUpPage=new Zerodha_SignUp_Page(driver);
		Zerodha_SignUpPage.performOperationOnMobile(driver, "Signup and open a Zerodha trading and demat account online and start investing – Zerodha");
		Zerodha_SignUpPage.enterMobileNo("4567893201");
		Zerodha_SignUpPage.clickOnContinue();
		
		
		

	}
	
	
}
