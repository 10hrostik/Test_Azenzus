package Import;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.OpenManager;
import general.StartAndLogin;

class ImportAll {
	
	public static WebDriver Az;
	public static int position=2;
	
	@Test
	public void company() throws InterruptedException, AWTException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver(); 
		/*
		MetaImportManager.metaImportManager(Az);
		MetaImportT.buttonAdd();
		MetaImportT.metaRobot("A:\\Aaa\\ImportFunctions.xlsx");
		MetaImportT.buttonImport();
		*/
		/*//wait
		if (MetaImport.importStatus()==false) {
			System.out.println("File for Meta import is incorrect");
		}
		*/
		OpenManager.dymanicImportManager(Az);
		DymanicImportT.dataType("STRUCTURE_RECORD_CHANGES");
		DymanicImportT.objectType("ASPECT_FUNCTION");
		DymanicImportT.selctMetadata("Test A2");
		DymanicImportT.chooseFile("A:\\Aaa\\ImportFunctions.xlsx");
		DymanicImportT.buttonPrepare();
		DymanicImportT.primaryKey();
		DymanicImportT.dragAndDropID();
		DymanicImportT.dragAndDropTag();
		DymanicImportT.dragAndDropDesc();
		DymanicImportT.dragAndDropPath();
		DymanicImportT.dragAndDropPlant();
		//dragAndDropProperties
		DymanicImportT.buttonImport();
		//wait
	}
}

class DymanicImportT {
	private static WebDriver Az = ImportAll.Az;
	
	public static void dataType(String dataType) {
		WebElement comboboxDataType = Az.findElement(By.xpath("//label[text()='Data type']/ancestor::td/following-sibling::td//div[@class='selectItemText']"));
		comboboxDataType.click();	
		WebElement optionForDataType = Az.findElement(By.xpath("//div[text()='"+dataType+"']"));
		optionForDataType.click();
	}
	
	public static void objectType(String objectType) {
		WebElement comboboxObjectType = Az.findElement(By.xpath("//label[text()='Object type']/ancestor::td/following-sibling::td//div[@class='selectItemText']"));
		comboboxObjectType.click();	
		WebElement optionForObjectType = Az.findElement(By.xpath("//div[text()='"+objectType+"']"));
		optionForObjectType.click();
	}
	
	public static void selctMetadata(String metaName) throws InterruptedException {
		Thread.sleep(500);
		WebElement buttonSelectMeta = Az.findElement(By.xpath("//label[text()='Metadata']/ancestor::td/following-sibling::td//td[@class='formCell']//td[2]"));
		buttonSelectMeta.click();
		Thread.sleep(1000);
		WebElement searchFiled = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		searchFiled.clear();
		searchFiled.sendKeys(metaName);
		WebElement buttonSearch = Az.findElement(By.xpath("//td[@class='buttonTitle']/div[contains(text(),'Search')]"));
		buttonSearch.click();
		Thread.sleep(1000);
		var doubleClickOnMeta = new Actions(Az);
		WebElement meta = Az.findElement(By.xpath("//div[text()='"+metaName+"']"));
		doubleClickOnMeta.doubleClick(meta).perform();
	}
	
	public static void chooseFile(String path) throws InterruptedException {
		Thread.sleep(500);
    	WebElement inputFileName = Az.findElement(By.xpath("//input[@name='filename']"));
		inputFileName.sendKeys(path);
		Thread.sleep(500);
	}
	
	public static void buttonPrepare() throws InterruptedException {
		WebElement buttonPrepare = Az.findElement(By.xpath("//div[text()='Prepare']"));
		buttonPrepare.click();
		Thread.sleep(3000);
	}
	
	public static void primaryKey() throws InterruptedException {
		Thread.sleep(3000);
		WebElement primary = Az.findElement(By.xpath("//div[text()='Primary']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[1]/td[2]/div"));
		primary.click();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropID() throws InterruptedException {
		var dragAndDropID = new Actions(Az);
		WebElement propertyID = Az.findElement(By.xpath("//div[text()='ID']"));
		WebElement columnID = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[1]"));
		dragAndDropID.dragAndDrop(propertyID,columnID).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropTag() throws InterruptedException {
		var dragAndDropTag = new Actions(Az);
		WebElement propertyTag = Az.findElement(By.xpath("//div[text()='RDC_TAG']"));
		WebElement columnTag = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[2]"));
		dragAndDropTag.dragAndDrop(propertyTag,columnTag).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropDesc() throws InterruptedException {
		var dragAndDropDesc = new Actions(Az);
		WebElement propertyDesc = Az.findElement(By.xpath("//div[text()='DESCRIPTION']"));
		WebElement columnDesc = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[3]"));
		dragAndDropDesc.dragAndDrop(propertyDesc,columnDesc).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropPath() throws InterruptedException {
		var dragAndDropPath = new Actions(Az);
		WebElement propertyPath = Az.findElement(By.xpath("//div[text()='PATH']"));
		WebElement columnPath = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[4]"));
		dragAndDropPath.dragAndDrop(propertyPath,columnPath).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropPlant() throws InterruptedException {
		var dragAndDropPlant = new Actions(Az);
		WebElement propertyPath = Az.findElement(By.xpath("//div[text()='PLANT_ID']"));
		WebElement columnPath = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[5]"));
		dragAndDropPlant.dragAndDrop(propertyPath,columnPath).build().perform();
		Thread.sleep(1000);
	}
	
	public static void buttonImport() {
		WebElement buttonImport = Az.findElement(By.xpath("//td[text()='Import Manager']/ancestor::div[@class='windowHeader']/parent::div//div[text()='Import']"));
		buttonImport.click();
	}
}

class MetaImportT{
	private static WebDriver Az = ImportAll.Az;
	
	public static void buttonAdd() {
		WebElement buttonAddFile = Az.findElement(By.xpath("//div[text()='Add file']"));
		buttonAddFile.click();
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
	}
	
	public static void buttonImport() throws InterruptedException {
		Thread.sleep(1000);
		WebElement buttonImport = Az.findElement(By.xpath("//div[text()='Import']"));
		buttonImport.click();
	}
	
	public static boolean importStatus() throws InterruptedException {
		Thread.sleep(2000);
		boolean status = false;
		do {
			try {
        		Az.findElement(By.xpath("//font[text()='Done']"));
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
    				
    			}
        	}
			Thread.sleep(2000);
		}
		while(status!=true);
		return status;
	}
}