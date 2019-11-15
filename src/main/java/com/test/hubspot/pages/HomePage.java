package com.test.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	//OR
	By contactsdropdownLink=By.xpath("//div[@class='desktop-nav-left-container']/descendant::a[contains(text(),'Contacts')]");
	By contactsOption=By.xpath("//div[@class='desktop-nav-left-container']/descendant::div[contains(text(),'Contacts')]");
	By conversationsLink=By.xpath("//div[@class='desktop-nav-left-container']/descendant::a[contains(text(),'Conversations')]");

	//action methods
	public String validateHomePageTitle()
	{
		explicitWaitTillByElementVisible(contactsdropdownLink);
		return driver.getTitle();
	}
	
	public boolean validateContactsDropMenuIsDisplayed()
	{
		explicitWaitTillByElementVisible(contactsdropdownLink);
		return driver.findElement(contactsdropdownLink).isDisplayed();
	}
		
	public void validateClickOnContactsDropMenu()
	{		
		explicitWaitTillByElementVisible(contactsdropdownLink);
		driver.findElement(contactsdropdownLink).click();
	}
	
	public boolean validateContactsOptionIsDisplayed()
	{
		explicitWaitTillByElementVisible(contactsOption);
		return driver.findElement(contactsOption).isDisplayed();
	}
	
	public ContactsPage validateClickOnContactsOption()
	{
		explicitWaitTillByElementVisible(contactsOption);
		driver.findElement(contactsOption).click();
		return getInstance(ContactsPage.class);
	}
	
	
	
}
