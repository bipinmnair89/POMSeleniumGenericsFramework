/**
 * 
 */
package com.test.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author bipin
 * In using this generics POM framework Page class is the super abstract class
 */
public abstract class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	//first, create the constructor of Page class which would initialize the driver and wait
	public Page(WebDriver driver, WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(this.driver,10);
		System.out.println("*********Page Constructor*********");
	}
	
	//second, add the signature for the abstract methods used in every Page class(generic action methods)
	public abstract void onClick(By locator);
	
	public abstract void onSendKeys(By locator, String value);
	
	public abstract String getPageTitle();
	
	public abstract void explicitWaitTillByElementVisible(By locator);
	
	//third, write the Java generics method that accepts class name and returns a new instance of that class
	public <TPage extends BasePage>TPage getInstance(Class<TPage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class,WebDriverWait.class).newInstance(this.driver,this.wait);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}		
	}
	
	
	
	
	
	
	
	
	
}
