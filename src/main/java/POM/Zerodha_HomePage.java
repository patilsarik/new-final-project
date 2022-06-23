package POM;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Zerodha_HomePage {
	//for orders
	@FindBy(xpath="//a[@class='orders-nav-item']") private WebElement orders;
	@FindBy(xpath="(//span[text()='GTT'])[1]") private WebElement GTT;
	@FindBy(xpath="//button[text()='New GTT']") private WebElement NewGTT;
	@FindBy(xpath="(//input[@type='text'])[2]") private WebElement searchstockGTT;
	@FindBy(xpath="//span[@class='tradingsymbol']") private List<WebElement> SearchInGTT; 
	@FindBy(xpath="//button[text()='Create GTT ']") private WebElement createGTT;
	
	//for dashboard
	@FindBy(xpath="//span[text()='Dashboard']") private WebElement dashboard;
	@FindBy(xpath="//span[text()='Holdings']") private WebElement Holding;
	@FindBy(xpath="//span[text()='Positions']") private WebElement Positions;
	@FindBy(xpath="//span[text()='Funds']") private WebElement Funds;
	@FindBy(xpath="//span[text()='Apps']") private WebElement App;
	//path of search buttons
	@FindBy(xpath="//input[@type='text']") private WebElement search;
	@FindBy(xpath="//button[@class='button-blue buy']") private WebElement buyButton;
	@FindBy(xpath = "//button[text()='B ']") private WebElement  buyShare2;
	@FindBy(xpath = "//button[text()='S ']") private WebElement  sellShare2;
	@FindBy(xpath="//button[@class='button-orange sell']") private WebElement sellbutton;
	@FindBy(xpath="//span[@class='icon icon-align-center']") private WebElement marketDepth;
	@FindBy(xpath="//span[@class='icon icon-trending-up']") private WebElement graph;
	@FindBy(xpath="//span[@class='icon icon-trash']") private WebElement delete;
	@FindBy(xpath="//span[@class='icon icon-ellipsis']") private WebElement more;
	//path of Buy/sell window
	@FindBy(xpath="//label[text()='Intraday ']") private WebElement intradayradio;
	@FindBy(xpath="//label[text()='Longterm ']") private WebElement longtermradio;
	@FindBy(xpath="//input[@label='Qty.']") private WebElement quntity;
	@FindBy(xpath="//input[@label='Price']") private WebElement price;
	@FindBy(xpath="//input[@label='Trigger price']")private WebElement triggerprice;
	
	@FindBy(xpath="//label[text()='Market']")private WebElement marketorder;
	@FindBy(xpath="//label[text()='Limit']")private WebElement limitorder;
	@FindBy(xpath="//label[text()='SL']")private WebElement stoploss;
	@FindBy(xpath="//label[text()='SL-M']")private WebElement marketstoploss;
	@FindBy(xpath="//button[@type='submit']")private WebElement Buyshare;
	@FindBy(xpath="//button[@type='submit']") private WebElement Sellshare;
	@FindBy(xpath="//button[text()='Cancel ']") private WebElement cancelshare;
	@FindBy(xpath="//span[@class='symbol']") private List<WebElement> searchable;
	@FindBy(xpath="//span[@class='tradingsymbol']") private List <WebElement> multiSahres ;

public Zerodha_HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public boolean checkAsserionforcreateGTT() {
	boolean nameOfSearch=createGTT.isSelected();
	return nameOfSearch;
	
}
public void searchBox(String name) {
	search.sendKeys(name);
}
public void clickOnBuybutton(WebDriver driver,String shareName) throws InterruptedException {
	int number=multiSahres.size();
	//System.out.println(number);
	for(int i=0;i<=number-1;i++) {
		WebElement search=multiSahres.get(i);
		//System.out.println(search.getText());
		if(search.getText().equals(shareName)) {
			Actions action=new Actions(driver);
			action.moveToElement(search).perform();
			Thread.sleep(2000);
			buyShare2.click();	
		}
		
			}
	}
public void clickonsellbutton(WebDriver driver,String nameofshare) {
	Actions action=new Actions(driver);
	for(WebElement share:multiSahres) {
		if(share.getText().equals(nameofshare)) {
			try {
				action.moveToElement(share).build().perform();
			}
			catch(Exception e) {
				action.moveToElement(share).build().perform();
			}
			sellShare2.click();
		}
	}
	
	}
public void  clickonmarketdepth() {
marketDepth.click();
}
public void clickongraph() {
	graph.click();
}
public void clickondelete() {
	delete.click();
}
public void clickonmore() {
	more.click();
}
public void clickonintradayradio() {
	intradayradio.click();
}
public void clickonlongtermradio() {
	longtermradio.click();
}
public void chosequntity(String qty) {
	quntity.sendKeys(qty);
}
public void enterprice(String Price) {
	price.clear();
	price.sendKeys(Price);
}
public void entertriggerprice(String triggervalue) throws InterruptedException {
	//triggerprice.sendKeys(Keys.CLEAR);
	triggerprice.clear();
	triggerprice.clear();
	triggerprice.sendKeys(triggervalue);
}

public void clickOnlimitorder() {
	limitorder.click();
}
public void clickOnstoploss() {
	stoploss.click();
}
public void clickOnmarketstoploss() {
	marketstoploss.click();
}
public void clickOnmarketorder() {
	marketorder.click();
}
public void clickonBuyshare() {
	Buyshare.click();
}
public void clickonSellshare() {
	Sellshare.click();
}
public void clickoncancelshare() {
	cancelshare.click();
}
public void order() {
	orders.click();
}
public void performActionInGTT(WebDriver driver,String stock,String matchstock ) throws InterruptedException {
	Actions act=new Actions(driver);
	act.moveToElement(GTT).click().build().perform();
	act.moveToElement(NewGTT).click().build().perform();
	searchstockGTT.sendKeys(stock);
	Thread.sleep(2000);
	int number=SearchInGTT.size();
	for(int i=0;i<=number;i++) {
		WebElement matchingstock=SearchInGTT.get(i);
		if(matchingstock.getText().equals(matchstock)) {
		act.moveToElement(matchingstock).click().perform();
		}
	}
	
}
public void enteraStockInGTT(String stock) {
	searchstockGTT.sendKeys(stock);
}

public void clickoncreatGTT(WebDriver driver) throws InterruptedException {

	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",createGTT);
	Thread.sleep(3000);
	createGTT.click();
}

public void clickondashboard() {
	dashboard.click();
}
public void clickonHoldings() {
	Holding.click();
}
public void clickonPositions() {
	Positions.click();
}
public void clickonFunds() {
	Funds.click();
}
public void clickonApp() {
	App.click();
}













}