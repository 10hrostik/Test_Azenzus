package max.create.company;

import org.apache.poi.xssf.usermodel.*;
import java.io.*;

public class XlsxReaderForCompany {
	
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
	
	public static String getCompanyName() {
		row = sheet.getRow(CreateCompanyMain.position);
		String companyName = row.getCell(0).getStringCellValue();
		return companyName;
	}
	
	public static String getDescription() {
		row = sheet.getRow(CreateCompanyMain.position);
		String description = row.getCell(1).getStringCellValue();
		return description;
	}
	
	public static String getEmail() {
		row = sheet.getRow(CreateCompanyMain.position);
		String email = row.getCell(2).getStringCellValue();
		return email;
	}
	
	public static String getPhone() {
		row = sheet.getRow(CreateCompanyMain.position);
		String phone;
		try {
			phone = row.getCell(3).getStringCellValue();
		}
		catch (IllegalStateException e) {
			phone = String.valueOf(row.getCell(3).getNumericCellValue());
		}
		return phone;
	}
	
	public static String getHomePage() {
		row = sheet.getRow(CreateCompanyMain.position);
		String homePage = row.getCell(4).getStringCellValue();
		return homePage;
	}
	
	public static boolean ifValueExist(int column) {
		if(row.getCell(column).getRawValue()==null || row.getCell(column).getRawValue()=="" || row.getCell(column).getRawValue().isEmpty()) {
			return false;
		}
		else {
		    return true;
		}
	}
	
	public static String[] getAdress() {
		row = sheet.getRow(CreateCompanyMain.position);
		String adress[] = new String[6];
		adress[0] = row.getCell(5).getStringCellValue();
		adress[1] = row.getCell(6).getStringCellValue();
		adress[2] = row.getCell(7).getStringCellValue();
		adress[3] = row.getCell(8).getStringCellValue();
		adress[4] = row.getCell(9).getStringCellValue();
		adress[5] = row.getCell(10).getStringCellValue();
		return adress;
	}
	
	public static void setID(int id) throws IOException {
		row = sheet.getRow(CreateCompanyMain.position-1);
		row.createCell(11).setCellValue(id);
	}
	
	public static void setResult(String result) throws IOException {
		row = sheet.getRow(CreateCompanyMain.position-1);
		row.createCell(12).setCellValue(result);
	}
	
	public static void setException(String ex) throws IOException {
		row = sheet.getRow(CreateCompanyMain.position-1);
		row.createCell(13).setCellValue(ex);
	}
	
	public static void saveResult(String path2) throws IOException {
		row = sheet.getRow(0);
		row.createCell(11).setCellValue("ID");
		cellStyle(row.getCell(11));
		
		row.createCell(12).setCellValue("Comment");
		cellStyle(row.getCell(12));
		
		row.createCell(13).setCellValue("Exception");
		cellStyle(row.getCell(13));
		
		fileOut = new FileOutputStream(path2);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
	}
	
	public static void cellStyle(XSSFCell cell) {
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		style.setFont(font);
		//style.setAlignment(HorizontalAlignment.CENTER);
		//style.setVerticalAlignment(VerticalAlignment.CENTER);
		//sheet.addMergedRegion(CellRangeAddress.valueOf("T1:X1"));
		cell.setCellStyle(style);
	}
}