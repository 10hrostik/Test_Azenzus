package max.Import.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import max.general.GeneralMethods;

public class DynamicImport {

	private static WebDriver Az = ImportAllTest.Az;
	
	public static void dataType(String dataType) {
		WebElement comboboxDataType = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//input[@name='dataType']/following-sibling::table//div[@class='selectItemText']"));
		comboboxDataType.click();	
		WebElement optionForDataType = Az.findElement(By.xpath("//div[text()='"+dataType+"']"));
		optionForDataType.click();
	}
	
	public static void objectType(String objectType) {
		WebElement comboboxObjectType = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//input[@name='kbObjectType']/following-sibling::table//div[@class='selectItemText']"));
		comboboxObjectType.click();	
		WebElement optionForObjectType = Az.findElement(By.xpath("//div[text()='"+objectType+"']"));
		optionForObjectType.click();
	}
	
	public static void selctMetadata(String metaName) throws InterruptedException {
		Thread.sleep(500);
		WebElement buttonSelectMeta = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//label[text()='Metadata']/ancestor::td/following-sibling::td//td[@class='formCell']//td[2]"));
		buttonSelectMeta.click();
		Thread.sleep(1000);
		WebElement searchFiled = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		searchFiled.clear();
		searchFiled.sendKeys(metaName);
		WebElement buttonSearch = Az.findElement(By.xpath("//td[@class='buttonTitle']/div[text()='Search...']"));
		buttonSearch.click();
		Thread.sleep(1000);
		CreateRoot.resizeColumn();
		Thread.sleep(1000);
		var doubleClickOnMeta = new Actions(Az);
		WebElement meta = Az.findElement(By.xpath("//div[text()='"+metaName+"']"));
		doubleClickOnMeta.doubleClick(meta).perform();
	}
	
	public static void chooseFile(String path) throws InterruptedException {
		Thread.sleep(500);
    	WebElement inputFileName = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//input[@name='filename']"));
		inputFileName.sendKeys(path);
		Thread.sleep(500);
	}
	
	public static void buttonPrepare() throws InterruptedException {
		WebElement buttonPrepare = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Prepare']"));
		buttonPrepare.click();
		Thread.sleep(5000);
	}
	
	public static void primaryKey() throws InterruptedException {
		Thread.sleep(3000);
		WebElement primary = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Primary']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[1]/td[2]/div"));
		primary.click();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropID() throws InterruptedException {
		var dragAndDropID = new Actions(Az);
		WebElement propertyID = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='ID']"));
		WebElement columnID = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div[1]//tbody/tr[1]"));
		dragAndDropID.dragAndDrop(propertyID,columnID).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropTag() throws InterruptedException {
		var dragAndDropTag = new Actions(Az);
		WebElement propertyTag = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='RDC_TAG']"));
		WebElement columnTag = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div[1]//tbody/tr[2]"));
		dragAndDropTag.dragAndDrop(propertyTag,columnTag).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropName() throws InterruptedException {
		var dragAndDropName = new Actions(Az);
		WebElement propertyName = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='NAME']"));
		WebElement columnName = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div[1]//tbody/tr[3]"));
		dragAndDropName.dragAndDrop(propertyName,columnName).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropDesc() throws InterruptedException {
		var dragAndDropDesc = new Actions(Az);
		WebElement propertyDesc = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='DESCRIPTION']"));
		WebElement columnDesc = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div[1]//tbody/tr[3]"));
		dragAndDropDesc.dragAndDrop(propertyDesc,columnDesc).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropPath() throws InterruptedException {
		var dragAndDropPath = new Actions(Az);
		WebElement propertyPath = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='PATH']"));
		WebElement columnPath = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div[1]//tbody/tr[4]"));
		dragAndDropPath.dragAndDrop(propertyPath,columnPath).build().perform();
		Thread.sleep(1000);
	}
	
	public static void dragAndDropPlant() throws InterruptedException {
		var dragAndDropPlant = new Actions(Az);
		WebElement propertyPath = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='PLANT_ID']"));
		WebElement columnPath = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Column']/ancestor::div[@class='headerBar']/following-sibling::div//tbody/tr[5]"));
		dragAndDropPlant.dragAndDrop(propertyPath,columnPath).build().perform();
		Thread.sleep(1000);
	}
	
	public static void buttonImport() {
		WebElement buttonImport = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Import']"));
		buttonImport.click();
	}
	
	public static void closeWhenCompleted() throws InterruptedException {
		GeneralMethods.closeProgressBar(Az);
		Thread.sleep(500);
		var buttonClose = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//img[contains(@src,'close.png')]"));
		buttonClose.click();
	}
}