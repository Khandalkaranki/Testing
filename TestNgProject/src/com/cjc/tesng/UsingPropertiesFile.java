package com.cjc.tesng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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

public class UsingPropertiesFile {

	public class MTlogin {
		WebDriver driver;
		Properties pro = new Properties();

		@BeforeSuite
		public void openBrowser() throws Exception {

			System.setProperty("webdriver.chrome.driver",
					"F:\\Hibernateprogram\\HibernateWorkspace\\SeleniumBasicsProject\\executable\\chromedriver.exe");
			driver = new ChromeDriver();

			FileInputStream fis = new FileInputStream(
					"F:\\Hibernateprogram\\HibernateWorkspace\\TestNgProject\\mercuryproperties.txt");
			pro.load(fis);

		}

		@BeforeTest
		public void enterUrl() {
			driver.get(pro.getProperty("Url"));
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

		@Test
		public void loginCheck() {
			driver.findElement(By.name("userName")).sendKeys(pro.getProperty("UName"));
			driver.findElement(By.name("password")).sendKeys(pro.getProperty("Pword"));
			driver.findElement(By.name("submit")).click();
		}

	}

}
