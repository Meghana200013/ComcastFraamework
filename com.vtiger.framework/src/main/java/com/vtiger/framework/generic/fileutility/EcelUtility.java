package com.vtiger.framework.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class EcelUtility {
	
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\TestData\\TestscripDtata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowNum);
		String data =r.getCell(cellNum).getStringCellValue().toString();
		return data;
		
	}
	
	public int getRowCountFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\TestData\\TestscripDtata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		return rowcount;
	}
	
	public void setDataToExcel(String sheetName,int rowNum,int cellNum,String value) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\TestData\\TestscripDtata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(".\\TestData\\TestscripDtata.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	
	

}
