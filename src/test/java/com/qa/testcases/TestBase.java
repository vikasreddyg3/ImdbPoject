package com.qa.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestBase 
{
	WebDriver driver;
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
		
		driver.get(Url);
	}
	
	
	 public void CaptureScreenshot(WebDriver driver, String name) throws IOException
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File Source=ts.getScreenshotAs(OutputType.FILE);
			File target=new File(System.getProperty("user.dir")+"/Screenshots/"+name+System.currentTimeMillis()+".png");
			FileUtils.copyFile(Source,target);
			System.out.println("Screenshot captured");
			
		}

	@AfterClass
	public void terminate()
	{
		driver.close();
	}
	
	
}
