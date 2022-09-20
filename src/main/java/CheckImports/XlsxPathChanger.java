package CheckImports;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlsxPathChanger {
	
	XSSFWorkbook workbook;
	File file;
	FileInputStream inputStream;
	XSSFSheet sheet;
	XSSFRow row;
	
	void updateXlsx(String id, String path) throws IOException {
		file = new File(path);
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
		
		changePath(id, path);
		System.out.println("Import file updated");
	}
	
	void changePath(String id, String path) throws IOException {
		int i = 1;
		do {
			int len = id.length()-1;
			row = sheet.getRow(i);
			String pathToAspect = row.getCell(3).getStringCellValue();
			pathToAspect = pathToAspect.replaceAll("==\\|\\d{"+len+"}", "==\\|"+id);
			pathToAspect = pathToAspect.replaceAll(" \\|","\\|");
			var cell = row.getCell(3);
			cell.setCellValue(pathToAspect);
			i++;
		}
		while(i<getCount());
		saveUpdatedFile(path);
	}
	
	private int getCount() {
		int rowCount = sheet.getLastRowNum()+1;
		return rowCount;
	}
	
	private void saveUpdatedFile(String path) throws IOException {
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        workbook.close();
        fileOut.close();
	}
}