package genericUtilities;
import java.io.*;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods to use Excel file
 * @author RameshKumarMalkari
 * 
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel file and return the value to the caller
	 * @param sheetname
	 * @param rowNo
	 * @param celno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetname,int rowNo,int celno ) throws EncryptedDocumentException,IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis); 
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(celno).getStringCellValue();
		return value;
	}

}
