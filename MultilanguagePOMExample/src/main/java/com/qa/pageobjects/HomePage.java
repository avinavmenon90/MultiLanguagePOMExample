package com.qa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.utilities.ElementUtil;

public class HomePage {
	
	private ElementUtil elementUtil;

	public HomePage(WebDriver driver) {
		
		elementUtil = new ElementUtil(driver);
	}
	
	private WebElement getPageHeaderElement (String headerValue) {
		
		String headerXpathValue = "//a[contains(text(),'"+headerValue+"')]";
		return elementUtil.getElement("xpath", headerXpathValue);
	}
	
	public boolean isHeaderExist(String headerValue){
		
		String headerText = getPageHeaderElement(headerValue).getText();
		System.out.println("header text is: "+headerText);
		
		return getPageHeaderElement(headerValue).isDisplayed();
	}
	
	private WebElement getContactElement (String contactLinkValue) {
		
		String contactXpathValue="//a[(text()='"+contactLinkValue+"')]";
		return elementUtil.getElement("xpath", contactXpathValue);
	}
	
	public boolean isContactExist(String contactLinkValue){
		
		String contactLinkText = getContactElement(contactLinkValue).getText();
		System.out.println("contact link text is:"+contactLinkText);
		
		return getContactElement(contactLinkValue).isDisplayed();
	}
	
}
