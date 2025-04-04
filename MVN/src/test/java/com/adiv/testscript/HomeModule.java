package com.adiv.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.pages.HomePage;
import com.adiv.pages.LoginPage;

@Listeners(com.adiv.generic.ListenerImplementation.class)

public class HomeModule extends BaseClass
{
	@Test
	public void HomeModule() throws InterruptedException 
	{

		HomePage h =new HomePage(driver);
		Thread.sleep(2000);
		h.verifyTitle(driver, "Zoho CRM - Home Page");
		
	}
}
