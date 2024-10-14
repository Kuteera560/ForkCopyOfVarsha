package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream efis= new FileInputStream("./configAppData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream efis= new FileInputStream("./configAppData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		FileOutputStream fos= new FileOutputStream("./configAppData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream efis= new FileInputStream("./configAppData/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(efis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	
	
	
}
