package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.ChildBrowserPopup;

public class Zerodha_SignUp_Page {
    
	@FindBy(xpath="//input[@placeholder='Your 10 digit mobile number']") private WebElement MobileNo;
	@FindBy(xpath="//button[@id='open_account_proceed_form']") private WebElement submit;
	@FindBy(xpath="//a[text()='Want to open an NRI account?']") private WebElement NRI;
	
	public Zerodha_SignUp_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void performOperationOnMobile(WebDriver driver,String pagename) {
		ChildBrowserPopup.childPopUp(driver);
		String currentTitle=driver.getTitle();
		if(currentTitle.equals(pagename)) {
		   
		}

	}
	public void enterMobileNo(String num) {
		
		MobileNo.sendKeys(num);
	}
	public void clickOnContinue() {
		submit.click();
		
	}
	public void ClickOnNRI() {
		NRI.click();
	}
}
