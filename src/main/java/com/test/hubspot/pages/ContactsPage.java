package com.test.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}

	//OR - Here we will implement encapsulation by making the elements private and using getters
	By pageHeader=By.xpath("//div[@class='private-header__inner']/descendant::*[contains(text(),'Contacts')]");
	By createContactBtn=By.xpath("//div[@class='m-left-3 UIColumn-content']/descendant::span[contains(text(),'Create contact')]");
		
	//getters - we will encapsulate the data(OR) into the getters and call these methods in action methods
	public By getPageHeader() {
		return pageHeader;
	}
	public By getCreateContactBtn() {
		return createContactBtn;
	}

	//Action Methods
	public String validateContactsPageTitle()
	{
		explicitWaitTillByElementVisible(getCreateContactBtn());
		return driver.getTitle();
	}
	public String validateContactsPageHeader()
	{
		explicitWaitTillByElementVisible(getPageHeader());
		return driver.findElement(getPageHeader()).getText();
	}
	public boolean validateCreateContactBtn()
	{
		explicitWaitTillByElementVisible(getCreateContactBtn());
		return driver.findElement(getCreateContactBtn()).isEnabled();
	}	
	
	
}
