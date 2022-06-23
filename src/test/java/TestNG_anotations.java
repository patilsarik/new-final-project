

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNG_anotations {

	@DataProvider(name="crediantial")
	public Object[][] data(){
		return new Object[][] {{"velocity"," mumbai"},{"katraj","pune"},{"pune","hello"}};
	}
	@Test(dataProvider="crediantial")
	public void usedataprovider(String value,String pass) {
		System.out.println(value+pass);
	}
//	@Test
//	public void test1() {
//		System.out.println("test1 executed");
//	}
//	
//	@Test
//	public void test2() {
//		System.out.println("test2 executed");
//	}
//	@BeforeClass
//	public void beforecls() {
//		System.out.println("before class executed");
//	}
//	@AfterClass
//	public void aftercls() {
//		System.out.println("after class executed");
//	}
//	
//	@BeforeMethod
//	public void beforemethod() {
//		System.out.println("before method executed");
//	}
//	
//	@AfterMethod//5,8,11
//	public void aftermethod() {
//		System.out.println("after method executed");
//	}
//	
//	//parameterization
//	@Test
//	@Parameters({"a1","a2"})
//	public void addition(int a,int b) {
//		System.out.println(a+b);
//	}
//	
	
	
	
}
