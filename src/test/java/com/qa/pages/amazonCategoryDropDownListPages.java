package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class amazonCategoryDropDownListPages 
{
	WebDriver driver;
	
	@FindBy(name="q")
	WebElement SearchForAmazon;
	public WebElement getSearchForAmazon()
	{
		return SearchForAmazon;
	}
	
	@FindBy(name="q")
	WebElement PressEnter;
	public WebElement getPressEnter()
	{
		return PressEnter;
	}
	@FindBy(xpath="//*[@id=\"tads\"]/div/div/div/div[1]/a/div[1]")
	WebElement ClickOnTheLink;
	public WebElement getClickOnTheLink()
	{
		return ClickOnTheLink;
	}
	
	@FindBy(xpath="//*[@id=\"searchDropdownBox\"]")
	WebElement ClickOnDrownDownList;
	public WebElement getClickOnDrownDownList()
	{
		return ClickOnDrownDownList;
	}
	@FindBy(id="searchDropdownBox")
	WebElement SelectForCategoryIteam;
	public WebElement getSelectForCategoryIteam()
	{
		return SelectForCategoryIteam;
	}
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchForIteam;
	public WebElement getSearchForIteam()
	{
		return SearchForIteam;
	}
	@FindAll(@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[3]/div[2]/div/div[1]/span[1]/div[1]/div[1]"))
	List<WebElement> IteamsOfList;
	public List<WebElement> getIteamsOfList()
	{
		return IteamsOfList;
	}
	@FindAll(@FindBy(className="a-price-whole"))
	List<WebElement> IteamPrice;
	public List<WebElement> getIteamPrice()
	{
		return IteamPrice;
	}
	
	
	public amazonCategoryDropDownListPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	

}
