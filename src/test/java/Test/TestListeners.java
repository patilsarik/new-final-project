package Test;

import java.io.IOException;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenShot;


public class TestListeners extends listnersBaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println(result.getName()+" test starts");
		
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			ScreenShot.takescreenshot(driver,result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	public void onTestSuccess(ITestResult result) {
		System.out.println("the test is successful");
	}
	public void onTestSkipped() {
		System.out.println("the test is skipped");
	}
	
	
}
