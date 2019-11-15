package com.test.hubspot.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.test.hubspot.pages.BasePage;
import com.test.hubspot.pages.Page;


public class BaseTest {

	public Page page;
	public WebDriver driver;
	public WebDriverWait wait;
	public Properties prop;

	@BeforeMethod
	public void initialSetup()
	{
		try {
			System.out.println("*********@BeforeMethod*********");
			prop=new Properties();
			FileInputStream ip = new FileInputStream("D://Learning//Workspace//POMGenericsFramework//src//main//java//com//test//hubspot//properties//config.properties");
			prop.load(ip);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		
		
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
				ChromeOptions options=new ChromeOptions();
				options.setHeadless(true);
				driver=new ChromeDriver(options);
			}
			else
			{
				driver=new ChromeDriver();
			}
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
			if(prop.getProperty("headless").equals("yes"))
			{
				FirefoxOptions options=new FirefoxOptions();
				options.setHeadless(true);
				driver=new FirefoxDriver(options);
			}
			else
			{
				driver=new FirefoxDriver();
			}
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		page=new BasePage(driver, wait);   //very important creation of object of abstract class using subclass
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("*********@AfterMethod*********");
		driver.close();
	}
}
