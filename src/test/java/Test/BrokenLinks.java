package Test;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class BrokenLinks {
	
	@Test
	public void brokenlink() {
         System.setProperty("webdriver.chrome.driver","E:\\Velocity\\drivers\\chromedriver_win32\\chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.get("http://www.zlti.com");
         
         List<WebElement> list=driver.findElements(By.tagName("a"));
         Iterator<WebElement> i=list.iterator();
         
         while(i.hasNext()) {
        	String url=i.next().getAttribute("href");
        	 
        	 if(url==null||url.isEmpty()) {
        		System.out.println("url is empty or invalid");
        		continue;
        	 }
        	 
        	 try {
        		 URL u=new URL(url);
        		 HttpURLConnection connection=(HttpURLConnection) u.openConnection();
        		 connection.setRequestMethod("HEAD");
        		 connection.connect();
        		 
        		 int responsecode =connection.getResponseCode();
        		 System.out.println(responsecode);
        		 if(responsecode >=400) {
        			 System.out.println(url+" link is broken ");
        		 }
        		 else {
        			 System.out.println(url+" link is valid");
        		 }
        	 }
        	 catch(Exception e) {
        		 System.out.println(e);
        	 }
         }
	    
		
	}
}
