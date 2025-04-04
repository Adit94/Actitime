package com.adiv.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.pages.CampaignListPage;
import com.adiv.pages.CreateCampaignPage;
import com.adiv.pages.HomePage;

@Listeners(com.adiv.generic.ListenerImplementation.class)

public class Endtoend extends BaseClass
{
	@Test
	public void Endtoend() throws InterruptedException, IOException 
	{
		HomePage h =new HomePage(driver);
		Thread.sleep(2000);
		h.verifyTitle(driver, "Zoho CRM - Home Page");
		h.setCampn();
		h.verifyTitle(driver, "Zoho CRM - Displaying Custom View Details");

		CampaignListPage cl = new CampaignListPage(driver);
		cl.setNewCampn();
		Thread.sleep(2000);
		cl.verifyTitle(driver, "Zoho CRM - Create Campaign");
		
		String campName = f.getExcelData("CRM.xlsx","Campaign", 1, 4);
		CreateCampaignPage cc = new CreateCampaignPage(driver);
		cc.getCampName().sendKeys(campName);
		
		WebElement type = cc.getCampType();
		Select s = new Select(type);
		s.selectByValue("Conference");
		
		WebElement status = cc.getCampStatus();
		Select s1 = new Select(status);
		s1.selectByIndex(3);
		Thread.sleep(3000);
		
		
	}
}
