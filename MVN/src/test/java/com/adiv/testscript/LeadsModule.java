package com.adiv.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeadsModule 
{
	public static void main(String[] args) 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.44.128:8080");
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@title='Sign In']")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//input[@value='New Lead']")).click();
		driver.findElement(By.xpath("//input[@name='property(First Name)']")).sendKeys("Aditya");
		driver.findElement(By.xpath("//input[@ name='property(Company)']")).sendKeys("QSPIDERS");
		driver.findElement(By.xpath("//input[@name='property(Last Name)']")).sendKeys("Arun");
		WebElement ls = driver.findElement(By.name("property(Lead Status)"));
		Select s1 = new Select(ls);
		s1.selectByValue("Junk Lead");
		s1.selectByValue("Lost Lead");
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();

		
	}
}