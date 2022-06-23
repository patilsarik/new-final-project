package Utility;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametarization {

	
	public static String ExcelSheet(int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream file=new FileInputStream("E:\\Velocity\\Automation\\Kite\\src\\test\\resources\\testdata.xlsx");
	   String value=WorkbookFactory.create(file).getSheet("sarika1").getRow(row).getCell(cell).getStringCellValue();
	   return value; 
	  
	}
	
}
