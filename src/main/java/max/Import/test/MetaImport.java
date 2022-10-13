package max.Import.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MetaImport {
    private static WebDriver Az = ImportAllTest.Az;
	
	public static void buttonAdd() throws InterruptedException {
		var buttonAddFile = Az.findElement(By.xpath("//div[contains(@eventproxy,'isc_ImportMetaWindow')][@role='dialog'][last()]//div[text()='Add file']"));
		buttonAddFile.click();
		Thread.sleep(2000);
	}
	
	public static void metaRobot(String path) throws InterruptedException, AWTException {
		StringSelection selectMetaFile = new StringSelection(path);
		Robot robot = new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectMetaFile, null);
		
	    robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(1000);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(1000);

	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1000);
	}
	
	public static void buttonImport() throws InterruptedException {
		Thread.sleep(1000);
		WebElement buttonImport = Az.findElement(By.xpath("//div[contains(@eventproxy,'isc_ImportMetaWindow')][@role='dialog'][last()]//div[text()='Import']"));
		buttonImport.click();
	}
	
	public static boolean importStatus() throws InterruptedException {
		Thread.sleep(2000);
		boolean status = false;
		do {
			try {
        		Az.findElement(By.xpath("//b[text()='Done']"));
        	    status = true;
        	    break;
        	} 
        	catch (NoSuchElementException e) {
        		try {
        			Az.findElement(By.xpath("//font[text()='Error']"));
            	    status = false;
            	    break;
        		}
        		catch (NoSuchElementException s) {
        			//status = false;
    			}
        	}
			Thread.sleep(2000);
		}
		while(status!=true);
		return status;
	}
	
	public static void buttonClose() throws InterruptedException {
		Thread.sleep(1000);
		var buttonClose = Az.findElement(By.xpath("//div[contains(@eventproxy,'isc_ImportMetaWindow')][@role='dialog'][last()]//img[contains(@src,'close.png')]"));
		buttonClose.click();
	}
}

class UdateMetaImportFile {
	
	static XSSFWorkbook workbook;
	static File file;
	static FileInputStream inputStream;
	static XSSFSheet sheet;
	static XSSFRow row;
	
    public static void updateFile (String path, String meta, String kbObjectType) throws InterruptedException, IOException {
    	file = new File(path);
		inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(0);
		changeName(meta);
		changeObjectType(kbObjectType);
		System.out.println("Meta import file updated");
		
		inputStream.close();
		FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        workbook.close();
        fileOut.close();
        Thread.sleep(1000);        
	}
    
    public static void changeName (String meta) {
    	row = sheet.getRow(1);
		var cell = row.getCell(2);
		cell.setCellValue(meta);
    }
    
    public static void changeObjectType (String kbObjectType) {
    	row = sheet.getRow(1);
		var cell = row.getCell(10);
		cell.setCellValue(kbObjectType);
    }
}