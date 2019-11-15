package com.test.hubspot.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.hubspot.pages.HomePage;
import com.test.hubspot.pages.LoginPage;

public class LoginPageTest extends BaseTest{

	
    @Test(priority=0,enabled=false)
	public void validateloginPageTitleTest()
	{
    	System.out.println("*********Test Case - validateloginPageTitleTest() *********");
		String loginPageTitle=page.getInstance(LoginPage.class).validateLoginPageTitle();
		System.out.println("Actual LoginPage title is : "+loginPageTitle);
		Assert.assertEquals(loginPageTitle, "HubSpot Login");
	}
    
    @Test(priority=0,enabled=false)
    public void validatetextboxIsDisplayedTest()
	{
    	System.out.println("*********Test Case - validatetextboxIsDisplayedTest() *********");
		Boolean usernameValue=page.getInstance(LoginPage.class).validateUsernameTextboxDisplayed();
		Assert.assertTrue(usernameValue);
		Boolean passwordValue=page.getInstance(LoginPage.class).validatePasswordTextboxDisplayed();
		Assert.assertTrue(passwordValue);
	} 
    
    @Test(priority=0)
    public void validateloginTest()
	{
    	System.out.println("*********Test Case - validateloginTest() *********");
    	HomePage homepage=page.getInstance(LoginPage.class).validateLogin(prop.getProperty("username"), prop.getProperty("password"));
    	
    	//validation part after navigation
    	String homepageTitle=page.getInstance(HomePage.class).validateHomePageTitle();
		System.out.println("The actual homepage title is : "+homepageTitle);
		Assert.assertEquals(homepageTitle, "Account Setup | HubSpot");
		
	}
}
