package com.adiv.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.adiv.generic.BaseClass;



public class ListenerImplementation extends BaseClass implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) 
	{

	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String res = result.getName();
		Reporter.log(res+" has been passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		WebDriver driver = new ChromeDriver();
		String res = result.getName();
		TakesScreenshot t = (TakesScreenshot)driver;
		File scr = t.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/" +res + ".png");
		try
		{
			FileUtils.copyFile(scr, dest);
		}
		catch(IOException e)
		{

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String res = result.getName();
		Reporter.log(res+" has been skiped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	@Override
	public void onStart(ITestContext context) 
	{

	}

	@Override
	public void onFinish(ITestContext context) 
	{

	}

}