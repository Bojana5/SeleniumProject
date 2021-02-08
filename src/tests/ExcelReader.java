package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class ExcelReader {
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String value;
	
	public ExcelReader(String filePath) throws IOException {
		this.file = new File(filePath);
		this.fis = new FileInputStream(file);
		this.wb = new XSSFWorkbook(fis);
	}
	
	public String getData(String sheetName, int rowNumber, int columnNumber) {
		sheet = wb.getSheet(sheetName);
		row = sheet.getRow(rowNumber-1);
		cell = row.getCell(columnNumber-1);
		if (cell.getCellType() == CellType.NUMERIC) { 
			value = String.valueOf((int)cell.getNumericCellValue());
		} else {
			value = cell.getStringCellValue();
		}
		return value;
	}
	
	public void assertText(String sheetName, int columne, int row, String textFromSite) {
		String textFromTable = getData(sheetName, columne, row); 
		Assert.assertEquals(textFromTable, textFromSite);
		System.out.println("Successful assertion.");
		
		//test
		//excelReader.assertion("sheetname", 2-col, 1-row, page.getText...().getText());
	}
	
}
