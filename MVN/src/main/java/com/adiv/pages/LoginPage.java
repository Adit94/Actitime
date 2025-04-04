package com.adiv.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage 
{
	@FindBy(xpath="//title[text()='Zoho CRM - Sign in']")
	private WebElement Titletxt;
	@FindBy(id="userName")
	private WebElement loginTxtfld;
	@FindBy(id="passWord")
	private WebElement pwdTxtfld;
	@FindBy(xpath="//input[@title='Sign In']")
	private WebElement signBtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String username,String password)
	{
		loginTxtfld.sendKeys(username);
		pwdTxtfld.sendKeys(password);
		signBtn.click();
	}

}