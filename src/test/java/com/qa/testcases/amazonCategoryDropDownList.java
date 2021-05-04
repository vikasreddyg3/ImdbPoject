package com.qa.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.BaseTest.TestBaseAutomatinTesting;
import com.qa.pages.amazonCategoryDropDownListPages;
import com.qa.utility.ExcelUtility;
//import com.qa.utility.ExcelUtility;

public class amazonCategoryDropDownList extends TestBaseAutomatinTesting
{
	    @Test(dataProvider ="getDataFromDataprovider")
		public void Iteams(String Key, String Value) throws InterruptedException
		{
		//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://www.google.com/");
		amazonCategoryDropDownListPages ref=new amazonCategoryDropDownListPages(driver);
		//WebElement Category_dropDown=driver.findElement(By.id("searchDropdownBox"));
		Select Category=new Select(ref.getSelectForCategoryIteam());
		Category.selectByVisibleText(Key);
		ref.getSearchForIteam().clear();
		ref.getSearchForIteam().sendKeys(Value ,Keys.ENTER);
		Thread.sleep(5000);
//		String showingSearchResultText = driver.findElement(By.xpath("//span[contains(text(),'\"" + Value + "\"')]")).getText();
//		softAssertion.assertEquals(showingSearchResultText, '"' + value + '"');
		List<WebElement> relatedIteams=ref.getIteamsOfList();
		//List<WebElement> price=ref.getIteamPrice();
		
		String title;
		String price;
		
		
		for(WebElement iteam:relatedIteams)
		{
			try
			{
				title=iteam.findElement(By.tagName("h2")).getText();
				price=iteam.findElement(By.className("a-price-whole")).getText();
				Reporter.log("price of"+title+ "is Rs."+price ,true);
			}
			catch(Exception e)
			{
				System.out.println("item is missing");
			}
				
				
			
		}
		
		/*List<WebElement> Category_list=Category.getOptions();
		int total_Category=Category_list.size();
		System.out.println("Total Category Count is "+ total_Category);
		for(WebElement ele:Category_list)
		{
			String Category_name=ele.getText();
			System.out.println("Categories----> "+Category_name);
		}*/
		//driver.close();
		}
		@DataProvider(name="getDataFromDataprovider")
		public String[][] getDataFromDataprovider() throws IOException {
		//	return new Object[][] { { "Books", "Aptitude" }, { "Electronics", "Fridge" },
			//	{ "Furniture", "Doors" } };
			
			String xlpath="F:\\Virtusa_workspace_oxygen\\IAT\\src\\test\\java\\com\\qa\\testdata\\testDataAmazon.xlsx";
			String Xlsheet="Sheet1";
			
			int rowCount=ExcelUtility.getRowCount(xlpath, Xlsheet);
			int cellCount=ExcelUtility.getCellCount(xlpath, Xlsheet, rowCount);
			
			String[][] data =new String[rowCount][cellCount];
			
			for(int i=1;i<rowCount;i++)
			{
				for(int j=0;j<cellCount;j++)
				{
					data[i-1][j]=ExcelUtility.getCellData(xlpath,Xlsheet, i, j);
				}
			}
			return data;
		

		}

	

}


