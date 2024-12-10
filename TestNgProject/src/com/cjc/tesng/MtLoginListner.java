package com.cjc.tesng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(UsingISuiteListner.class)
public class MtLoginListner {

	WebDriver driver;
	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.driver.chrome","F:\\Hibernateprogram\\HibernateWorkspace\\\\SeleniumBasicsProject\\executable\\chromedriver.exe");
		driver =new ChromeDriver();
		System.out.println("Before Suite");
	}
	@BeforeTest
	public void enterUrl() {
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
	}
	@BeforeClass
	public void WindowHandle() {
		driver.manage().window().maximize();
		System.out.println("This is before class");
		
	}
	@BeforeMethod
	public void displayCookies() {
		System.out.println("This is Before Method");
	}
	@Test
	public void loginChekck() {
		driver.findElement(By.name("userName")).sendKeys("QQQQ");
		driver.findElement(By.name("password")).sendKeys("qqqq");
		driver.findElement(By.name("submit")).click();
	}
	
}

