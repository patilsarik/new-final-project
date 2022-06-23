package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Zerodha_HomePage;
import POM.Zerodha_LoginPage;
import POM.Zerodha_Pinpage;
import Utility.ExtentReport;
import Utility.Parametarization;
import browser.Open_chrome;


@Listeners(TestListeners.class)

public class Zerodha_HomePageTest extends listnersBaseTest{
	
			Zerodha_Pinpage ZerodhaPinpage;
			Zerodha_LoginPage ZerodhaLoginPage;
			Zerodha_HomePage ZerodhaHomePage;
			ExtentReports reports;
			ExtentTest test;
	@BeforeClass
	public void extentReport() {
		reports=ExtentReport.report();
		
	}	
		@BeforeMethod
		public void openbrowser() throws EncryptedDocumentException, IOException {
		driver=Open_chrome.openB();
		ZerodhaLoginPage =new Zerodha_LoginPage(driver) ;
		String username=	Parametarization.ExcelSheet(0, 1);
			ZerodhaLoginPage.enterUserId(username);	
			String password=Parametarization.ExcelSheet(1, 1);
			ZerodhaLoginPage.enterpassword(password);
			ZerodhaLoginPage.clickonSubmit();
			 ZerodhaPinpage=new Zerodha_Pinpage(driver);
			 String pin=Parametarization.ExcelSheet(2, 1);
			 ZerodhaPinpage.enterPin(pin);
			 ZerodhaPinpage.clickOnContinue();
		}
		@Test
		public void SearchBoxTest() throws EncryptedDocumentException, IOException, InterruptedException {
	        test=reports.createTest("SearchBoxTest");
			 ZerodhaHomePage=new Zerodha_HomePage(driver);
			 ZerodhaHomePage.searchBox("TATA");
			 try {
				 ZerodhaHomePage.clickOnBuybutton(driver,"TATACOFFEE");
			 }
			 catch(Exception e) {
				 ZerodhaHomePage.clickOnBuybutton(driver,"TATACOFFEE");
			 }
			 ZerodhaHomePage.clickonintradayradio();
			String number= Parametarization.ExcelSheet(3, 1);
			 ZerodhaHomePage.chosequntity(number);
			 ZerodhaHomePage.clickOnlimitorder();
			 ZerodhaHomePage.enterprice("500");
			 ZerodhaHomePage.clickonBuyshare();
			 
		}
		@Test
		public void BuyshareInIntradayWithStopLoss() throws EncryptedDocumentException, IOException, InterruptedException {
			test=reports.createTest("BuyshareInIntradayWithStopLoss");
			ZerodhaHomePage=new Zerodha_HomePage(driver);
				 ZerodhaHomePage.searchBox("GAIL");
               try {
            	   ZerodhaHomePage.clickOnBuybutton(driver, "GAIL");
               }
               catch(Exception e) {
            	   ZerodhaHomePage.clickOnBuybutton(driver, "GAIL");
               }
               ZerodhaHomePage.clickonintradayradio();
               ZerodhaHomePage.clickOnstoploss();
               ZerodhaHomePage.chosequntity("30");
               ZerodhaHomePage.enterprice("300");
               ZerodhaHomePage.entertriggerprice("298");
               ZerodhaHomePage.clickonBuyshare();
		}
		
		@Test
		public void BuyShrareInCNCWithStoplossMarket() throws EncryptedDocumentException, IOException, InterruptedException {
		    test=reports.createTest("BuyShrareInCNCWithStoplossMarket") ;
			ZerodhaHomePage=new Zerodha_HomePage(driver);
			 ZerodhaHomePage.searchBox("TATA");
			 try {
				 ZerodhaHomePage.clickOnBuybutton(driver,"TATACOFFEE");
			 }
			 catch(Exception e) {
				 ZerodhaHomePage.clickOnBuybutton(driver,"TATACOFFEE");
			 }
			 Thread.sleep(2000);
			 ZerodhaHomePage.clickonlongtermradio();
			 ZerodhaHomePage.chosequntity("25");
			 ZerodhaHomePage.clickOnmarketorder();
			// ZerodhaHomePage.entertriggerprice("300");
			 ZerodhaHomePage.clickonBuyshare();
		}
		@Test
		public void SellShareInCNCWithMO() {
			ZerodhaHomePage=new Zerodha_HomePage(driver);
			 ZerodhaHomePage.searchBox("LIC");
          try {
       	   ZerodhaHomePage.clickonsellbutton(driver, "LICI");
          }
          catch(Exception e) {
       	   ZerodhaHomePage.clickonsellbutton(driver, "LICI");
          }
          ZerodhaHomePage.clickonlongtermradio();
			ZerodhaHomePage.clickOnmarketorder();
			ZerodhaHomePage.clickonSellshare();	
			
		}
		@Test
		public void AddstockfromGTT() throws InterruptedException {
			test=reports.createTest("AddstockfromGTT");
			ZerodhaHomePage=new Zerodha_HomePage(driver);
			ZerodhaHomePage.order(); 
			try {
				ZerodhaHomePage.performActionInGTT(driver,"LIC","LICI");
				
				//SoftAssert Assert=new SoftAssert();
//				Assert.assertEquals(name,true);
//				Assert.assertAll();
			}
			catch(Exception e) {
				ZerodhaHomePage.performActionInGTT(driver, "LIC","LICI");
			}
			Thread.sleep(2000);
			boolean name=ZerodhaHomePage.checkAsserionforcreateGTT();
			Assert.assertEquals(name,true);
			ZerodhaHomePage.clickoncreatGTT(driver);
			
		
		}
		
//		@Test
//		public void 
		@AfterMethod
		public void CreateResult(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				test.log(Status.FAIL,result.getName());
			}
			else if(result.getStatus()==ITestResult.SUCCESS) {
				test.log(Status.PASS,result.getName());
			}
			else {
				test.log(Status.SKIP,result.getName());
			}
		}
		@AfterClass
		public void flushResult() {
			reports.flush();
		}
		
	}
	

