package com.adiv.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtils 
{
	
	public String getPropertyData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
	}

	public String getExcelData(String sheet, int row, int cell) throws IOException
	{
		FileInputStream fis = new FileInputStream("./data/CRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return data;	
	}

	public static Object[][] getTestData() throws IOException 
	{
		FileInputStream fis = new FileInputStream("./data/CRM.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		int num = s.getLastRowNum();
		int cell = s.getRow(0).getLastCellNum();
		Object[][] data = new Object[num - 1][cell];
		for (int i = 0; i <= num; i++) 
		{
			for (int j = 0; j <= cell; j++) 
			{
				data[i - 1][j] = s.getRow(i).getCell(j).toString();
			}
		}
		return data;
	}
}
