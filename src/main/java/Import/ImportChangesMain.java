package Import;

import java.awt.AWTException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.OpenManager;
import general.StartAndLogin;

class ImportChangesMain {
	
	public static WebDriver Az;
	public static int position=2;
	
	@Test
	public void company() throws InterruptedException, AWTException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();

		OpenManager.dymanicImportManager(Az);
		DymanicImportChanges.dataType("STRUCTURE_RECORD_CHANGES");
		DymanicImportChanges.objectType("ASPECT_FUNCTION");
		DymanicImportChanges.chooseFile("A:\\Aaa\\STRUCTURE_RECORD_CHANGES.xlsx");
		DymanicImportChanges.buttonPrepare();
		DymanicImportChanges.dragAndDrop1();
		DymanicImportChanges.dragAndDrop2();
		DymanicImportChanges.dragAndDrop3();
		DymanicImportChanges.dragAndDrop4();
		DymanicImportChanges.buttonImport();
	}
}

class DymanicImportChanges {
	private static WebDriver Az = ImportChangesMain.Az;
	
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
	
	public static void dragAndDrop1() throws InterruptedException {
		Actions dragAndDropID = new Actions(Az);
		WebElement propertyID = Az.findElement(By.xpath("//div[text()='CHANGE_ID']"));
		WebElement columnID = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[1]"));
		dragAndDropID.dragAndDrop(propertyID,columnID).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDrop2() throws InterruptedException {
		Actions dragAndDropTag = new Actions(Az);
		WebElement propertyTag = Az.findElement(By.xpath("//div[text()='CHANGE_GROUP']"));
		WebElement columnTag = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[2]"));
		dragAndDropTag.dragAndDrop(propertyTag,columnTag).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDrop3() throws InterruptedException {
		Actions dragAndDropDesc = new Actions(Az);
		WebElement propertyDesc = Az.findElement(By.xpath("//div[text()='CHANGE_OPERATION']"));
		WebElement columnDesc = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[3]"));
		dragAndDropDesc.dragAndDrop(propertyDesc,columnDesc).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDrop4() throws InterruptedException {
		Actions dragAndDropPath = new Actions(Az);
		WebElement propertyPath = Az.findElement(By.xpath("//div[text()='CHANGE_OPERATION_VALUE']"));
		WebElement columnPath = Az.findElement(By.xpath("//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[4]"));
		dragAndDropPath.dragAndDrop(propertyPath,columnPath).build().perform();
		Thread.sleep(1000);
	}
	
	public static void buttonImport() {
		WebElement buttonImport = Az.findElement(By.xpath("//td[text()='Import Manager']/ancestor::div[@class='windowHeader']/parent::div//div[text()='Import']"));
		buttonImport.click();
	}
}