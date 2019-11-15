package com.test.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{

	public BasePage(WebDriver driver, WebDriverWait wait) 
	{
		super(driver, wait);
		System.out.println("*********BasePage Constructor*********");
	}
	//specify the body of the generic action methods
	@Override
	public void onClick(By locator) {
		driver.findElement(locator).click();		
	}

	@Override
	public void onSendKeys(By locator, String value) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);		
	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();		
	}
	
	//specify the body of generic action util methods
	@Override
	public void explicitWaitTillByElementVisible(By locator)
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
}
