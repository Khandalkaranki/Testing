package com.cjc.tesng;

import java.io.File;
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
import org.testng.annotations.Test;

public class UsingGroupingConcept {
	WebDriver driver;

	@BeforeSuite(groups= {"abc"})
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"F:\\Hibernateprogram\\HibernateWorkspace\\SeleniumBasicsProject\\executable\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest(groups = {"abc"})
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
		System.out.println("Before Method");
	}

	@Test(groups= {"abc"})
	public void loginCheck() {
		driver.findElement(By.name("userName")).sendKeys("QQQQ");
		driver.findElement(By.name("password")).sendKeys("qqqq");
		driver.findElement(By.name("submit")).click();

	}

}
