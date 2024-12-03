package com.adiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage 
{
	@FindBy(xpath="//input[@value='New Campaign']")
	private WebElement NewCampBtn;
	@FindBy(xpath="//input[@name='property(Campaign Name)']")
	private WebElement CampNameTbx;
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement SaveBtn;
	@FindBy(name="property(Status)")
	private WebElement StatusListBox;
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getNewCamp() {
		return NewCampBtn;
	}
	public WebElement getCampName() {
		return CampNameTbx;
	}
	public WebElement getSave() {
		return SaveBtn;
	}
	public WebElement getStatus() {
		return StatusListBox;
	}

}
