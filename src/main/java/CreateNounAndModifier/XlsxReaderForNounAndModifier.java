package CreateNounAndModifier;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XlsxReaderForNounAndModifier {
	
	private XSSFWorkbook workbook;
	private File file;
	private FileInputStream inputStream;
	private XSSFSheet sheet;
	private XSSFRow row;
	
	void readXlsx(String path) throws IOException {
		file = new File(path);
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
	}
	
	int getCount() {
		return sheet.getLastRowNum()+1;
	}
	
	String getNoun(int position) {
		row = sheet.getRow(position);
		return row.getCell(0).getStringCellValue();
	}
	
	String getPreviousNoun(int position) {
		row = sheet.getRow(position-1);
		return row.getCell(0).getStringCellValue();
	}
	
	String getModifier(int position) {
		row = sheet.getRow(position);
		return row.getCell(1).getStringCellValue();
	}
	
	boolean checkPreviousModifiers(int position) {
		for (int i=0; i!=NounAndModifierMain.position; i++) {
			row = sheet.getRow(i);
			String anotherModifier = row.getCell(1).getStringCellValue();
			if (anotherModifier == getModifier(position)) {
				return true;
			}
		}
		return false;
	}
}