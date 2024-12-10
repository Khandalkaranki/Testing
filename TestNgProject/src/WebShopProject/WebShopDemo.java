package WebShopProject;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebShopDemo {
	@BeforeSuite
	public void OpenBrowser() {
		
	}
	@BeforeTest
	public void UrlOpen() {
		
	}
	@BeforeClass
	public void PageLoad() {
		
	}
	@BeforeMethod
	public void CookiesDetali()
	{
		
	}
	@Test
	public void LoginTest()
	{

	}
	@AfterMethod
	public void  CaptureScreenShot()
	{
	
	}
	@AfterClass
	public void deleteCookies() {
		
	}
	@AfterTest
	public void closeDb() {
		
	}
	@AfterSuite
	public void BrowserClose() {
		
	}
	@DataProvider
	public Object [][] getData(){
		return new Object[][]{new Object[] {""}
	};
		
	}
			
					}
