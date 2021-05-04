package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.ImdbPages;
import com.qa.utility.ExcelUtility;

public class Tc_ImdbSign extends TestBase
{
	@Test(dataProvider="data")
	public void Sign(String name,String emailId,String password,String checkPassword) throws IOException, InterruptedException
	{
		
		
		ImdbPages object=new ImdbPages(driver);
		//driver.manage().window().maximize();
		object.getSignInBtn().click();
		
		object.getCreateAccountBtn().click();
		CaptureScreenshot(driver,"Sign");
		object.getNameField().sendKeys(name);
		object.getEmailIdField().sendKeys(emailId);
		object.getPasswordField().sendKeys(password);
		object.getPasswordCheck().sendKeys(checkPassword);
		object.getCreateImdbBtn().click();
		Thread.sleep(1000);
		
	}
	@DataProvider(name="data")
	public Object[][] getData() throws IOException
	{
		/*Object[][] data=new Object[1][4];
		data[0][0]="vikas";
		data[0][1]="test@test.com";
		data[0][2]="imdb1234sakiv";
		data[0][3]="imdb1234sakiv";*/
		
		
		String xlpath="F:\\Virtusa_workspace_oxygen\\IAT\\src\\test\\java\\com\\qa\\utility\\imdbmvsignintestdata.xlsx";
		String Xlsheet="Sheet2";
		
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
