package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zerodha_Pinpage {

	@FindBy(xpath="//input[@id='pin']") private WebElement pin;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	@FindBy(xpath="//a[text()='Forgot 2FA?']") private WebElement FA;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signup;


public Zerodha_Pinpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void enterPin(String pinNumber) {
	
	pin.sendKeys(pinNumber);
}
public void clickOnContinue() {
	submit.click();
}

public void clickOnForgot2FA() {
	FA.click();
}
public void clickOnSignup() {
	signup.click();
}








}