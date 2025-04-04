package com.adiv.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.generic.FileUtils;
import com.adiv.pages.CampaignDetailsPage;
import com.adiv.pages.CampaignListPage;
import com.adiv.pages.CreateCampaignPage;
import com.adiv.pages.HomePage;
import com.adiv.pages.LoginPage;

@Listeners(com.adiv.generic.ListenerImplementation.class)
public class CampaignsModule extends BaseClass
{
	@Test
	public void CampaignModule() throws IOException, InterruptedException
	{
		FileUtils f = new FileUtils();
		HomePage h =new HomePage(driver);
		h.setCampn();
		h.verifyTitle(driver, "Zoho CRM - Displaying Custom View Details");

		CampaignListPage cl = new CampaignListPage(driver);
		cl.setNewCampn();
		cl.verifyTitle(driver, "Zoho CRM - Create Campaign");	
		String campName = f.getExcelData("CRM.xlsx","Campaign", 1, 4);
		CreateCampaignPage cc = new CreateCampaignPage(driver);
		cc.getCampName().sendKeys(campName);
		
		WebElement type = cc.getCampType();
		Select s = new Select(type);
		s.selectByValue("Conference");
		
		WebElement status = cc.getCampStatus();
		Select s1 = new Select(status);
		s1.selectByIndex(4);
		
		String stdt = f.getExcelData("CRM.xlsx","Campaign", 2, 4);
		cc.getStartDate().sendKeys(stdt);
		String eddt = f.getExcelData("CRM.xlsx","Campaign", 3, 4);
		cc.getEndDate().sendKeys(eddt);
		String exrn = f.getExcelData("CRM.xlsx","Campaign", 4, 4);
		cc.ExpectedRevenue().sendKeys(exrn);
		String bud_cost = f.getExcelData("CRM.xlsx","Campaign", 5, 4);
		cc.BudgetedCost().sendKeys(bud_cost);
		String act_cost = f.getExcelData("CRM.xlsx","Campaign", 6, 4);
		cc.ActualCost().sendKeys(act_cost);
		String exprpn = f.getExcelData("CRM.xlsx","Campaign", 7, 4);
		cc.ExpectedResponse().sendKeys(exprpn);
		String n_s = f.getExcelData("CRM.xlsx","Campaign", 8, 4);
		cc.NumSent().sendKeys(n_s);
		cc.getSave().click();
		
		CampaignDetailsPage cd = new CampaignDetailsPage(driver);
		cd.verifyTitle(driver, "Zoho CRM - Campaign Details");
		Thread.sleep(3000);
		

	}
}
