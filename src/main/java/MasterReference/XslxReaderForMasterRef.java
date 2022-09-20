package MasterReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XslxReaderForMasterRef {
	static XSSFWorkbook workbook;
	static File file;
	static FileInputStream inputStream;
	static XSSFSheet sheet;
	static XSSFRow row;
	static FileOutputStream fileOut;
	
	public void readXlsx(String path) throws IOException {
		file = new File(path);
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
	}
	
	public static int getCount() {
		int rowCount = sheet.getLastRowNum() +1;
		return rowCount;
	}
	
	public static String getMasterID() {
		row = sheet.getRow(MasterReferenceMain.position);
		try {
			return row.getCell(0).getStringCellValue();
		}
		catch (Exception e) {
			return String.valueOf(row.getCell(0).getNumericCellValue());
		}
	}
	
	public static String getMetaName() {
		row = sheet.getRow(MasterReferenceMain.position);
		return row.getCell(1).getStringCellValue();
	}
	
	public static String getCode() {
		row = sheet.getRow(MasterReferenceMain.position);
		try {
			return row.getCell(2).getStringCellValue();
		}
		catch (Exception e) {
			return String.valueOf(row.getCell(2).getNumericCellValue());
		}
	}
	
	public static String getValueNewOrExisted() {
		row = sheet.getRow(MasterReferenceMain.position);		
		return row.getCell(3).getStringCellValue();
	}
	
	public static String getIdOfExistedMaster() {
		row = sheet.getRow(MasterReferenceMain.position);
		String masterID;
		try {
			masterID = row.getCell(4).getStringCellValue();
		}
		catch (Exception e) {
			masterID = String.valueOf(row.getCell(4).getNumericCellValue());
		}
		return masterID;
	}
	
	public static String getNewMasterName() {
		return row.getCell(5).getStringCellValue();
	}
	
	public static String getNewMasterDesc() {
		return row.getCell(6).getStringCellValue();
	}
	
	public static Boolean getNewReleased() {
		try {
			return row.getCell(7).getBooleanCellValue();
		}
		catch (Exception e) {
			return Boolean.getBoolean(row.getCell(7).getStringCellValue());
		}
	}
	
	public static String getNewManufacturer() {
		String s = row.getCell(8).getStringCellValue();
		//System.out.println("S: "+s);
		return s;
	}
	
	public static Boolean getNewCatalogue() {
		try {
			return row.getCell(9).getBooleanCellValue();
		}
		catch (Exception e) {
			return Boolean.getBoolean(row.getCell(9).getStringCellValue());
		}
	}
	
	public static void addColumns() {
		sheet.getRow(0).createCell(11).setCellValue("Comment");
		sheet.getRow(0).createCell(12).setCellValue("Exception");
	}
	
	public static void setResult(String result) throws IOException {
		row = sheet.getRow(MasterReferenceMain.position);
		row.createCell(11).setCellValue(result);
	}
	
	public static void setException(String ex) throws IOException {
		row = sheet.getRow(MasterReferenceMain.position);
		try {
			String oldEx = row.getCell(12).getStringCellValue();
			row.createCell(12).setCellValue(oldEx+"  |  "+ex);
		}
		catch (Exception e) {
			row.createCell(12).setCellValue(ex);
		}
	}
	
	public static void saveResult(String path2) throws IOException {
		addColumns();
		fileOut = new FileOutputStream(path2);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
	}
}