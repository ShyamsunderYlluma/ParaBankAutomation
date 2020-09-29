package com.parabank.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static FileInputStream excelFile;
	private static String filePath;
	public static int rCount;
	
	//This method is used to set the File path and to open the Excel file
	public static void setExcelFile(String sheetName) throws Exception {		
		try {
			String workingDir = System.getProperty("user.dir");
			filePath = workingDir+File.separator+"src"+File.separator+"spicejetTestdata.xlsx";
			excelFile = new FileInputStream(filePath);
            ExcelWBook = new XSSFWorkbook(excelFile);
		    ExcelWSheet = ExcelWBook.getSheet(sheetName);
		    rCount = ExcelWSheet.getLastRowNum();
		} catch (Exception e){
			e.printStackTrace();
		}
}

//This method is used to read the test data from the Excel cell, in this we are passing parameters as Row number and Column number and return the cell value

	public static String getCellData(int RowNum, int ColNum) throws Exception{
		return ExcelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
}
}
