package com.adiv.testscript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.adiv.generic.BaseClass;
import com.adiv.pages.LoginPage;

@Listeners(com.adiv.generic.ListenerImplementation.class)

public class LoginModule extends BaseClass
{
	@Test
	public void LoginModule() throws IOException, InterruptedException  
	{
		//LoginPage l = new LoginPage(driver);
        
	}
}