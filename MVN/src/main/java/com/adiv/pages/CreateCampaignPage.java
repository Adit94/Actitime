package com.adiv.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath="//option[@value='Inactive']")
	private WebElement Status;
	@FindBy(xpath="//input[@name='property(Start Date)']")
	private WebElement StartDt;
	@FindBy(xpath="//input[@name='property(End Date)']")
	private WebElement EndDt;
	@FindBy(xpath="//input[@name='property(Expected Revenue)']")
	private WebElement ExptRev;
	@FindBy(xpath="//input[@name='property(Budgeted Cost)']")
	private WebElement BdgdCst;
	@FindBy(xpath="//input[@name='property(Actual Cost)']")
	private WebElement ActCst;
	@FindBy(xpath="//input[@name='property(Expected Response)']")
	private WebElement ExptRes;
	@FindBy(xpath="//input[@name='property(Num sent)']")
	private WebElement Num;
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
	public WebElement getStatusList() {
		return StatusListBox;
	}
	public WebElement getStatus() {
		return Status;
	}
	public WebElement getStartDate() {
		return StartDt;
	}
	public WebElement getEndDate() {
		return EndDt;
	}
	public WebElement ExpectedRevenue() {
		return ExptRev;
	}
	public WebElement BudgetedCost() {
		return BdgdCst;
	}
	public WebElement ActualCost() {
		return ActCst;
	}
	public WebElement ExpectedResponse() {
		return ExptRes;
	}
	public WebElement NumSent() {
		return Num;
	}
}
	

