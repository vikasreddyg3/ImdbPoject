package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImdbPages
{
	WebDriver driver;
	@FindBy(xpath="//input[@id='suggestion-search']")
	WebElement SearchField;
	public WebElement getSearchField()
	{
		return SearchField;
	}
	
	@FindAll(@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/table/tbody/tr/td[2]"))
	List<WebElement> RelatedSearchResult;
	public List<WebElement> getRelatedSearchResult()
	{
		return RelatedSearchResult;
	}
	
	@FindBy(xpath="//body/div[@id='wrapper']/div[@id='root']/div[@id='pagecontent']/div[@id='content-2-wide']/div[@id='main']/div[1]/div[2]/table[1]")
	WebElement ResultTable;
	public WebElement getResultTable()
	{
		return ResultTable;
	}
	
	@FindBy(xpath="//*[@id=\"main\"]/div/h1")
	WebElement ResultNotFound;
	public WebElement getResultNotFound()
	{
		return ResultNotFound;
	}
	
	@FindBy(linkText="Sign In")
	WebElement SignInBtn;
	public WebElement getSignInBtn()
	{
		return SignInBtn;
	}
	
	@FindBy(linkText="Create a New Account")
	WebElement CreateAccountBtn;
	public WebElement getCreateAccountBtn()
	{
		return CreateAccountBtn;
	}
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement NameField;
	public WebElement getNameField()
	{
		return NameField;
	}
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement EmailIdField;
	public WebElement getEmailIdField()
	{
		return EmailIdField;
	}
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement PasswordField;
	public WebElement getPasswordField()
	{
		return PasswordField;
	}
	
	@FindBy(xpath="//input[@id='ap_password_check']")
	WebElement PasswordCheck;
	public WebElement getPasswordCheck()
	{
		return PasswordCheck;
	}
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement CreateImdbBtn;
	public WebElement getCreateImdbBtn()
	{
		return CreateImdbBtn;
	}
	
	
	
	public ImdbPages(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	
	

}




