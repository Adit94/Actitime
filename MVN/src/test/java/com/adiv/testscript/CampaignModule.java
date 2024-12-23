package com.adiv.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.pages.CreateCampaignPage;
import com.adiv.pages.HomePage;

@Listeners(com.adiv.generic.ListenerImplementation.class)
public class CampaignModule extends BaseClass
{
	@Test
	public void CampaignModule() throws IOException, InterruptedException
	{
		String campName = f.getExcelData("Campaign", 0, 0);
		HomePage h =new HomePage(driver);
		h.setCampn();
		CreateCampaignPage c = new CreateCampaignPage(driver);
		c.getNewCamp().click();
		c.getCampName().sendKeys(campName);
		WebElement type = c.getCampType();
		Select s = new Select(type);
		s.selectByValue("Conference");
		WebElement status = c.getCampStatus();
		Select s1 = new Select(status);
		s1.selectByValue("Inactive");
	}
}
