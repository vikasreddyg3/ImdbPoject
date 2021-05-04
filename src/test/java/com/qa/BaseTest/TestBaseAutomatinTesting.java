package com.qa.BaseTest;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.pages.amazonCategoryDropDownListPages;

public class TestBaseAutomatinTesting 
{
	public WebDriver driver;
	amazonCategoryDropDownListPages ref;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void SetUp(String Browser,String Url)
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64/msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
		/*System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();*/
		driver.get(Url);
	}
	@AfterClass
	public void terminate()
	{
		driver.close();
	}

}
