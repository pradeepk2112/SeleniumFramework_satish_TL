package reporting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReporter {
	
	@Test
	public void writeExcel() throws IOException{
		
		XSSFWorkbook wbook=new XSSFWorkbook();
		XSSFSheet sheet=wbook.createSheet();
		XSSFRow header= sheet.createRow(0);
		header.createCell(0).setCellValue("Sl.NO");
		header.createCell(0).setCellValue("Test Desc");
		header.createCell(0).setCellValue("Status");
		header.createCell(0).setCellValue("Snapsot");
		
		FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx");
		wbook.write(outputStream);
		wbook.close();
		
		
	}
	

}
