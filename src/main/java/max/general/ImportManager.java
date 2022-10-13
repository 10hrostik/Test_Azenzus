package max.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ImportManager {
	
	WebDriver Az;
	
	public ImportManager(WebDriver Az) {
		this.Az = Az;
	}
	
	//e.g. dataType: STRUCTURE_RECORD, PRODUCT_INSTANCE, DOCUMENT_INSTANCE
	public void dataType(String dataType) {
		Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//tr[2]//div[@class='selectItemText']")).click();	
		Az.findElement(By.xpath("//div[text()='"+dataType+"']")).click();
	}
	
	//e.g. objectType: ASPECT_FUNCTION, EQUIPMENT
	public void objectType(String objectType) {
		Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//tr[3]//div[@class='selectItemText']")).click();	
		Az.findElement(By.xpath("//div[text()='"+objectType+"']")).click();
	}
	
	public void selctMetadata(String metaName) throws InterruptedException {
		Thread.sleep(500);
		Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//tr[5]//img[contains(@src,'add')]")).click();
		Thread.sleep(1000);
		WebElement searchFiled = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		searchFiled.clear();
		searchFiled.sendKeys(metaName);
		Az.findElement(By.xpath("//td[@class='buttonTitle']/div[text()='Search...']")).click();
		Thread.sleep(1000);
		Actions doubleClickOnMeta = new Actions(Az);
		WebElement meta = Az.findElement(By.xpath("//div[text()='"+metaName+"']"));
		doubleClickOnMeta.doubleClick(meta).perform();
	}
	
	public void chooseFile(String path) throws InterruptedException {
		Thread.sleep(500);
    	Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//input[@name='filename']")).sendKeys(path);
		Thread.sleep(500);
	}
	
	public void buttonPrepare() throws InterruptedException {
		Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//div[text()='Prepare']")).click();
		Thread.sleep(5000);
	}
	
	public void primaryKey() throws InterruptedException {
		Thread.sleep(3000);
		Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//tr[@aria-posinset='1']//span")).click();
		Thread.sleep(1000);
	}	
	
	//e.g. prop: ID, RDC_TAG, DESCRIPTION
	public void mapColumn(String prop, int column) throws InterruptedException {
		Actions dragAndDrop = new Actions(Az);
		WebElement property = Az.findElement(By.xpath("//div[text()='"+prop+"']"));
		WebElement columnOfFile = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySync')][last()-1]//tr[@aria-posinset='"+column+"']/td[@align='center']"));
		dragAndDrop.dragAndDrop(property, columnOfFile).build().perform();
		Thread.sleep(1000);
	}
	
	public void buttonImport() {
		WebElement buttonImport = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//div[text()='Import']"));
		buttonImport.click();
	}
	
	public void closeWhenCompleted() throws InterruptedException {
		GeneralMethods.closeProgressBar(Az);
		Thread.sleep(500);
		var buttonClose = Az.findElement(By.xpath("//div[contains(@eventproxy,'OneWaySyncManagerWindow')][last()-1]//img[contains(@src,'close.png')]"));
		buttonClose.click();
	}
}