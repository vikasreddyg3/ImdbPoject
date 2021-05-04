package com.qa.testcases;



import java.io.IOException;
import java.util.List;

//import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.ImdbPages;
import com.qa.utility.ExcelUtility;

public class Tc_Imdb extends TestBase
{
	
	@Test(dataProvider="getData")
	public void imdb(String input) throws InterruptedException, IOException
	{
		
	 ImdbPages object=new ImdbPages(driver);
	 //driver.manage().window().maximize();
	 object.getSearchField().sendKeys(input, Keys.ENTER);
	 Thread.sleep(5000);

		CaptureScreenshot(driver,"imdb");
	 Boolean resultsFound ;
	 try {
		 
		 object.getResultTable().isDisplayed();
			 resultsFound= true;
		 
	 }
	 catch(NoSuchElementException e) {
		 resultsFound = false;
		 
	 }
	 
	 if(resultsFound) 
	 {
		 List<WebElement> result=object.getRelatedSearchResult();
		 for(WebElement ele:result)
		 {
			 Reporter.log(ele.getText(), true);
		 }
	}
	 else 
	 {
		 Reporter.log("No Result Found", true);
		 }


	 }
	@DataProvider(name="getData")
	public Object[][] getDataProvider() throws IOException 
	{
		/*Object[][] data=new Object[3][1];
		data[0][0]="Avangers";
		data[1][0]="Marvel";
		data[2][0]="@#%$&";*/
		
		String xlpath="F:\\Virtusa_workspace_oxygen\\IAT\\src\\test\\java\\com\\qa\\utility\\imdbmvsignintestdata.xlsx";
		String Xlsheet="Sheet1";
		
		int rowCount=ExcelUtility.getRowCount(xlpath, Xlsheet);
		int cellCount=ExcelUtility.getCellCount(xlpath, Xlsheet, rowCount);
		
		String[][] data =new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlpath,Xlsheet, i, j);
			}
		}
		return data;
	}
		
	
}
