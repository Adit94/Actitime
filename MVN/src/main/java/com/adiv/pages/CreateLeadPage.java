package com.adiv.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadPage 
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
		driver.findElement(By.xpath("//input[@name='property(Company)']")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@name='property(First Name)']")).sendKeys("Vignesh");
		driver.findElement(By.xpath("//input[@name='property(Last Name)']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@name='property(Designation)']")).sendKeys("Network Engineer");
		driver.findElement(By.xpath("//input[@name='property(Email)']")).sendKeys("vigneshtth7@gmail.com");
		driver.findElement(By.xpath("//input[@name='property(Mobile)']")).sendKeys("8884090450");
		/*driver.findElement(By.xpath("//input[@name='property(Fax)']")).sendKeys("LG Refrigerator");
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("LG Refrigerator");
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("LG Refrigerator");
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("LG Refrigerator");*/

	}

}
