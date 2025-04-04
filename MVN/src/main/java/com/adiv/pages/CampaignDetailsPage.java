package com.adiv.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CampaignDetailsPage 
{
	WebDriver driver;
	@FindBy(linkText="Logout [rashmi@dell.com]")
	private WebElement LogoutLink;


	public CampaignDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void verifyTitle(WebDriver driver, String exp_title)
	{	
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, exp_title,"Title does not match");
	}

	public void verifyDetails(String expt_Campaign_Name, String expt_Type, String expt_Status, String expt_Start_date, String expt_End_date, String expt_Expected_Revenue, String expt_Budgeted_Cost, String expt_Actual_Cost, String expt_Expected_Response, String expt_Num_sent)
	{
		Assert.assertEquals(driver.findElement(By.id("Campaign Name")).getText(), expt_Campaign_Name,"Campaign Name mismatch");
		Assert.assertEquals(driver.findElement(By.id("Type")).getText(), expt_Type,"Campaign Type mismatch");
		Assert.assertEquals(driver.findElement(By.id("Status")).getText(), expt_Status,"Campaign Status mismatch");
		Assert.assertEquals(driver.findElement(By.id("Start Date")).getText(), expt_Start_date,"Start Date mismatch");
		Assert.assertEquals(driver.findElement(By.id("End Date")).getText(), expt_End_date,"End Date mismatch");
		Assert.assertEquals(driver.findElement(By.id("Expected Revenue")).getText(), expt_Expected_Revenue,"Expected Revenue mismatch");	
		Assert.assertEquals(driver.findElement(By.id("Budgeted Cost")).getText(), expt_Budgeted_Cost,"Budgeted Cost mismatch");	
		Assert.assertEquals(driver.findElement(By.id("Actual Cost")).getText(), expt_Actual_Cost,"Actual Cost mismatch");	
		Assert.assertEquals(driver.findElement(By.id("Expected Response")).getText(), expt_Expected_Response,"Expected Response mismatch");	
		Assert.assertEquals(driver.findElement(By.id("Num sent")).getText(), expt_Num_sent,"Num sent mismatch");			
	}
	public void logout()
	{
		LogoutLink.click();
	}
}