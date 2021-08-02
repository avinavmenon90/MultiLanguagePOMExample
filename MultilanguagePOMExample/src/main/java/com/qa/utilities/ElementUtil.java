package com.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Class used to create utilties
 * to capture page locators
 * and return a Webelement
 * 
 */
public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public WebElement getElement(String locatorType, String locatorValue)
	{

		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public By getBy(String locatorType, String locatorValue) {
		
		By locator = null;
		
		if((locatorType.equalsIgnoreCase( "id")))
			locator = By.id(locatorValue);
		
		else if((locatorType.equalsIgnoreCase("xpath")))
			locator = By.xpath(locatorValue);
			
		else if((locatorType.equalsIgnoreCase("name")))
			locator = By.name(locatorValue);
		
		else if((locatorType.equalsIgnoreCase("css")))
			locator = By.cssSelector(locatorValue);
		
		else if((locatorType.equalsIgnoreCase("linktext")))
			locator = By.linkText(locatorValue);
		
		return locator;
	}
}
