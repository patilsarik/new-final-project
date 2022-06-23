package Utility;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class ChildBrowserPopup {

	public static void childPopUp(WebDriver driver) {
		Set<String> address=driver.getWindowHandles();
		Iterator<String> i=address.iterator();
		while(i.hasNext()) {
			String SingleAddress=i.next();
			driver.switchTo().window(SingleAddress);			
		}
	}
}
