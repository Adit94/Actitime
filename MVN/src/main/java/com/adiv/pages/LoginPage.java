package com.adiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id="userName")
	private WebElement unTbx;
	@FindBy(id="passWord")
	private WebElement pwTbx;
	@FindBy(xpath="//input[@title='Sign In']")
	private WebElement LoginBtn;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void login(String un,String pwd) 
	{
		unTbx.sendKeys(un);
		pwTbx.sendKeys(pwd);
		LoginBtn.click();
	}
}
