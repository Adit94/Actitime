package com.adiv.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CampaignListPage 
{
	@FindBy(xpath="//input[@value='New Campaign']")
	private WebElement NewCampnBtn;
	public CampaignListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void setNewCampn() 
	{
		NewCampnBtn.click();
	}
	public void verifyTitle(WebDriver driver, String exp_title)
	{	
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, exp_title,"Title does not match");
	}
}