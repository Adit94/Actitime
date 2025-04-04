package com.adiv.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage 
{
	@FindBy(xpath="//title[contains(text(),'Home Page')]")
	private WebElement Titletxt;
	@FindBy(linkText="Campaigns")
	private WebElement CampnMd;
	@FindBy(partialLinkText="Logout")
	private WebElement Logoutbtn;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void verifyTitle(WebDriver driver, String exp_title)
	{	
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, exp_title,"Title does not match");
	}
	public void setCampn() 
	{
		CampnMd.click();
	}

	public void setLogout() 
	{
		Logoutbtn.click();
	}
}


