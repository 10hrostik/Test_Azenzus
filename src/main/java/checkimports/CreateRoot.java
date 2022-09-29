package checkimports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.TreeStructure;

public class CreateRoot {
	
	private WebDriver Az;
	
	public CreateRoot(WebDriver Az) {
		this.Az = Az;
	}
	
	public void create(String meta, String name) throws InterruptedException {
		TreeStructure tree = new TreeStructure(Az);
		tree.buttonAdd();
		selectMeta(meta);
		inputRootName(name);
		buttonOrder();
	}
	
	private void selectMeta(String meta) throws InterruptedException {		
		searchMeta(meta);
		resizeColumn();
		WebElement metaRoot = Az.findElement(By.xpath("//div[text()='"+meta+"']"));
		Actions actionSelectMeta = new Actions(Az); 
		actionSelectMeta.doubleClick(metaRoot).perform();
		Thread.sleep(1000);
	}
	
	private void searchMeta(String meta) throws InterruptedException {
		WebElement fieldSearch = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		fieldSearch.clear();
		fieldSearch.sendKeys(meta);
		Az.findElement(By.xpath("//div[text()='Search...']")).click();
		Thread.sleep(2500);
	}
	
	private void resizeColumn() throws InterruptedException {
		WebElement columnName = Az.findElement(By.xpath("//div[contains(@eventproxy, 'MetadataManagerWindow')]//div[text()='Name']"));
		Actions actionAutoFit = new Actions(Az); 
		actionAutoFit.contextClick(columnName).perform();
		Az.findElement(By.xpath("//div[text()='Auto Fit']")).click();
		Thread.sleep(500);
	}
	
	private void inputRootName(String name) throws InterruptedException {
		WebElement inputName = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'orderWizardAspectFirstWindow')][last()-1]//input[@name='name']"));
		inputName.clear();
		inputName.sendKeys(name);
		Thread.sleep(500);
	}
	
	private void buttonOrder() throws InterruptedException {
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'orderWizardAspectFirstWindow')][last()-1]//div[text()='Order']")).click();
		Thread.sleep(2000);
	}
}