package POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_ForgotPasswordPage {
	@FindBy(xpath="//input[@id='radio-22']") private WebElement rememberuserid;
	@FindBy(xpath="//input[@id='radio-23']") private WebElement frogotuserid;
	@FindBy(xpath="//input[@placeholder='User ID']") private WebElement UserId;
	@FindBy(xpath="//input[@placeholder='PAN']") private WebElement Pan;
	@FindBy(xpath="//input[@label='E-mail']") private WebElement radioEmail;
	@FindBy(xpath="//input[@label='SMS']") private WebElement Sms;
	@FindBy(xpath="//input[@placeholder='Mobile number (as on account)']") private WebElement MoNumber;
	@FindBy(xpath="//input[@placeholder='Captcha']") private WebElement captcha;
	@FindBy(xpath="//button[text()='Reset ']") private WebElement reset;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement signUp;
	@FindBy(xpath="//a[@class='text-xsmall text-light reset-account-button']") private WebElement BackToLogin;
	
	public  Zerodha_ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void clickOnrememberid() {
		rememberuserid.click();
	}
	public void clickOnforgotid() {
		frogotuserid.click();	
	}
	public void enteruserid(String id) {
		rememberuserid.sendKeys(id);
	}
	public void enterPan(String ID) {
		frogotuserid.sendKeys(ID);
	}
	public void clickOnemail() {
		radioEmail.click();
	}
	public void clickOnSMS() {
		Sms.click();
	}
	public void enterMobileNo(String number) {
		MoNumber.sendKeys(number);
	}
	public void enterCaptcha(String Captcha) {
		captcha.sendKeys(Captcha);
	}
	public void clickOnReset() {
		reset.click();
	}
	public void clickOnBacktoLogin() {
		BackToLogin.click();
	}
	
	
}
