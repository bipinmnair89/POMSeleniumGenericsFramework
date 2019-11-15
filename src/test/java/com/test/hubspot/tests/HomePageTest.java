package com.test.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.hubspot.pages.ContactsPage;
import com.test.hubspot.pages.HomePage;
import com.test.hubspot.pages.LoginPage;

public class HomePageTest extends BaseTest{
	
	SoftAssert softassert;

	@Test(priority=1)
	public void validateHomePageTitleTest()
	{
    	HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
    	
		String homepageTitle=page.getInstance(HomePage.class).validateHomePageTitle();
		System.out.println("The actual homepage title is : "+homepageTitle);
		Assert.assertEquals(homepageTitle, "Account Setup | HubSpot");
	}
	@Test(priority=1)
	public void validatedContactsIsDisplayedTest()
	{
    	HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
    	
		softassert=new SoftAssert();
		softassert.assertTrue(page.getInstance(HomePage.class).validateContactsDropMenuIsDisplayed());
		page.getInstance(HomePage.class).validateClickOnContactsDropMenu();
		softassert.assertTrue(page.getInstance(HomePage.class).validateContactsOptionIsDisplayed());
		softassert.assertAll();
	}
	@Test(priority=1)
	public void validateNavigationToContactsTest()
	{
    	HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		page.getInstance(HomePage.class).validateClickOnContactsDropMenu();
		ContactsPage contactspage=page.getInstance(HomePage.class).validateClickOnContactsOption();
		
		//validation part after navigation
		String contactspageTitle=page.getInstance(ContactsPage.class).validateContactsPageTitle();
		System.out.println("The actual contacts page title is : "+contactspageTitle);
		Assert.assertEquals(contactspageTitle, "Contacts");
	}
}
