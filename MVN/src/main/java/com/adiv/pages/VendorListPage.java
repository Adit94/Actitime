package com.adiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VendorListPage 
{
	@FindBy(id="scrollright")
	private WebElement ScrlBtn;
	@FindBy(linkText="Vendors")
	private WebElement VendorsTb;
	@FindBy(xpath="//input[@value='New Vendor']")
	private WebElement NewVendorBtn;

	public void verifyTitle(WebDriver driver, String exp_title)
	{	
		String act_title = driver.getTitle();
		Assert.assertEquals(act_title, exp_title,"Title does not match");
	}

	public VendorListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement scroll()
	{
		return ScrlBtn;
	}
	
	public WebElement VendorsTab()
	{
		return VendorsTb;
	}
	
	public WebElement NewVendorBtn()
	{
		return NewVendorBtn;
	}
	
	public void clickScroll(int numberOfClicks) 
	{
	    for (int i = 0; i < numberOfClicks; i++) 
	    {
	    	ScrlBtn.click();
	    }
	}
	 
}
