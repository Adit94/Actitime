package com.adiv.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

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

	public String getExcelData(String fileName, String sheetName, int rowNumber, int cellNumber) throws IOException
	{
		final String BASE_PATH = "./data/";

		FileInputStream fis = null;
		Workbook workbook = null;
		String cellValue = "";

		try {
			File file = new File(BASE_PATH + fileName);
			if (!file.exists()) {
				throw new IOException("File " + fileName + " not found at " + BASE_PATH);
			}

			fis = new FileInputStream(file);
			workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				throw new IOException("Sheet " + sheetName + " not found in " + fileName);
			}

			Row row = sheet.getRow(rowNumber);
			if (row == null) {
				throw new IOException("Row " + rowNumber + " not found in sheet " + sheetName);
			}

			Cell cell = row.getCell(cellNumber);
			if (cell == null) {
				throw new IOException("Cell " + cellNumber + " not found in row " + rowNumber);
			}

			// Handle different cell types
			switch (cell.getCellType()) {
			case STRING:
				cellValue = cell.getStringCellValue().trim();
				break;
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					cellValue = sdf.format(cell.getDateCellValue());
				} else {
					cellValue = String.valueOf((int) cell.getNumericCellValue());
				}
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			case FORMULA:
				cellValue = cell.getCellFormula();
				break;
			case BLANK:
				cellValue = "";
				break;
			default:
				throw new IOException("Unsupported cell type at row " + rowNumber + ", cell " + cellNumber);
			}

		} catch (IOException e) {
			System.err.println("Error reading Excel data from " + fileName + ": " + e.getMessage());
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				System.err.println("Error closing Excel file " + fileName + ": " + e.getMessage());
			}
		}
		return cellValue;
	}


public int getTotalRows(String sheetName) throws IOException 
{
	FileInputStream fis = new FileInputStream("./data/adiv_shutzling__software_FTC.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	int totalRows = sheet.getLastRowNum();
	wb.close();
	return totalRows;
}
}