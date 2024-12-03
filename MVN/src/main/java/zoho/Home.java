package zoho;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Home 
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
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//input[@value='New Campaign']")).click();
		driver.findElement(By.xpath("//input[@name='property(Campaign Name)']")).sendKeys("LG Refrigerator");
		WebElement st = driver.findElement(By.name("property(Type)"));
		Select s1 = new Select(st);
		s1.selectByValue("Conference");
		WebElement t = driver.findElement(By.name("property(Status)"));
		Select s = new Select(t);
		s.selectByValue("Inactive");
		driver.findElement(By.xpath("//input[@name='property(Start Date)']")).sendKeys("08/02/2024");
		driver.findElement(By.xpath("//input[@name='property(End Date)']")).sendKeys("08/05/2024");
		driver.findElement(By.xpath("//input[@name='property(Expected Revenue)']")).sendKeys("7277200");
		driver.findElement(By.xpath("//input[@name='property(Budgeted Cost)']")).sendKeys("30000");
		driver.findElement(By.xpath("//input[@name='property(Actual Cost)']")).sendKeys("25990");
		driver.findElement(By.xpath("//input[@name='property(Expected Response)']")).sendKeys("200");
		driver.findElement(By.xpath("//input[@name='property(Num sent)']")).sendKeys("280");
		driver.findElement(By.xpath("(//input[@value='Save'])[2]")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//input[@value='New Lead']")).click();
		//driver.findElement(By.xpath("//img[@title='Calendar']")).click();
		/*Set<String>allwid = driver.getWindowHandles();
				String std = driver.getWindowHandle();
				for(String wid:allwid)
				{
					driver.switchTo().window(wid);
				}*/
	}

}
