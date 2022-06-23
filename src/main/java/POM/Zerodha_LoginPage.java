package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_LoginPage {

	@FindBy(xpath="//input[@id='userid']") private WebElement userid;
	@FindBy(xpath="//input[@id='password']") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement submit;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement forgotpw;
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]") private WebElement Signup;
	@FindBy(xpath="//span[text()='User ID should be minimum 6 characters.']") private WebElement errormsg;
	@FindBy(xpath="//span[text()='User ID should be minimum 6 characters.']") private WebElement useridError;
	public Zerodha_LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public String msgisdisplayed() {
		String result=useridError.getText();
		return result;
	}
	public String checkLoginClickAssertion() {
		String login=submit.getText();
		return login;
		
	}
	public void enterUserId(String id) {
		userid.sendKeys(id);
	}
	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickonSubmit() {
		submit.click();
	}
	public void clickonForgot() {
		forgotpw.click();
	}
	public void clickonSignup() {
		Signup.click();
	}
	
	 public String clickonlogin() {
		 String name=errormsg.getText();
		 return name;
	    }
	
	
}
