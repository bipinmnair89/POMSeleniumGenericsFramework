package com.test.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver, WebDriverWait wait) 
	{
		super(driver, wait);
		System.out.println("*********LoginPage Constructor*********");
	}

	//OR with access specifier as private to encapsulate
	By username=By.xpath("//*[@id='username']");
	By password=By.xpath("//*[@id='password']");
	By loginButton=By.xpath("//*[@type='submit' and @id='loginBtn']");
	
	//action methods
	public String validateLoginPageTitle()
	{
		System.out.println("*********LoginPage Action Method - validateLoginPageTitle() *********");
		explicitWaitTillByElementVisible(username);
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	
	public boolean validateUsernameTextboxDisplayed()
	{
		System.out.println("*********LoginPage Action Method - validateUsernameTextboxDisplayed() *********");
		explicitWaitTillByElementVisible(username);
		return driver.findElement(username).isDisplayed();
	}
	
	public boolean validatePasswordTextboxDisplayed()
	{
		System.out.println("*********LoginPage Action Method - validatePasswordTextboxDisplayed() *********");
		explicitWaitTillByElementVisible(password);
		return driver.findElement(password).isDisplayed();
	}
	
	public HomePage validateLogin(String paramUsername,String paramPassword)
	{
		System.out.println("*********LoginPage Action Method - validateLogin()  *********");
		explicitWaitTillByElementVisible(username);
		onSendKeys(username, paramUsername);
		onSendKeys(password, paramPassword);
		onClick(loginButton);
		return getInstance(HomePage.class);  //as we are navigating to homepage on click of login button
	}
	


	
}
