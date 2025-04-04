package com.adiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage 
{
	@FindBy(xpath="//input[@name='property(Vendor Name)']")
	private WebElement VenNameTxtfld;
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement SaveBtn;

	public CreateVendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void clickNameFld()
	{
		VenNameTxtfld.click();
	}
	
	public WebElement getVendorNameField() 
	{
        return VenNameTxtfld;
    }
	
	public void enterVendorName(String vendorName) 
	{
		VenNameTxtfld.clear();
		VenNameTxtfld.sendKeys(vendorName);
    }
	
	public String getVendorNameValue() 
	{
        return VenNameTxtfld.getAttribute("value");
    }
	
	public void clickSaveButton() 
	{
		SaveBtn.click();
    }
}
