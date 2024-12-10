
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

public class ExampleOfDataProvider {
	WebDriver driver;

	@BeforeSuite
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Hibernateprogram\\HibernateWorkspace\\SeleniumBasicsProject\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Before Suite");
	}

	@BeforeTest
	public void enterUrl() {
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		System.out.println("Before Test");
	}

	@BeforeClass
	public void windowHandle() {
		driver.manage().window().maximize();
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void displayCookies() {
		Set cset = driver.manage().getCookies();
		int totalco = cset.size();
		System.out.println(totalco);
		System.out.println("Before Method");
	}

	@Test(dataProvider = "getData")
	public void logincheck(String uname, String pass) {
		driver.findElement(By.cssSelector("input[name='userName']")).sendKeys(uname);
		driver.findElement(By.cssSelector("input[name='password']1")).sendKeys(pass);
		driver.findElement(By.name("submit")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).clear();
		System.out.println("Test");

	}

	@AfterMethod
	public void captureScreen() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("F:\\Hibernateprogram\\HibernateWorkspace\\screenshot"));
		System.out.println("After class");
	}

	@AfterClass
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		System.out.println("After class");
	}

	@AfterTest
	public void dbClose() {
		System.out.println("Thies is an DbClose");
		System.out.println("After test");
	}

	@AfterSuite
	public void browserClose() {
		driver.close();
		System.out.println("After Suite");
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][]
				{ 
			new Object[] { "QQQQ", "qqqq" }, 
			new Object[] { "ZZZZ", "zzzz" } 
			
		};
	}
}
