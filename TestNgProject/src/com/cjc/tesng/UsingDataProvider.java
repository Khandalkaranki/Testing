package com.cjc.tesng;

import java.io.File;

import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class UsingDataProvider {
	WebDriver driver;

	@BeforeSuite
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Hibernateprogram\\HibernateWorkspace\\SeleniumBasicsProject\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void EnterUrl() {
		driver.get("https://jpetstore.aspectran.com/account/newAccountForm");

	}

	@BeforeClass
	public void HandledWindow() {
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void HandleCookied() {
		Set cookies = driver.manage().getCookies();
		int totalno = cookies.size();
		System.out.println(totalno);

	}

	@Test(dataProvider = "getData")
	public void LoginPage(String UserID, String Password, String confiPass, String name, String lasname, String email,
			String phno, String Ad1, String Ad2, String cty, String state, String country, String zipcode) {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(UserID);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(Password);
		driver.findElement(By.cssSelector("input[name='repeatedPassword']")).sendKeys(confiPass);
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lasname);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(phno);
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(Ad1);
		driver.findElement(By.cssSelector("input[name='address2']")).sendKeys(Ad2);
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys(cty);
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys(state);
		driver.findElement(By.cssSelector("input[name='zip']")).sendKeys(country);
		driver.findElement(By.cssSelector("input[name='country']")).sendKeys(zipcode);
		driver.findElement(By.xpath("//option[@value='english']")).click();
		driver.findElement(By.xpath("//option[@value='FISH']")).click();
		driver.findElement(By.xpath("//td/input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//td/input[@name='bannerOption']")).click();
		driver.findElement(By.xpath("//div[@class='button-bar']/button")).click();

	}

	@AfterMethod
	public void CaptureScreenShot() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("F:\\Hibernateprogram\\HibernateWorkspace\\screenshot"));

	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void CloseDb() {
		System.out.println("This is Driver Close");

	}

	@AfterSuite
	public void BrowserClose() {
		driver.close();
		System.out.println("Browser close");

	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "abcd@16", "1234@12", "1234@12", "jiya", "verma", "jiya@134",
				"897727579", "UmreadRoad Nagpur", "KarveNagarPune", "Pune", "Maharashtra", "INDIA", "441304" } 
		};
	}
	
}
