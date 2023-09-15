package ExcelSheetDriven;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream("E:\\Excel.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		int sheets = workbook.getNumberOfSheets();
		
		for(int i=0;i<sheets;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
			
		  XSSFSheet sheet = workbook.getSheetAt(i);
		  
		  
		 java.util.Iterator<Row> rows = sheet.iterator();
		 
		 Row firstrow = rows.next();
		 
		 Iterator ce = (Iterator) firstrow.cellIterator();
		 
		 Row firstRow = rows.next();
			
			}}
		
		
		
	}

}
