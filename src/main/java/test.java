import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class test {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("Java Books");
	        
		String st = "some value from clinet, this is new val, new val, some toher";
		String[] arr = st.split(",");
		
		ArrayList<String> list = new ArrayList<>(); // works fine 
		for (String string : arr) 			
			list.add(string);
		 
		int rowCount = 0;
		for (String aBook : list) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
            
            
            
            Cell cell = row.createCell(++columnCount);
                    cell.setCellValue(aBook);
                    cell.setCellValue(aBook);
            
             
        }
		
		 try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Paapi Papita\\Desktop\\JavaBooks.xlsx")) {
	            workbook.write(outputStream);
	        }
		 System.out.println("hi");
	}

}
