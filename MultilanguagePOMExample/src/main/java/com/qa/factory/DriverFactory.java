package com.qa.factory;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * Class used to initialize the right browser WebDriver
 * based on the browser specified
 */

public class DriverFactory {

	public WebDriver driver;
	
	
	public WebDriver initDriver(String browserName, Properties prop) {
		
		System.out.println("The browser selected is: "+browserName);
		
		if((browserName.equalsIgnoreCase("chrome"))){
			
			System.setProperty("webdriver.chrome.driver", "./src/main/java/com/qa/utilities/Browser WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if((browserName.equalsIgnoreCase("firefox"))){
			
			System.setProperty("webdriver.gecko.driver", "./src/main/java/com/qa/utilities/Browser WebDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if((browserName.equalsIgnoreCase("edge") )){
			
			System.setProperty("webdriver.edge.driver", "./src/main/java/com/qa/utilities/Browser WebDrivers/msedgedriver.exe");
			driver = new EdgeDriver();
			
		}
		else
			System.out.println("Unknown browser: "+browserName);
		
		
	//launch URL
		driver.get(prop.getProperty("url"));
		System.out.println("URL is: "+driver.getCurrentUrl());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		return driver;
		
	}
}
