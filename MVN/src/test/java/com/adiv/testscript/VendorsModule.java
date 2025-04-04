package com.adiv.testscript;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.adiv.generic.BaseClass;
import com.adiv.generic.FileUtils;
import com.adiv.pages.CreateVendorPage;
import com.adiv.pages.VendorListPage;

@Listeners(com.adiv.generic.ListenerImplementation.class)
public class VendorsModule extends BaseClass
{
	@Test
	public void VendorsModule() throws InterruptedException, IOException
	{

		VendorListPage vl = new VendorListPage(driver);
		vl.clickScroll(10);
		vl.VendorsTab().click();
		vl.verifyTitle(driver, "Zoho CRM - Displaying Custom View Details");
		vl.NewVendorBtn().click();
		vl.verifyTitle(driver, "Zoho CRM - Create Vendor");

		FileInputStream fis = new FileInputStream("./data/adiv_shutzling__software_FTC.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Vendors");

		int rowCount = s.getPhysicalNumberOfRows();
		FileUtils f = new FileUtils();
		
		for (int i = 0; i <rowCount; i++) 
		{ 
			String input = f.getExcelData("adiv_shutzling__software_FTC.xlsx","Vendors", i, 0);
			if (input.trim().isEmpty()) 
			{
				System.out.println("Blank input detected. Skipping.");
				continue;
			}

			CreateVendorPage cv = new CreateVendorPage(driver);
			cv.enterVendorName(input);
			String expected_result = f.getExcelData("adiv_shutzling__software_FTC.xlsx","Vendors", i, 0);
			if (expected_result.equals(input)) 
			{
				Assert.assertEquals(cv.getVendorNameValue(), input, "It should accept.");
			} 
			else 
			{
				Assert.assertNotEquals(cv.getVendorNameValue(), input, "It should reject.");
			}
		}
		wb.close();
	}
}
