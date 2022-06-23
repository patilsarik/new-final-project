package Utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	
	public static void takescreenshot(WebDriver driver,String name) throws IOException {
	String date=ScreenShot.datetime();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("E:\\Velocity\\API\\all ss\\"+name+ date+".jpg");
		FileHandler.copy(source, destination);
			}
	public static String datetime() {
		String d=DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss").format(LocalDateTime.now());
        return d;
	}
	
}
