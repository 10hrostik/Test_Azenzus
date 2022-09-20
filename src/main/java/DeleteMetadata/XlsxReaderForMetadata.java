package DeleteMetadata;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XlsxReaderForMetadata {

	static XSSFWorkbook workbook;
	static File file;
	static FileInputStream inputStream;
	static XSSFSheet sheet;
	static XSSFRow row;
	static FileOutputStream fileOut;
	
	void readXlsx(String path) throws IOException {
		file = new File(path);
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
	}
	
	int getCount() {
		return sheet.getLastRowNum()+1;
	}
	
	String getMetaId(int position) {
		row = sheet.getRow(position);
		try {
			return row.getCell(0).getStringCellValue();
		}
		catch (IllegalStateException e) {
			int  value = (int) row.getCell(0).getNumericCellValue();
			return Integer.toString(value);
		}
	}

	String getMetaName(int position) {
		row = sheet.getRow(position);
		return row.getCell(1).getStringCellValue();
	}

	public static void setResult(String result) throws IOException {
		row = sheet.getRow(DeleteMetaMain.position);
		row.createCell(3).setCellValue(result);
	}

	public static void saveResult(String path2) throws IOException {
		row = sheet.getRow(0);
		row.createCell(3).setCellValue("ID");

		fileOut = new FileOutputStream(path2);
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
	}
}