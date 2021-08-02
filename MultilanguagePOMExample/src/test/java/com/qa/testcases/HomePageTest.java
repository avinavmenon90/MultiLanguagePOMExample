package com.qa.testcases;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.configreader.ConfigPropertiesFileReader;
import com.qa.factory.DriverFactory;
import com.qa.pageobjects.HomePage;

public class HomePageTest {

	DriverFactory df;
	ConfigPropertiesFileReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	
	
	@BeforeTest
	public void setUp() {
		
		cp = new ConfigPropertiesFileReader();
		prop = cp.initLangProp(); //pass the language so the right prop file can be loaded
		df = new DriverFactory();
		driver = df.initDriver("chromE", prop);
		
		homePage = new HomePage(driver); //initialize HomePage class obj and ElementUtil class obj (through HomePage constructor)
	}
	
	@Test(priority=1)
	public void headerTest() throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertTrue(homePage.isHeaderExist(prop.getProperty("header")));
	}
	
	@Test(priority=2)
	public void contactLinkText() throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertTrue(homePage.isContactExist(prop.getProperty("contactlinktext")));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
}
