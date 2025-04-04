package com.adiv.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.adiv.pages.HomePage;
import com.adiv.pages.LoginPage;


public class BaseClass {
	public static WebDriver driver;
	protected FileUtils f = new FileUtils();


	@BeforeTest
	public void openBrowser() throws IOException, InterruptedException
	{
		Reporter.log("openBrowser",true);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.getPropertyData("url");
		driver.get(url);
		
	}


	@BeforeMethod
	public void login() throws IOException, InterruptedException 
	{
		String un = f.getPropertyData("username");
		String pwd = f.getPropertyData("password");
		LoginPage l = new LoginPage(driver);
		l.Login(un,pwd);
		Thread.sleep(5000);


	}

	@AfterMethod
	public void logout() 
	{
		HomePage h = new HomePage(driver);
		
	}

	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
}


