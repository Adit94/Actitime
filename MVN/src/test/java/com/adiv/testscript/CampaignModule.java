package com.adiv.testscript;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.pages.CreateCampaignPage;
import com.adiv.pages.HomePage;
@Listeners(com.adiv.generic.ListenerImplementation.class)
public class CampaignModule extends BaseClass
{
	@Test
	public void createCampaign() throws InterruptedException, IOException
	{
		String customerName = f.getExcelData("Campaign",0,0);
		
		
		/*String EndDate = f.getExcelData("Campaign",0,0);
		String ExpectedRevenue = f.getExcelData("Campaign",0,0);
		String BudgetedCost = f.getExcelData("Campaign",0,0);
		String ActualCost = f.getExcelData("Campaign",0,0);
		String ExpectedResponse = f.getExcelData("Campaign",0,0);
		String NumSent = f.getExcelData("Campaign",0,0);*/

		

		HomePage h = new HomePage(driver);
		h.setCampn();
		
		CreateCampaignPage c = new CreateCampaignPage(driver);
		c.getNewCamp().click();
		c.getCampName().sendKeys(customerName);
		c.getStatusList().click();
		c.getStatus().click();
		System.out.println(c.getStatus().getText());
		
		
		
		//c.getSave().click();
	}
	
	 
}
