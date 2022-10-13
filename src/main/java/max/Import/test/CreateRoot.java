package max.Import.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateRoot {
	
	private static WebDriver Az = ImportAllTest.Az;
	
	public static void root(String plant, String meta, String name) throws InterruptedException {
		selectPlant(plant);
		buttonAdd();
		selectMeta(meta);
		inputRootName(name);
		buttonOrder();
	}
	
	public static void selectPlant(String plant) throws InterruptedException {
		WebElement comboboxPlant = Az.findElement(By.xpath("//label[text()='Plant']/parent::span/following-sibling::table//div"));
		comboboxPlant.click();
		Thread.sleep(500);
		WebElement plantName = Az.findElement(By.xpath("//div[text()='"+plant+"'][@role='presentation']"));
		plantName.click();
		Thread.sleep(500);
	}
	
	public static void buttonAdd() throws InterruptedException {
		WebElement buttonAdd = Az.findElement(By.xpath("//img[contains(@src,'images/actions/add.png')]"));
		buttonAdd.click();
		Thread.sleep(500);
	}
	
	public static void selectMeta(String meta) throws InterruptedException {		
		WebElement fieldSearch = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		fieldSearch.clear();
		fieldSearch.sendKeys(meta);
		Az.findElement(By.xpath("//div[text()='Search...']")).click();
		Thread.sleep(2000);
		resizeColumn();
		WebElement metaRoot = Az.findElement(By.xpath("//div[text()='"+meta+"']"));
		Actions actionSelectMeta = new Actions(Az); 
		actionSelectMeta.doubleClick(metaRoot).perform();
		Thread.sleep(1000);
	}
	
	public static void resizeColumn() throws InterruptedException {
		//var buttonMaximize = Az.findElement(By.xpath("//img[contains(@src, 'maximize.png')]"));
		//buttonMaximize.click();
		Thread.sleep(1000);
		WebElement columnName = Az.findElement(By.xpath("//div[contains(@eventproxy, 'MetadataManagerWindow')]//div[@aria-label='Name']"));
		Actions actionAutoFit = new Actions(Az); 
		actionAutoFit.contextClick(columnName).perform();
		Az.findElement(By.xpath("//div[text()='Auto Fit']")).click();
		Thread.sleep(500);
	}
	
	public static void inputRootName(String name) throws InterruptedException {
		WebElement inputName = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'orderWizardAspectFirstWindow')][last()-1]//input[@name='name']"));
		inputName.clear();
		inputName.sendKeys(name);
		Thread.sleep(500);
	}
	
	public static void buttonOrder() throws InterruptedException {
		WebElement inputName = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'orderWizardAspectFirstWindow')][last()-1]//div[text()='Order']"));
		inputName.click();
		Thread.sleep(2000);
	}
}