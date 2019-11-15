package com.test.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.hubspot.pages.ContactsPage;
import com.test.hubspot.pages.HomePage;
import com.test.hubspot.pages.LoginPage;

public class ContactsPageTest extends BaseTest{

	@Test(priority=2)
	public void validateContactsPageTitleTest()
	{
		HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		page.getInstance(HomePage.class).validateClickOnContactsDropMenu();
		ContactsPage contactspage=page.getInstance(HomePage.class).validateClickOnContactsOption();
		
		String contactspageTitle=page.getInstance(ContactsPage.class).validateContactsPageTitle();
		System.out.println("The actual contacts page title is : "+contactspageTitle);
		Assert.assertEquals(contactspageTitle, "Contacts");
	}
	
	@Test(priority=2)
	public void validateContactsPageHeaderTest()
	{
		HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		page.getInstance(HomePage.class).validateClickOnContactsDropMenu();
		ContactsPage contactspage=page.getInstance(HomePage.class).validateClickOnContactsOption();
		
		String actualHeader=page.getInstance(ContactsPage.class).validateContactsPageHeader();
	    System.out.println("The actual contacts page header is : "+actualHeader);
		Assert.assertEquals(actualHeader, "Contacts");
	}
	
	@Test(priority=2)
	public void validateCreateContactBtnTest()
	{
		HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		page.getInstance(HomePage.class).validateClickOnContactsDropMenu();
		ContactsPage contactspage=page.getInstance(HomePage.class).validateClickOnContactsOption();
		
		Assert.assertTrue(page.getInstance(ContactsPage.class).validateCreateContactBtn());
	}

}
